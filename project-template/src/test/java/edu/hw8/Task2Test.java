package edu.hw8;

import edu.hw8.task2.FixedThreadPool;
import edu.hw8.task2.ThreadPool;
import org.junit.jupiter.api.Test;
import java.util.concurrent.CountDownLatch;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Task2Test {
    @Test
    void calculateSeveralFibonacciInParallel() {
        int threadsNum = 6;
        long trueValue = 21;
        final long[] results = new long[threadsNum];

        var cdLatch = new CountDownLatch(threadsNum);

        try (var threadPool = FixedThreadPool.create(threadsNum)) {
            for (int i = 0; i < threadsNum; i++) {
                final int index = i;
                threadPool.execute(() -> {
                    results[index] = calculateFibonacciRecSerial(8);
                    cdLatch.countDown();
                });
            }
            threadPool.start();
        }

        try {
            cdLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < threadsNum; i++) {
            assertEquals(results[i], trueValue);
        }
    }

    long calculateFibonacciRecSerial(int n) {
        if (n <= 1) {
            return n;
        }

        return calculateFibonacciRecSerial(n - 1) + calculateFibonacciRecSerial(n - 2);
    }

    // не работает
    @Test
    void calculateFibonacciInParallel() {
        int threadsNum = 6;
        long trueValue = 21;

        try (var threadPool = FixedThreadPool.create(threadsNum)) {
            threadPool.start();
            long result = calculateFibonacciRecParal(8, threadPool);
            assertEquals(trueValue, result);
        }
    }

    long calculateFibonacciRecParal(int n, ThreadPool threadPool) {
        if (n <= 1) {
            return n;
        }

        final var temp = new long[2];
        var cdLatch = new CountDownLatch(2);

        threadPool.execute(() -> {
            temp[0] = calculateFibonacciRecParal(n - 1, threadPool);
            cdLatch.countDown();
        });
        threadPool.execute(() -> {
            temp[1] = calculateFibonacciRecParal(n - 2, threadPool);
            cdLatch.countDown();
        });

        try {
            cdLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return temp[0] + temp[1];
    }
}
