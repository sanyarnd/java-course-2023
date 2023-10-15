package edu.hw1;

public class Task3 {
    private Task3() {
    }
    public static boolean Inner(int[] arr1, int[] arr2) {
        int min1 = ResMin(arr1);
        int max1 = ResMax(arr1);
        int min2 = ResMin(arr2);
        int max2 = ResMax(arr2);

        return min1 > min2 && max1 < max2;
    }

    private static int ResMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    private static int ResMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
