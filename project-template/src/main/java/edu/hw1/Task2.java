package edu.hw1;

public class Task2 {
    private Task2() {
    }

    public static int countDigits(int num) {
        if (num == 0) {
            return 1;
        }

        int count = 0;
        while (num != 0) {
            num = num / 10;
            count++;
        }
        return count;
    }
}
