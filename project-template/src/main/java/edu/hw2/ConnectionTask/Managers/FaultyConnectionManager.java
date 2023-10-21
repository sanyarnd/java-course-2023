package edu.hw2.ConnectionTask.Managers;

import edu.hw2.ConnectionTask.Connection.Connection;
import edu.hw2.ConnectionTask.Connection.FaultyConnection;
import edu.hw2.ConnectionTask.ConnectionException;

public class FaultyConnectionManager implements ConnectionManager {
    @Override
    public Connection getConnection() throws ConnectionException {
        return new FaultyConnection();
    }
}
