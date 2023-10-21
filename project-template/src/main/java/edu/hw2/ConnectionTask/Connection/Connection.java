package edu.hw2.ConnectionTask.Connection;

public interface Connection extends AutoCloseable {
    void execute(String command);
}
