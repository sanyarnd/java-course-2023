package edu.hw1;

public class Task2 {

    private Task2() {

    }

    public static int countDigits(int digit) {
        final int partOfDigit = 10;
        if (digit == 0) {
            return 1;
        }
        int result = 0;
        int temp = digit;
        while (temp != 0) {
            temp = temp / partOfDigit;
            result = result + 1;
        }
        return result;
    }
}
