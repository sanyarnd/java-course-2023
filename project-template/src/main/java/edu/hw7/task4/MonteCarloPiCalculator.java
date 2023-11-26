package edu.hw7.task4;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class MonteCarloPiCalculator {
    private final static double EPS = 1e-9;

    public static double calcPiApproximation(int pointTotalCount, int threadCount) throws InterruptedException {
        AtomicInteger circleCount = new AtomicInteger();
        Thread[] threads = new Thread[threadCount];
        int oneThreadIters = pointTotalCount / threadCount;

        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(() -> {
                int circleCountLocal = 0;
                for (int j = 0; j < oneThreadIters; j++) {
                    double x = ThreadLocalRandom.current().nextDouble(-1, 1);
                    double y = ThreadLocalRandom.current().nextDouble(-1, 1);

                    if (belongsToCircle(x, y)) {
                        ++circleCountLocal;
                    }
                }
                circleCount.addAndGet(circleCountLocal);
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        return 4.0 * circleCount.get() / pointTotalCount;
    }

    private static boolean belongsToCircle(double x, double y) {
        return x * x + y * y - 1 < EPS;
    }
}
