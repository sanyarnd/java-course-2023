package edu.hw1;

public class Task3 {

    private Task3() {
    }

    private static int findMax(int[] a) {
        int max = a[0];
        for (int i : a) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    private static int findMin(int[] a) {
        int min = a[0];
        for (int i : a) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }

    public static boolean isNestable(int[] a1, int[] a2) {
        int min1 = findMin(a1);
        int min2 = findMin(a2);
        int max1 = findMax(a1);
        int max2 = findMax(a2);
        return min1 > min2 && max1 < max2;
    }
}
