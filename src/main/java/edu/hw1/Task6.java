package edu.hw1;

import java.util.Arrays;

public class Task6 {
    public static int countK(int number) {
        return countK(number, 0);
    }

    public static int countK(int number, int step) {
        if (number == 6174) {
            return step;
        }

        int[] digits = new int[4];
        for (int i = 0; i < 4; i++) {
            digits[i] = number % 10;
            number /= 10;
        }
        Arrays.sort(digits);

        int max = 0;
        int min = 0;
        for (int i = 0; i < 4; i++) {
            max += digits[i] * Math.pow(10, i);
            min += digits[3 - i] * Math.pow(10, i);
        }

        return countK(max - min, ++step);
    }
}
