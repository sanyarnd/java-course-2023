package edu.hw1;

import java.util.logging.Logger;

public final class Task1 {
    private Task1() {
    }

    private static final Logger LOGGER = Logger.getLogger(Task1.class.getName());

    public static void printHelloWorld() {
        LOGGER.info("Привет, мир!");
    }
}
