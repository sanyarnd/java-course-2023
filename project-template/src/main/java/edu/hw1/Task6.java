package edu.hw1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task6 {
    private Task6() {

    }

    public static int countK(int k) {
        final int constantKaprekar = 6174;
        int counter = 0;
        final List<Integer> incorrectK = new ArrayList<>(Arrays.asList(1111, 2222, 3333, 4444, 5555,
            6666, 7777, 8888, 9999));
        if ((k < 1000) || (k > 9999) || (incorrectK.contains(k))) {
            return -1;
        }
        while (k != constantKaprekar) {
            int[] first = new int[4];
            int temp = k;
            for (int i = 0; i < 4; i++) {
                first[i] = temp % 10;
                temp = temp / 10;
            }
            Arrays.sort(first);
            int[] second = new int[4];
            for (int i = 0; i < 4; i++) {
                second[i] = first[3 - i];
            }
            int a = doNewDigit(first);
            int b = doNewDigit(second);
            if (a > b) {
                k = a - b;
            } else {
                k = b - a;
            }
            counter  = counter + 1;
        }
        return counter;
    }

    private static int doNewDigit(int[] arr) {
        return arr[0] * 1000 + arr[1] * 100 + arr[2] * 10 + arr[3];
    }
}
