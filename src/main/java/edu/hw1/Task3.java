package edu.hw1;

public class Task3 {
    public static boolean isNestable(int[] arr1, int[] arr2) {
        int minArr1 = Integer.MAX_VALUE;
        int maxArr1 = Integer.MIN_VALUE;
        int minArr2 = Integer.MAX_VALUE;
        int maxArr2 = Integer.MIN_VALUE;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] > maxArr1) {
                maxArr1 = arr1[i];
            }
            if (arr1[i] < minArr1) {
                minArr1 = arr1[i];
            }
        }

        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] > maxArr2) {
                maxArr2 = arr2[i];
            }
            if (arr2[i] < minArr2) {
                minArr2 = arr2[i];
            }
        }

        return (minArr1 > minArr2) && (maxArr1 < maxArr2);
    }
}
