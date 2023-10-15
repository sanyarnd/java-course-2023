package edu.hw1;

import java.util.Arrays;

public class Task6 {
    public static int countK(int k) {
        int temp;
        int counter = 0;
        while (k != 6174) {
            int[] first = new int[4];
            temp = k;
            for (int i=0;i<4;i++) {
                first[i] = temp % 10;
                temp = temp / 10;
            }
            Arrays.sort(first);
            int[] second = new int[4];
            for (int i=0;i<4;i++) {
                second[i] = first[3-i];
            }
            int a = first[0]*1000 + first[1]*100 + first[2]*10 + first[3];
            int b = second[0]*1000 + second[1]*100 + second[2]*10 + second[3];
            if (a > b) {
                k = a - b;
            } else {
                k = b - a;
            }
            counter  = counter + 1;

        }
        System.out.println(counter);
        return counter;
    }
}
