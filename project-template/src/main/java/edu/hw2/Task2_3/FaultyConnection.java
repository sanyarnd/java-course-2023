package edu.hw2.Task2_3;

import java.util.Random;

public class FaultyConnection implements Connection {
    private final Random random = new Random();

    @Override
    public void execute(String command) {
        if (random.nextInt(100) < 30) { // 30% шанс на ошибку
            throw new ConnectionException();
        }
        System.out.println("Executing: " + command);
    }

    @Override
    public void close() {
        System.out.println("Faulty connection closed");
    }
}
