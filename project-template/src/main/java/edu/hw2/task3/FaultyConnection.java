package edu.hw2.task3;

import java.util.concurrent.ThreadLocalRandom;
public class FaultyConnection implements Connection{
    @Override
    public void execute(String command) {
        if (ThreadLocalRandom.current().nextInt(0, 2) == 1) {
            throw new ConnectionException();
        }
    }

    @Override
    public void close() throws Exception {

    }
}
