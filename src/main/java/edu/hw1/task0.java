package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class task0 {
    private final static Logger LOGGER = LogManager.getLogger(task0.class.getName());
    public static void output(){
        LOGGER.info("Пивет, мир!");
    }
}
