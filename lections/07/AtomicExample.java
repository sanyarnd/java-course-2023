package org.example.lecture;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {

    public static void main(String[] args) {
        var value = new AtomicInteger();
        var incrementor = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) {
                value.incrementAndGet();
            }
        });
        var decrementor = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) {
                value.decrementAndGet();
            }
        });
        incrementor.start();
        decrementor.start();

        try {
            incrementor.join();
            decrementor.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(value.get());
    }

}
