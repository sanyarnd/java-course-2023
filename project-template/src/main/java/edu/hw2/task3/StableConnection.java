package edu.hw2.task3;

public class StableConnection implements Connection {
    private boolean closed = false;

    @Override
    public void execute(String command) {
        if (closed) {
            throw new IllegalStateException("Connection is closed");
        }
        System.out.println("Executing command on stable connection: " + command);
    }

    @Override
    public void close() {
        System.out.println("Closing stable connection");
        closed = true;
    }
}
