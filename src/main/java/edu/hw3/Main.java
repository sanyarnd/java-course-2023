package edu.hw3;

import edu.hw3.task4.ConvertToRoman;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private final static Logger LOGGER = LogManager.getLogger();

    private Main() {
    }

    public static void main(String[] args) {
        LOGGER.info(ConvertToRoman.convertToRoman(1));
    }
}
