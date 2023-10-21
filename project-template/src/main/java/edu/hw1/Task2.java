package edu.hw1;

public class Task2 {
    private Task2() {
    }

//    public static void main() {}

    public static int countDigits(int number) {
        if (number == 0) {
            return 1;
        }

        int digCount = 0;
        while (number != 0) {
            digCount++;
            number /= 10;
        }

        return digCount;
    }
}
