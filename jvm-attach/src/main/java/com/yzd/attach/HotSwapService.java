package com.yzd.attach;

import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.classfile.ClassFile;

import java.io.*;
import java.lang.management.ManagementFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/***
 *
 * @author : yanzhidong
 * @date : 2020/6/23 
 * @version : V1.0
 *
 */
public class HotSwapService {

    /**
     * 需要热更新的数据
     */
    public static volatile byte[] updateBytes;

    public static volatile boolean success = false;

    public static volatile long totalTime;

    private static final HotSwapService instance = new HotSwapService();

    public HotSwapService() {

    }

    // 简单单例
    public static HotSwapService getInstance() {
        return instance;
    }

    /**
     * @param files 热更新变化文件
     */
    public void tryHotSwap(Set<File> files) {
        try {

            if (files == null || files.isEmpty()) {
                return;
            }
            Map<String, ClassFileInfo> classFileInfoMap = new HashMap<>();

            for (File file : files) {
                String className = getClassName(file);
                if ("".equals(className)) {
                    continue;
                }
                byte[] fileBytes = getFileBytes(file);
                classFileInfoMap.put(className, new ClassFileInfo(className, fileBytes));

            }

            if (classFileInfoMap.isEmpty()) {
                return;
            }
            // 把更新的文件，转化为字节数组
            ByteArrayOutputStream baos = new ByteArrayOutputStream(1024);
            DataOutputStream dos = new DataOutputStream(baos);
            dos.writeInt(classFileInfoMap.size());
            for (ClassFileInfo classFileInfo : classFileInfoMap.values()) {
                dos.writeUTF(classFileInfo.getFileName());
                byte[] data = classFileInfo.getData();
                dos.writeInt(data.length);
                dos.write(data);
            }
            dos.flush();
            updateBytes = baos.toByteArray();
            success = false;
            // 通知更新
            noticeUpdate();

            // 更新成功，update会通过反射被修改
            if (success) {
                for (ClassFileInfo classFileInfo : classFileInfoMap.values()) {
                    System.out.println("类" + classFileInfo.getFileName() + "更新成功");
                }
                System.out.println("消耗时间" + totalTime + "ms");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            updateBytes = null;
        }


    }

    /**
     * 通知更新
     */
    public void noticeUpdate() {
        VirtualMachine virtualMachine = null;
        String pid = ManagementFactory.getRuntimeMXBean().getName().split("@")[0];
        try {
            virtualMachine = VirtualMachine.attach(pid);
            virtualMachine.loadAgent(getAgentJarPath(), "");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                virtualMachine.detach();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 文件转化为字节数组
     *
     * @param file
     * @return
     */
    public static byte[] getFileBytes(File file) {
        FileInputStream fileInputStream;
        byte[] bytes = null;
        try {
            fileInputStream = new FileInputStream(file);
            bytes = new byte[fileInputStream.available()];
            fileInputStream.read(bytes);
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;

    }

    /**
     * 获取class的名字
     *
     * @param file
     * @return
     * @throws Exception
     */
    private String getClassName(File file) throws Exception {
        if (file.getName().endsWith(".class")) {
            ClassFile cf = ClassFile.read(file);
            return cf.getName().replaceAll("/", ".");
        }
        return "";

    }

    /**
     * 默认的热更新目录
     *
     * @return
     */
    public String getHotSwap() {
        String workPlace = System.getProperty("user.dir");
        return workPlace + File.separator + "classes";
    }

    public String getAgentJarPath() {
        return "/Users/zengzehao/Downloads/hotswap.jar";
    }
}
