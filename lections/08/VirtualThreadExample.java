package org.example;

public class VirtualThreadExample {

    public static void main(String[] args) {
        for (int i = 0; i < 100_000_000; i++) {
            Thread.ofPlatform().start(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            System.out.println(i);
        }
    }
}
