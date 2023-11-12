package edu.hw2.task3;

public final class PopularCommandExecutor {
    private final ConnectionManager manager;
    private final int maxAttempts;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages() {
        tryExecute("apt update && apt upgrade -y");
    }

    public void tryExecute(String command) {
        Connection connection = null;
        int attempts = 0;
        while (attempts < maxAttempts) {
            try {
                connection = manager.getConnection();
                connection.execute(command);
                return;
            } catch (ConnectionException e) {
                attempts++;
            }
        }
        throw new ConnectionException(new RuntimeException(
            "Failed to execute command after " + maxAttempts + " attempts"));
    }
}
