package edu.hw1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Task6 {
    private static final int CONSTANT_KAPREKAR = 6174;
    private static final Set<Integer> INCORRECT_K = new HashSet<>(Arrays.asList(1111, 2222, 3333, 4444, 5555,
        6666, 7777, 8888, 9999
    ));
    private static final int MIN_EDGE = 1000;
    private static final int MAX_EDGE = 1000;

    private Task6() {

    }

    public static int countK(int k) {
        int counter = 0;
        if ((k < MIN_EDGE) || (k > MAX_EDGE) || (INCORRECT_K.contains(k))) {
            return -1;
        }
        while (k != CONSTANT_KAPREKAR) {
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
            int a = doNewNumber(first);
            int b = doNewNumber(second);
            if (a > b) {
                k = a - b;
            } else {
                k = b - a;
            }
            counter = counter + 1;
        }
        return counter;
    }

    private static int doNewNumber(int[] arr) {
        return arr[0] * 1000 + arr[1] * 100 + arr[2] * 10 + arr[3];
    }
}
