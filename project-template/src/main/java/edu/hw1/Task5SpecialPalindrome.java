package edu.hw1;

final class Task5SpecialPalindrome {
    private Task5SpecialPalindrome() {
    }

    final static public int TEN = 10;

    public static boolean isPalindrome(int number) {
        int notOriginalNumber = number;
        int reversedNumber = 0;

        while (notOriginalNumber > 0) {
            int lastDigit = notOriginalNumber % TEN;
            reversedNumber = reversedNumber * TEN + lastDigit;
            notOriginalNumber /= TEN;
        }

        return number == reversedNumber;
    }

    public static boolean isSpecialPalindrome(int originalValue) {
        int value = originalValue;
        if (value <= TEN) {
            return false;
        }
        if (isPalindrome(value)) {
            return true;
        } else if (Task2CountDigits.getCountDigits(value) % 2 == 1) {
            return false;
        }

        int lengthValue = Task2CountDigits.getCountDigits(value);
        var split = new int[lengthValue];
        for (int i = lengthValue - 1; -1 < i; i--) {
            split[i] = value % TEN;
            value /= TEN;
        }

        int newValue = 0;
        newValue += split[0] + split[1];

        for (int i = 2; i < lengthValue - 1; i += 2) {
            int add = split[i] + split[i + 1];

            if (add == 0) {
                newValue *= TEN;
            } else {
                newValue += add * (int) Math.pow(TEN, Task2CountDigits.getCountDigits(newValue));
            }
        }
        return isSpecialPalindrome(newValue);
    }
}
