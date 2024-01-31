package org.example;

public class ThreadStartExample {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("Hello from a thread!");
            System.out.println("I'm happens before the thread.join()!");
        });
        thread.start();
    }

}
