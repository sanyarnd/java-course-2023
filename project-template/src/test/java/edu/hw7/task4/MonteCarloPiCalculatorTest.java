package edu.hw7.task4;

import org.junit.jupiter.api.Test;
import java.util.concurrent.TimeUnit;
import static edu.hw7.task4.MonteCarloPiCalculator.calcPiApproximation;

class MonteCarloPiCalculatorTest {
    @Test
    void measure() throws InterruptedException {
        final int[] pointCountArr = {(int) 1e7, (int) 1e8, (int) 1e9};
        final int[] threadCountArr = {1, 6};
        final int experiments = 5;

        for (int i = 0; i < pointCountArr.length; i++) {
            int pointCount = pointCountArr[i];

            for (int j = 0; j < threadCountArr.length; j++) {
                int threadCount = threadCountArr[j];
                long timeSum = 0;
                double piAproxSum = 0;

                for (int k = 0; k < experiments; k++) {
                    var timeStart = System.nanoTime();
                    double piAprox = calcPiApproximation(pointCount, threadCount);
                    piAproxSum += piAprox;
                    timeSum += System.nanoTime() - timeStart;
                }

                System.out.println(TimeUnit.NANOSECONDS.toMillis(timeSum / experiments) + " ms");
                System.out.printf("Points total: %e \n", (float) pointCount);
                System.out.println("Threads: " + threadCount);
                double piCalculated = piAproxSum / experiments;
                System.out.println("Aproximated PI: " + piCalculated);
                System.out.println("Error: " + (Math.abs(piCalculated - Math.PI) / Math.PI * 100) + "%");
                System.out.println();
            }
        }
    }
}
