package com.yzd.attach;

import java.io.*;
import java.lang.instrument.ClassDefinition;
import java.lang.instrument.Instrumentation;
import java.lang.reflect.Field;

/***
 * https://www.jianshu.com/p/9c64ac59800e
 * @author : yanzhidong
 * @date : 2020/6/23 
 * @version : V1.0
 *
 */
public class HotSwapAgent {

    public static void agentmain(String agentArgs, Instrumentation inst) {
        long startTime = System.currentTimeMillis();
        Class<?> clz = null;
        DataInputStream dis = null;
        try {
            // 通过反射，拿到需要更新的数据
            clz = Class.forName("com.yzd.attach.HotSwapService");
            Field field = clz.getField("updateBytes");
            byte[] updateBytes = (byte[]) field.get(null);

            dis = new DataInputStream(new ByteArrayInputStream(updateBytes));

            // 读取文件的数量
            int size = dis.readInt();
            ClassDefinition[] classDefinitions = new ClassDefinition[size];
            for (int i = 0; i < size; i++) {
                String className = dis.readUTF();
                int length = dis.readInt();
                byte[] bytes = new byte[length];
                dis.readFully(bytes);
                ClassDefinition classDefinition = new ClassDefinition(Class.forName(className), bytes);
                classDefinitions[i] = classDefinition;
            }
            // 开始热更新
            inst.redefineClasses(classDefinitions);

            // 设置更新标识
            Field successField = clz.getField("success");
            successField.set(null, true);

            // 计算更新消耗时间
            long totalTime = System.currentTimeMillis() - startTime;
            Field totalTimeFile = clz.getField("totalTime");
            totalTimeFile.set(null, totalTime);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                dis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
