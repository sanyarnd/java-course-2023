package edu.hw2.task3;

import java.util.Random;

@SuppressWarnings("MagicNumber")
public class DefaultConnectionManager implements ConnectionManager {
    private final double frequency;

    public DefaultConnectionManager(double frequency) {
        this.frequency = frequency;
    }

    @Override
    public Connection getConnection() {
        if (new Random().nextDouble(225.25) < frequency) {
            return new FaultyConnection(frequency);
        } else {
            return new StableConnection();
        }
    }
}
