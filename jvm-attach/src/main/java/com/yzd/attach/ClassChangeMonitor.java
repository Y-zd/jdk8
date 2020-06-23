package com.yzd.attach;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

/***
 *
 * @author : yanzhidong
 * @date : 2020/6/23 
 * @version : V1.0
 *
 */
public class ClassChangeMonitor {

    private FileAlterationMonitor monitor;

    private HotSwapService hotSwapService;


    public void start(String path) throws Exception {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdir();
        }
        FileAlterationObserver observer = new FileAlterationObserver(file);
        observer.addListener(new FileAlterationListenerAdaptor() {

            private boolean changed = false;
            private Set<File> files = new HashSet<>();

            @Override
            public void onStart(FileAlterationObserver observer) {
                changed = false;
                files.clear();
            }

            @Override
            public void onFileChange(File file) {
                changed = true;
                files.add(file);
            }

            @Override
            public void onFileCreate(File file) {
                changed = true;
                files.add(file);
            }

            @Override
            public void onStop(FileAlterationObserver observer) {
                if (changed) {
                    tryHotSwap(files);
                }
            }

            private void tryHotSwap(Set<File> files) {
                hotSwapService.tryHotSwap(files);
            }
        });

        monitor = new FileAlterationMonitor(3000, observer);
        monitor.start();
    }

    public void stop() {
        if (monitor != null) {
            try {
                monitor.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public HotSwapService getHotSwapService() {
        return hotSwapService;
    }

    public void setHotSwapService(HotSwapService hotSwapService) {
        this.hotSwapService = hotSwapService;
    }

}
