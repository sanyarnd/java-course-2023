package org.example;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Stream;

public class MonitorLockRuleExample {

    private static class Box {
        private final Lock lock = new ReentrantLock(true);
        private long value = 0;

        public void increase(int diff) {
            lock.lock();
            try {
                this.value += diff;
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Box box = new Box();
        var futures = Stream.generate(() -> CompletableFuture.runAsync(() -> box.increase(1)))
            .limit(10)
            .toArray(CompletableFuture[]::new);
        CompletableFuture.allOf(futures).join();
        System.out.println(box.value);
    }

}
