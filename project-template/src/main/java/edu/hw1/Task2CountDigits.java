package edu.hw1;

final class Task2CountDigits {
    private Task2CountDigits() {
    }

    final static public int TEN = 10;

    public static int getCountDigits(int value) {
        if (value == 0) {
            return 1;
        }

        var result = 0;
        var countingValue = value;

        while (countingValue != 0) {
            countingValue /= TEN;
            result++;
        }
        return result;
    }
}
