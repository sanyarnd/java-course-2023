package edu.hw2.task3;

public class FaultyConnectionManager implements ConnectionManager {
    private final double frequency;

    public FaultyConnectionManager(double frequency) {
        this.frequency = frequency;
    }

    @Override
    public Connection getConnection() {
        return new FaultyConnection(frequency);
    }
}
