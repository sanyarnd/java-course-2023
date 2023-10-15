package edu.hw1;

public class Task2 {
    public static int countDigits(int number) {
        int count = 0;

        do {
            number /= 10;
            count++;
        }
        while (number != 0);

        return count;
    }
}
