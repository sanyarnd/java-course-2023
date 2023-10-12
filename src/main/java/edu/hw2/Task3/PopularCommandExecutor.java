package edu.hw2.Task3;

import java.util.logging.Logger;

public final class PopularCommandExecutor {
    private final ConnectionManager manager;
    private final int maxAttempts;
    private static final Logger LOGGER = Logger.getLogger(PopularCommandExecutor.class.getName());

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages() {
        tryExecute("apt update && apt upgrade -y");
    }

    private void tryExecute(String command) throws ConnectionException {
        int attempts = 0;
        Exception lastException = null;
        while (attempts < maxAttempts) {
            try (Connection connection = manager.getConnection()) { // try with resources
                LOGGER.info("Trying to execute:");
                connection.execute(command);
                return;
            } catch (ConnectionException e) {
                lastException = e;
                LOGGER.info(e.toString());
            } catch (Exception e) {
                throw new ConnectionException("Failed to execute  command after "
                    + attempts + " attempt", new Exception());
            }
            attempts++;
        }
        throw new ConnectionException("Failed to execute command after " + maxAttempts + " attempts", lastException);
    }
}
