package edu.hw1;

public class Task3 {

    private Task3() {
    }

    public static boolean isNestable(int[] a1, int[] a2) {
        int min1 = a1[0];
        int min2 = a2[0];
        int max1 = a1[0];
        int max2 = a2[0];
        for (int i : a1) {
            if (i > max1) {
                max1 = i;
            }
            if (i < min1) {
                min1 = i;
            }
        }
        for (int j : a2) {
            if (j > max2) {
                max2 = j;
            }
            if (j < min2) {
                min2 = j;
            }
        }
        return min1 > min2 && max1 < max2;
    }
}
