package edu.hw1;

import java.util.Arrays;

@SuppressWarnings("MagicNumber")
public class Task6 {
    public static int countK(int number) {
        if (number == 6174) {
            return 0;
        }

        String numberString = String.valueOf(number);
        if (numberString.length() < 4) {
            numberString = String.format("%04d", number);
        }

        char[] digits = numberString.toCharArray();
        Arrays.sort(digits);
        int ascendingOrder = Integer.parseInt(new String(digits));

        int left = 0;
        int right = digits.length - 1;

        while (left < right) {
            char temp = digits[left];
            digits[left] = digits[right];
            digits[right] = temp;

            left++;
            right--;
        }
        int descendingOrder = Integer.parseInt(new String(digits));

        int diff = descendingOrder - ascendingOrder;

        return 1 + countK(diff);
    }
}
