package edu.hw2.ConnectionTask.Managers;

import edu.hw2.ConnectionTask.Connection.Connection;
import edu.hw2.ConnectionTask.Connection.FaultyConnection;
import edu.hw2.ConnectionTask.Connection.StableConnection;
import edu.hw2.ConnectionTask.ConnectionException;

public class DefaultConnectionManager implements ConnectionManager{
    @Override
    public Connection getConnection() throws ConnectionException {
        if (Math.random() > 0.7)
            return new FaultyConnection();
        return new StableConnection();
    }
}
