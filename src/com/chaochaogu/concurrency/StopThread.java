package com.chaochaogu.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * Broken! - How long would you expect this program to run?
 *
 * @author chaochao Gu
 * @date 2019/9/17
 */
public class StopThread {

    private static boolean stopRequested;

    public static void main(String[] args) throws InterruptedException {

        Thread backgroundThread = new Thread(() -> {

            int i = 0;
            while (!stopRequested) {
                i++;
            }

        });
        backgroundThread.start();
        TimeUnit.SECONDS.sleep(1L);
        stopRequested = true;
    }
}
