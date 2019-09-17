package com.chaochaogu.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * Properly synchronized cooperative thread termination
 *
 * @author chaochao Gu
 * @date 2019/9/17
 */
public class StopThread1 {

    private static boolean stopRequested;

    private static synchronized void requestStop() {
        stopRequested = true;
    }

    private static synchronized boolean stopRequseted() {
        return stopRequested;
    }

    public static void main(String[] args) throws InterruptedException {

        Thread backgroundThread = new Thread(() -> {

            int i = 0;
            while (!stopRequseted()) {
                i++;
            }
        });
        backgroundThread.start();
        TimeUnit.SECONDS.sleep(1L);
        requestStop();
    }
}
