package edu.hw1;

import java.util.Arrays;

@SuppressWarnings({"checkstyle:magicnumber"})
public final class Task7 {
    private Task7() {
    }

    public static boolean isValidInput(int number) {
        String numberStr = String.valueOf(number);
        return number > 1000 && number <= 9999 && numberStr.chars().distinct().count() != 1;
    }

    public static int countK(int m) {
        int n = m;
        if (!isValidInput(m)) {
            return -1;
        }
        if (n == 6174) {
            return 0;
        } else {
            int[] digits = new int[4];
            for (int i = 3; i >= 0; i--) {
                digits[i] = n % 10;
                n /= 10;
            }
            // сортируем цифры в порядке возрастания и убывания
            int ascending = sortDigits(digits, true);
            int descending = sortDigits(digits, false);
            int diff = descending - ascending;
            // ррекурсивный вызов
            return 1 + countK(diff);
        }
    }

    public static int sortDigits(int[] digits, boolean ascending) {
        if (ascending) {
            Arrays.sort(digits);
        } else {
            Arrays.sort(digits);
            int i = 0;
            int j = 3;
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
            number = number * 10 + digit;
        }
        return number;
    }
}
