package edu.hw1;

public class task2 {
    public static int countDigits(int num) {
        int i = 1;
        num = Math.abs(num);
        while (num / 10 > 0) {
            ++i;
            num /= 10;
        }
        return i;
    }
}
