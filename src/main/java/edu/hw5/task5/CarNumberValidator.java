package edu.hw5.task5;

import java.util.regex.Pattern;

public class CarNumberValidator {
    public static boolean validateCarNumber(String carNumber) {
        String regex = "^[А-Я]{1}\\d{3}[А-Я]{2}\\d{3}$";
        return Pattern.matches(regex, carNumber);
    }
}
