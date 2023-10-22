package edu.hw2.Task2_3;

public interface Connection extends AutoCloseable {
    void execute(String command);
}
