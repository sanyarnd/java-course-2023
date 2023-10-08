package edu.hw1;

import java.util.logging.Logger;

public final class Task0 {
    private Task0() {
    }

    private static final Logger LOGGER = Logger.getLogger(Task0.class.getName());

    public static void printHelloWorld() {
        LOGGER.info("Привет, мир!");
    }
}
