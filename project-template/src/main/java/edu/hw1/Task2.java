package edu.hw1;

public class Task2 {
    public static void main() {
    }

    public static int countDigits(int number) {
        if (number == 0) {
            return 1;
        }

        if (number < 0) {
            number *= -1;
        }

        return (int) (Math.log10(number) + 1);
    }
}
