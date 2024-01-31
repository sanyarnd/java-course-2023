package org.example.lecture;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class CyclicBarierExample {

    private static class Worker implements Runnable {

        private final CyclicBarrier barrier;

        private Worker(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            randomSleep();
            System.out.println("Prepare to start execution " + Thread.currentThread().getName());
            randomSleep();
            System.out.println("Rich common point and waiting other workers " + Thread.currentThread().getName());
            try {
                barrier.await();
                System.out.println("Do some work " + Thread.currentThread().getName());
            } catch (BrokenBarrierException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3);
        Stream.generate(() -> new Thread(new Worker(barrier)))
            .limit(6)
            .forEach(Thread::start);
    }

    private static void randomSleep() {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextLong(800, 3000));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
