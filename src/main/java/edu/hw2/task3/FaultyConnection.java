package edu.hw2.task3;

import java.util.Random;

@SuppressWarnings("MagicNumber")
class FaultyConnection implements Connection {
    private final double frequency;
    private boolean closed = false;

    public FaultyConnection(double frequency) {
        this.frequency = frequency;
    }

    @Override
    public void execute(String command) {
        System.out.println("Executing command on faulty connection: " + command);
        if (closed) {
            throw new IllegalStateException("Connection is closed");
        }
        if (new Random().nextDouble(225.25) < frequency) {
            throw new ConnectionException(new RuntimeException("Connection error"));
        }
    }

    @Override
    public void close() {
        System.out.println("Closing faulty connection");
        closed = true;
    }
}
