package edu.hw1;

public class Task5 {
    private Task5() {
    }

    public static boolean isPalindromeDescendant(int x) {
        if (x < 0) {
            throw new IllegalArgumentException("Number should be non-negative!");
        }

        if (isPalindrome(x)) {
            return true;
        }

        int digitCount = countDigits(x);

        if (digitCount % 2 == 1) {
            return false;
        }

        int child = getChild(x);

        if (countDigits(child) < 2) {
            return false;
        }

        return isPalindromeDescendant(child);
    }

    public static int countDigits(int x) {
        int count = 0;

        while (x > 0) {
            x /= 10;
            count++;
        }

        return count;
    }

    public static int getChild(int x) {
        if (countDigits(x) % 2 != 0) {
            throw new IllegalArgumentException("Input number should have an even number of digits.");
        }

        int result = 0;

        while (x >= 10) {
            int lastDigit = x % 10;
            int secondLastDigit = (x / 10) % 10;
            int sum = lastDigit + secondLastDigit;

            if (sum <= 9) {
                result *= 10;
            } else {
                result *= 100;
            }

            result += sum;
            x /= 100;
        }

        return reverseInt(result);
    }

    private static boolean isPalindrome(int x) {
        return reverseInt(x) == x;
    }

    public static int reverseInt(int x) {
        int result = 0;

        while (x > 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }

        return result;
    }
}
