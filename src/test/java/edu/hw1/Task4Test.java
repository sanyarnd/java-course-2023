package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task4Test {

    @Test
    void testIsNestable() {
        int[] array1 = {1, 2, 3, 4};
        int[] array2 = {0, 6};
        assertThat(Task4.isNestable(array1, array2)).isTrue();

        int[] array3 = {3, 1};
        int[] array4 = {4, 0};
        assertThat(Task4.isNestable(array3, array4)).isTrue();

        int[] array5 = {9, 9, 8};
        int[] array6 = {8, 9};
        assertThat(Task4.isNestable(array5, array6)).isFalse();

        int[] array7 = {1, 2, 3, 4};
        int[] array8 = {2, 3};
        assertThat(Task4.isNestable(array7, array8)).isFalse();
    }

    @Test
    void testFindMin() {
        int[] array = {5, 2, 8, 1, 3};
        assertThat(Task4.findMin(array)).isEqualTo(1);
    }

    @Test
    void testFindMax() {
        int[] array = {5, 2, 8, 1, 3};
        assertThat(Task4.findMax(array)).isEqualTo(8);
    }
}
