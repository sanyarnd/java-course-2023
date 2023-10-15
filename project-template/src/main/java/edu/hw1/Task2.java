package edu.hw1;

public class Task2 {
    public static int countDigits(int digit) {
        if (digit == 0) {
            return 1;
        }
        int result = 0;
        while (digit != 0) {
            digit = digit / 10;
            result = result + 1;
        }
        System.out.println(result);
        return result;
    }
}
