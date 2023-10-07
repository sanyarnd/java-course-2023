package edu.hw1;

import java.util.logging.Logger;

public final class Task6 {
    private Task6() {
    }

    private static final Logger LOGGER = Logger.getLogger(Task6.class.getName());

    @SuppressWarnings({"uncommentedmain", "checkstyle:magicnumber"})
    public static void main(String[] args) {
        LOGGER.info(String.valueOf(isPalindromeDescendant("11211230"))); // true
    }

    @SuppressWarnings("checkstyle:magicnumber")
    public static boolean isPalindromeDescendant(String number) {
        String num = number;
        while (num.length() > 1) {
            if (isPalindrome(num)) {
                return true;
            }
            num = calculateDescendant(num);
        }
        return false;
    }

    public static boolean isPalindrome(String number) {
        return number.equals(new StringBuilder(number).reverse().toString());
    }

    public static String calculateDescendant(String numStr) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numStr.length() - 1; i += 2) {
            int digit1 = Character.getNumericValue(numStr.charAt(i));
            int digit2 = Character.getNumericValue(numStr.charAt(i + 1));
            result.append(digit1 + digit2);
        }
        if (numStr.length() % 2 == 1) {
            result.append(numStr.charAt(numStr.length() - 1));
        }
        return result.toString();
    }
}
