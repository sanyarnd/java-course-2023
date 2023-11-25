package edu.hw7;

import java.util.concurrent.atomic.AtomicInteger;

public class Task1 {
    public static int count(int threadNum, int incrNum) throws InterruptedException {
        AtomicInteger counter = new AtomicInteger();
        Thread[] threads = new Thread[threadNum];

        for (int i = 0; i < threadNum; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < incrNum; j++) {
                    counter.incrementAndGet();
                }
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        return counter.get();
    }
}
