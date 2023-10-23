package edu.hw1;

public class Task2 {

    private Task2() {}

    public static int countDigits(int num) {
        final int DEL = 10;
        int i = 1;
        int newNum = Math.abs(num);
        while (newNum / DEL > 0) {
            ++i;
            newNum /= DEL;
        }
        return i;
    }
}
