package com.chaochaogu.concurrencytool;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/**
 * @author chaochao Gu
 * @date 2019/9/26
 */
public class Main {

    public static void main(String[] args) {

    }

    // Concurrent canonicalizing map atop ConcurrentMap - not optimal
    public static String intern(String s) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        String previousValue = map.putIfAbsent(s, s);
        return previousValue == null ? s : previousValue;
    }

    // Concurrent canonicalizing map atop ConcurrentMap - faster!
    public static String intern1(String s) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        String result = map.get(s);
        if (result == null) {
            result = map.putIfAbsent(s, s);
            if (result == null) {
                result = s;
            }
        }
        return result;
    }

    // Simple framework for timing concurrent execution
    public static long time(Executor executor, int concurrency, Runnable action) throws InterruptedException {
        CountDownLatch ready = new CountDownLatch(concurrency);
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch done = new CountDownLatch(concurrency);
        for (int i = 0; i < concurrency; i++) {
            executor.execute(() -> {
                ready.countDown();
                // Tell timer we're ready
                try {
                    start.await();
                    // Wait till peers are ready
                    action.run();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    done.countDown();
                    // Tell timer we're done
                }
            });
        }
        ready.await();
        // Wait for all workers to be ready
        long startNanos = System.nanoTime();
        start.countDown();
        // And they're off!
        done.await();
        // Wait for all workers to finish
        return System.nanoTime() - startNanos;
    }
}
