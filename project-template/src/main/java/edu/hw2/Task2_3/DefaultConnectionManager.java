package edu.hw2.Task2_3;

import java.util.Random;

public class DefaultConnectionManager implements ConnectionManager {
    private final Random random = new Random();

    @Override
    public Connection getConnection() {
        if (random.nextInt(100) < 50) {
            return new FaultyConnection();
        } else {
            return new StableConnection();
        }
    }
}
