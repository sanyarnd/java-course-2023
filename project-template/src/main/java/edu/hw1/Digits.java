package edu.hw1;

public class Digits {
    public static int countDigit(int number) {
        if (number < 0)
            number = -number;
        int countDigit = 0;

        if (number == 0)
            countDigit += 1;

        while (number > 0) {
            number /= 10;
            countDigit += 1;
        }

        return countDigit;
    }
}
