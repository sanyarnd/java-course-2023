package edu.hw1;

public class Task2 {

    private Task2() {

    }

    public static int countDigits(int digit) {
        if (digit == 0) {
            return 1;
        }
        int result = 0;
        int temp = digit;
        while (temp != 0) {
            temp = temp / 10;
            result = result + 1;
        }
        return result;
    }
}
