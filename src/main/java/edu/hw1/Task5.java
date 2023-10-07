package edu.hw1;

import java.util.logging.Logger;

public final class Task5 {
    private Task5() {
    }

    private static final Logger LOGGER = Logger.getLogger(Task5.class.getName());

    @SuppressWarnings({"uncommentedmain", "checkstyle:magicnumber"})
    public static void main(String[] args) {
        LOGGER.info(fixString("123456")); // 214365
    }

    public static String fixString(String input) {
        char[] characters = input.toCharArray();
        for (int i = 0; i < characters.length - 1; i += 2) {
            char temp = characters[i];
            characters[i] = characters[i + 1];
            characters[i + 1] = temp;
        }
        return new String(characters);
    }
}
