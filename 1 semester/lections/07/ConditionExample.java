package org.example.lecture;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionExample {

    private static class CustomBlockingQueue<T> {

        private final Queue<T> queue = new ArrayDeque<>();
        private final ReentrantLock lock = new ReentrantLock();
        private final Condition notEmpty = lock.newCondition();
        private final Condition notFull = lock.newCondition();
        private final int capacity;

        public CustomBlockingQueue(int capacity) {
            this.capacity = capacity;
        }

        public void push(T e) throws InterruptedException {
            lock.lock();
            try {
                while(queue.size() == capacity) {
                    notFull.await();
                }
                queue.add(e);
                notEmpty.signalAll();
            } finally {
                lock.unlock();
            }
        }

        public T poll() throws InterruptedException {
            lock.lock();
            try {
                while(queue.isEmpty()) {
                    notEmpty.await();
                }
                return queue.poll();
            } finally {
                notFull.signalAll();
                lock.unlock();
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        CustomBlockingQueue<String> queue = new CustomBlockingQueue<>(4);
        new Thread(() -> {
            System.out.println("Start");
            String value;
            try {
                value = queue.poll();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("End value " + value);
        }).start();
        queue.push("123");
    }

}
