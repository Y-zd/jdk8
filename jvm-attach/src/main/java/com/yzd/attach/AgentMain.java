package com.yzd.attach;

/***
 *
 * @author : yanzhidong
 * @date : 2020/6/23 
 * @version : V1.0
 *
 */
public class AgentMain {
    public static void main(String[] args) throws Exception {

        // 文件变化监控线程
        ClassChangeMonitor monitor = new ClassChangeMonitor();
        HotSwapService instance = HotSwapService.getInstance();
        monitor.setHotSwapService(instance);
        monitor.start(instance.getHotSwap());

        // 热更新测试代码
//        new Thread(new HotSwapTestTask()).start();

    }
}
