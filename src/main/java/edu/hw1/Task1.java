package edu.hw1;

import java.util.logging.Logger;

public class Task1 {
    private Task1() {
    }

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        printHelloWorld();
    }

    public static void printHelloWorld() {
        LOGGER.info("Привет, мир!");
    }
}
