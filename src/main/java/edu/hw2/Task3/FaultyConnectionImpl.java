package edu.hw2.Task3;

import java.io.IOException;
import java.util.Random;
import java.util.logging.Logger;

public class FaultyConnectionImpl implements FaultyConnection {
    private static final double FAILURE_PROBABILITY = 0.9; // 90% вероятность ошибки
    private static final Logger LOGGER = Logger.getLogger(FaultyConnectionImpl.class.getName());

    @Override
    public void execute(String command) {
        if (new Random().nextDouble() < FAILURE_PROBABILITY) {
            throw new ConnectionException("Connection FAILED", new IOException("The Connection FAILED"));
        }
        // Реализация для проблемного соединения
        LOGGER.info("Executing command in Faulty Connection: " + command);
    }

    @Override
    public void close() {
        // Реализация закрытия соединения
        LOGGER.info("Faulty Connection closed successfully");
    }
}
