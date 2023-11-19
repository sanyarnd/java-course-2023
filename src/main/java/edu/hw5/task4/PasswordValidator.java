package edu.hw5.task4;

import java.util.regex.Pattern;

public class PasswordValidator {
    public static boolean validatePassword(String password) {
        String regex = ".*[~!@#$%^&*|].*";
        return Pattern.matches(regex, password);
    }
}
