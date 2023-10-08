package edu.hw1;

import java.util.Arrays;

public final class Task6 {
    private Task6() {
    }

    private static final int MIN_FOUR_DIGIT_NUMBER = 1000;
    private static final int MAX_FOUR_DIGIT_NUMBER = 9999;
    private static final int KAPREKAR_CONSTANT = 6174;
    private static final int FOUR = 4;
    private static final int BASE_TEN = 10;

    private static boolean isValidInput(int number) {
        String numberStr = String.valueOf(number);

        return number > MIN_FOUR_DIGIT_NUMBER && number <= MAX_FOUR_DIGIT_NUMBER
            && numberStr.chars().distinct().count() != 1;
    }

    public static int calculateKaprekarConstant(int number) {
        int value = number;
        if (!isValidInput(number)) {
            return -1;
        }

        if (value == KAPREKAR_CONSTANT) {
            return 0;
        } else {
            int[] digits = new int[FOUR];
            for (int i = FOUR - 1; i >= 0; i--) {
                digits[i] = value % BASE_TEN;
                value /= BASE_TEN;
            }
            // сортируем цифры в порядке возрастания и убывания
            int ascending = sortDigits(digits, true);
            int descending = sortDigits(digits, false);
            int diff = descending - ascending;
            // ррекурсивный вызов
            int descendant = calculateKaprekarConstant(diff);
            if (descendant == -1) {
                return -1;
            } else {
                return 1 + descendant;
            }
        }
    }

    public static int sortDigits(int[] digits, boolean ascending) {
        if (ascending) {
            Arrays.sort(digits);
        } else {
            Arrays.sort(digits);
            int i = 0;
            int j = FOUR - 1;
            while (i < j) {
                digits[i] += digits[j];
                digits[j] = digits[i] - digits[j];
                digits[i] -= digits[j];
                i++;
                j--;
            }
        }
        int number = 0;
        for (int digit : digits) {
            number = number * BASE_TEN + digit;
        }
        return number;
    }
}
