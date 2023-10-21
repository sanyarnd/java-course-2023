package edu.hw2.Task3;

import java.util.Random;

public class DefaultConnectionManager implements ConnectionManager {
    private static final double FAULTY_CONNECTION_PROBABILITY = 0.3; // 30% вероятность проблемного соединения

    @Override
    public Connection getConnection() {
        if (new Random().nextDouble() < FAULTY_CONNECTION_PROBABILITY) {
            return new FaultyConnectionImpl();
        } else {
            return new StableConnectionImpl();
        }
    }
}
