package edu.hw2.task3;

public class FaultyConnection implements Connection {
    @Override
    public void execute(String command) {
//        if (ThreadLocalRandom.current().nextInt(0, 1) == 1) {1
            throw new ConnectionException();
//        }
    }

    @Override
    public void close() throws Exception {
    }
}
