package edu.hw1;

public class task3 {
    public static boolean isNestable(int[] a1, int[] a2) {
        int n1 = a1.length;
        int n2 = a2.length;
        int min1 = a1[0], min2 = a2[0];
        int max1 = a1[0], max2 = a2[0];
        for (int i : a1) {
            if (i > max1) max1 = i;
            if (i < min1) min1 = i;
        }
        for (int i : a2) {
            if (i > max2) max2 = i;
            if (i < min2) min2 = i;
        }
        return min1 > min2 && max1 < max2;
    }
}
