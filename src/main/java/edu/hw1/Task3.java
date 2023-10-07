package edu.hw1;

import java.util.logging.Logger;

public final class Task3 {
    private Task3() {

    }

    private static final Logger LOGGER = Logger.getLogger(Task3.class.getName());

    @SuppressWarnings({"uncommentedmain", "checkstyle:magicnumber"})
    public static void main(String[] args) {
        LOGGER.info("Number of digits in 4666: " + countDigits(4666)); // 4
        LOGGER.info("Number of digits in 544: " + countDigits(-123));   // 3
        LOGGER.info("Number of digits in 0: " + countDigits(0));       // 1
    }

    @SuppressWarnings("checkstyle:magicnumber")
    public static int countDigits(int num) {
        int number = num;
        if (number == 0) {
            return 1; // если число равно 0, то у него 1 цифра
        }

        int count = 0;
        while (number != 0) {
            number = number / 10; // делаем число меньше на один разряд
            count++; // увеличиваем счетчик цифр
        }

        return count;
    }
}
