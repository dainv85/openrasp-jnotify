package com.fuxi.javaagent.contentobjects.jnotify.test;

import com.fuxi.javaagent.contentobjects.jnotify.JNotify;
import com.fuxi.javaagent.contentobjects.jnotify.JNotifyListener;
import com.fuxi.javaagent.contentobjects.jnotify.Observer;

import java.io.File;

public class TestMain {
    public static void main(String[] args) throws Exception {
        System.out.println("start TestMain");
        int mask = JNotify.FILE_WRITE_COMPLETED;
        boolean watchSubtrue = false;
        if (args.length > 0) {
            JNotify.init(args[0], new Observer() {
                public void update(String message) {
                }
            });
        } else {
            JNotify.init("/lib64", new Observer() {
                public void update(String message) {
                }
            });
        }

        int watch = JNotify.addWatch("/home/dainv85/Downloads/tests", mask, watchSubtrue, new JNotifyListener() {
            @Override
            public void fileCreated(int i, String s, String s1) {
                System.out.println("fileCreated "+ s + File.separator + s1);
            }

            @Override
            public void fileDeleted(int i, String s, String s1) {
                System.out.println("fileDeleted "+ s + File.separator + s1);
            }

            @Override
            public void fileModified(int i, String s, String s1) {
                System.out.println("fileModified "+ s + File.separator + s1);
            }

            @Override
            public void fileRenamed(int i, String s, String s1, String s2) {
                System.out.println("fileRenamed "+ s + File.separator + s1);
            }

            @Override
            public void fileWriteCompleted(int i, String s, String s1) {
                System.out.println("fileWriteCompleted "+ s + File.separator + s1);
            }
        });

        while (true) {
            try {
                Thread.sleep(1000);
            } catch (Exception ex) {
            }
        }

    }
}
