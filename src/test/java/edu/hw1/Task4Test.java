package edu.hw1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

public class Task4Test {

    @ParameterizedTest
    @MethodSource("nestableArrays")
    void testIsNestable(int[] array1, int[] array2, boolean expected) {
        assertThat(Task4.isNestable(array1, array2)).isEqualTo(expected);
    }

    private static Stream<Arguments> nestableArrays() {
        return Stream.of(
            Arguments.of(new int[] {1, 2, 3, 4}, new int[] {0, 6}, true),
            Arguments.of(new int[] {3, 1}, new int[] {4, 0}, true),
            Arguments.of(new int[] {9, 9, 8}, new int[] {8, 9}, false),
            Arguments.of(new int[] {1, 2, 3, 4}, new int[] {2, 3}, false)
        );
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
