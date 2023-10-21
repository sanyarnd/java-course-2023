package edu.hw2.ConnectionTask.Managers;

import edu.hw2.ConnectionTask.Connection.Connection;
import edu.hw2.ConnectionTask.ConnectionException;

public interface ConnectionManager {
    Connection getConnection() throws ConnectionException;
}
