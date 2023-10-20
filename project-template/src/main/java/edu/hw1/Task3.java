package edu.hw1;

public class Task3 {
    private Task3() {

    }

    public static boolean isNestable(int[] a1, int[] a2) {
        int min1 = getMin(a1);
        int max1 = getMax(a1);
        int min2 = getMin(a2);
        int max2 = getMax(a2);
        return (min1 > min2) && (max1 < max2);
    }

    private static int getMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
