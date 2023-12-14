package org.example.lecture;

import java.util.concurrent.Semaphore;
import java.util.stream.Stream;

public class SemaphoreExample {

    private static class Worker extends Thread {

        private final Semaphore semaphore;

        private Worker(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("acquire semaphore " + Thread.currentThread().getName());
                System.out.println("work " + Thread.currentThread().getName());
                threadSleep();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                System.out.println("release semaphore " + Thread.currentThread().getName());
                semaphore.release();
            }


        }
    }

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        Stream.generate(() -> new Worker(semaphore))
            .limit(10)
            .forEach(Thread::start);

    }

    private static void threadSleep() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
