package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task2 {
    private final static Logger LOGGER = LogManager.getLogger();

    public static int countDigits(int num) {
        if (num == Integer.MIN_VALUE) {
            return 10;
        }

        int r = 1;
        if (num < 0) {
            num = Math.abs(num);
        }
        while (num > 9) {
            r++;
            num /= 10;
        }
        return r;
    }

    public static void main(String[] args) {
        LOGGER.info(countDigits(424));
        LOGGER.info(countDigits(23413));
        LOGGER.info(countDigits(93781293));
        LOGGER.info(countDigits(0));
        LOGGER.info(countDigits(14));
        LOGGER.info(countDigits(-10));
    }
}
