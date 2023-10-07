package edu.hw1;

import java.util.logging.Logger;

public final class Task4 {
    private Task4() {
    }

    private static final Logger LOGGER = Logger.getLogger(Task4.class.getName());

    @SuppressWarnings({"uncommentedmain", "checkstyle:magicnumber"})
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4};
        int[] array2 = {0, 6};
        LOGGER.info("isNestable([1, 2, 3, 4], [0, 6]) -> " + isNestable(array1, array2)); // true
    }

    public static boolean isNestable(int[] array1, int[] array2) {
        int minArray1 = findMin(array1);
        int maxArray1 = findMax(array1);
        int minArray2 = findMin(array2);
        int maxArray2 = findMax(array2);

        return minArray1 > minArray2 && maxArray1 < maxArray2;
    }

    public static int findMin(int[] array) {
        int min = array[0];
        for (int num : array) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    public static int findMax(int[] array) {
        int max = array[0];
        for (int num : array) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
}
