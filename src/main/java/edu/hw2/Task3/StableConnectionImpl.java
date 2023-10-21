package edu.hw2.Task3;

import java.util.logging.Logger;

public class StableConnectionImpl implements StableConnection {
    private static final Logger LOGGER = Logger.getLogger(StableConnectionImpl.class.getName());

    @Override
    public void execute(String command) {
        // реализация для стабильного соединени
        LOGGER.info("Executing command in Stable Connection: " + command);
    }

    @Override
    public void close() {
        // реализация закрытия соединения
        LOGGER.info("Stable connection closed successfully");
    }
}

