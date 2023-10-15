package edu.hw1;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class Task5 {
    public static boolean isPalindromeDescendant(int digit) {
        int length = 0;
        int temp = digit;
        while (temp !=0) {
            temp  = temp / 10;
            length = length + 1;
        }
        while (length >= 2) {
            if (isPalindrome(digit, length)) {
                System.out.println(true);
                return true;
            } else {
                temp = digit;
                digit = 0;
                Stack<Integer> list = new Stack<>();
                while (temp !=0) {
                    list.push(temp % 10);
                    temp  = temp / 10;
                }
                length = list.size()/2;
                for (int i=0;i<length;i++) {
                    digit = digit*10 + list.pop() + list.pop();
                }
                temp = digit;
                length = 0;
                while (temp != 0) {
                    temp = temp / 10;
                    length = length + 1;
                }
            }
        }
        System.out.println(false);
        return false;

    }
    public static boolean isPalindrome(int digit, int length) {
        boolean flag = true;
        List<Integer> list = new LinkedList<>();
        while (digit !=0) {
            list.add(digit % 10);
            digit  = digit / 10;
        }
        for (int i=0;i<length/2;i++) {
            if (!Objects.equals(list.get(i), list.get(length - 1 - i))) {
                flag = false;
                break;
            }
        }
        return flag;
    }

}
