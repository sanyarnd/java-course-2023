package edu.hw1;

final class Task5SpecialPalindrome {
    private Task5SpecialPalindrome() {
    }

    @SuppressWarnings("MagicNumber")
    public static boolean isPalindrome(int number) {
        int notOriginalNumber = number;
        int reversedNumber = 0;

        while (notOriginalNumber > 0) {
            int lastDigit = notOriginalNumber % 10;
            reversedNumber = reversedNumber * 10 + lastDigit;
            notOriginalNumber /= 10;
        }

        return number == reversedNumber;
    }

    @SuppressWarnings("MagicNumber")
    public static boolean isSpecialPalindrome(int originalValue) {
        int value = originalValue;
        if (value <= 10) {
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
            split[i] = value % 10;
            value /= 10;
        }

        int newValue = 0;
        newValue += split[0] + split[1];

        for (int i = 2; i < lengthValue - 1; i += 2) {
            int add = split[i] + split[i + 1];

            if (add == 0) {
                newValue *= 10;
            } else {
                newValue += add * (int) Math.pow(10, Task2CountDigits.getCountDigits(newValue));
            }
        }
        return isSpecialPalindrome(newValue);
    }
}
