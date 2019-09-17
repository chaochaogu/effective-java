package com.chaochaogu.concurrency;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author chaochao Gu
 * @date 2019/9/17
 */
public class Main {

    // Broken! - requires synchronization
    private static volatile int nextSerialNumber = 0;

    public static int generateSerialNumber() {
        return nextSerialNumber++;
    }

    // Lock-free synchronization with java.util.concurrent.atomic
    private static final AtomicLong nextSerialNum = new AtomicLong();

    public static long getNextSerialNum() {
        return nextSerialNum.getAndIncrement();
    }
}
