package edu.hw1;

import java.util.Arrays;

public class Task6 {
    private Task6() {
    }
    public static int countK(int n) {
        if (n <= 1000 || n >= 10000 || isSingleDigitNumber(n)) {
            throw new IllegalArgumentException("Number should be a 4-digit number with at least two different digits.");
        }

        if (n == 6174) {
            return 0;
        }

        int ascending = sortDigits(n, true); // Сортируем цифры по возрастанию.
        int descending = sortDigits(n, false); // Сортируем цифры по убыванию.

        int diff = descending - ascending;

        if (diff == 0) {
            return 0; // Избегаем деления на ноль.
        }

        return 1 + countK(diff); // Рекурсивный вызов для следующего числа.
    }

    public static boolean isSingleDigitNumber(int num) {
        int lastDigit = num % 10;
        num /= 10;
        while (num > 0) {
            int digit = num % 10;
            if (digit != lastDigit) {
                return false;
            }
            num /= 10;
        }
        return true;
    }








    public static int sortDigits(int num, boolean ascending) {
        int[] digits = new int[4];

        for (int i = 0; i < 4; i++) {
            digits[i] = num % 10;
            num /= 10;
        }

        if (ascending) {
            Arrays.sort(digits);
        } else {
            Arrays.sort(digits);
            reverseArray(digits);
        }

        int result = 0;

        for (int i = 0; i < 4; i++) {
            result = result * 10 + digits[i];
        }

        return result;
    }

    public static void reverseArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
