package org.example.lecture;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class ProducerConsumerExample {

    private static final BlockingQueue<Integer> queue = new LinkedBlockingDeque<>(5);

    public static void main(String[] args) {
        Stream.generate(() -> new Thread(ProducerConsumerExample::produce))
            .limit(3)
            .forEach(Thread::start);
        Stream.generate(() -> new Thread(ProducerConsumerExample::consume))
            .limit(2)
            .forEach(Thread::start);
    }

    private static void produce() {
        while (true) {
            int value = ThreadLocalRandom.current().nextInt(100, 1000);
            try {
                randomSleep();
                queue.put(value);
                System.out.printf("[%s] Produce value = %d%n", Thread.currentThread().getName(), value);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    private static void consume() {
        while (true) {
            try {
                randomSleep();
                int value = queue.take();
                System.out.printf("[%s] Consume value = %d%n", Thread.currentThread().getName(), value);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    private static void randomSleep() {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextLong(300, 1000));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
