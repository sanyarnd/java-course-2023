package org.example.lecture;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class CountDownLatchExample {

    private static class Worker implements Runnable {

        private final CountDownLatch latch;

        private Worker(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            randomSleep();
            System.out.println("Prepare to start execution " + Thread.currentThread().getName());
            latch.countDown();
            try {
                latch.await();
                randomSleep();
                System.out.println("Do some work " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        private void randomSleep() {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextLong(300, 1000));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(5);
        Stream.generate(() -> new Thread(new Worker(latch)))
            .limit(5)
            .forEach(Thread::start);
    }

}
