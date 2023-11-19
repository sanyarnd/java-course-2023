package edu.hw2.task3;

public interface Connection extends AutoCloseable {
    void execute(String command);
}
