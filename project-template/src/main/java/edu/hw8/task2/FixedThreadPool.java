package edu.hw8.task2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FixedThreadPool implements ThreadPool {
    private final BlockingQueue<Runnable> taskQueue;
    private final Thread[] threads;
    private final int threadsNum;

    private FixedThreadPool(int threadsNum) {
        this.taskQueue = new LinkedBlockingQueue<>();
        this.threads = new Thread[threadsNum];
        this.threadsNum = threadsNum;
    }

    public static FixedThreadPool create(int threadsNum) {
        return new FixedThreadPool(threadsNum);
    }

    @Override
    public void start() {
        for (int i = 0; i < threadsNum; i++) {
            threads[i] = new Thread(() -> {
                try {
                    while (!Thread.interrupted()) {
                        taskQueue.take().run();
                    }
                } catch (InterruptedException e) {
                }
            });
            threads[i].start();
        }
    }

    @Override
    public void execute(Runnable task) {
        try {
            taskQueue.put(task);
        } catch (InterruptedException e) {
        }
    }

    @Override
    public void close() {
        for (Thread thread : threads) {
            thread.interrupt();
        }
    }
}
