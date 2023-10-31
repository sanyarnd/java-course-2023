package edu.hw1;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class Task5 {
    private Task5() {

    }

    public static boolean isPalindromeDescendant(int number) {
        final int ten = 10;
        int length;
        int temp;
        while (number >= ten) {
            length = 0;
            temp = number;
            while (temp != 0) {
                temp  = temp / ten;
                length = length + 1;
            }
            if (isPalindrome(number, length)) {
                return true;
            } else {
                temp = number;
                number = 0;
                Stack<Integer> digits = new Stack<>();
                while (temp != 0) {
                    digits.push(temp % ten);
                    temp  = temp / ten;
                }
                length = digits.size() / 2;
                for (int i = 0; i < length; i++) {
                    number = number * ten + digits.pop() + digits.pop();
                }
            }
        }
        return false;
    }

    private static boolean isPalindrome(int digit, int length) {
        final int ten = 10;
        boolean flag = true;
        List<Integer> digits = new LinkedList<>();
        while (digit != 0) {
            digits.add(digit % ten);
            digit = digit / ten;
        }
        for (int i = 0; i < length / 2; i++) {
            if (!Objects.equals(digits.get(i), digits.get(length - 1 - i))) {
                flag = false;
                break;
            }
        }
        return flag;
    }

}
