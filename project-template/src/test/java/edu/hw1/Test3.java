package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Test3 {
    @Test
    public void testInnerTrue() {
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {0, 6};
        assertTrue(Task3.Inner(arr1, arr2));

        int[] arr3 = {3, 1};
        int[] arr4 = {4, 0};
        assertTrue(Task3.Inner(arr3, arr4));
    }

    @Test
    public void testInnerFalse() {
        int[] arr5 = {9, 9, 8};
        int[] arr6 = {8, 9};
        assertFalse(Task3.Inner(arr5, arr6));

        int[] arr7 = {1, 2, 3, 4};
        int[] arr8 = {2, 3};
        assertFalse(Task3.Inner(arr7, arr8));
    }
}
