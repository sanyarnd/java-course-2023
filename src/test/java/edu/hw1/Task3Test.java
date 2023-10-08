package edu.hw1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

public class Task3Test {

    @ParameterizedTest
    @MethodSource("nestableArrays")
    void testIsNestable_PositiveCases(int[] array1, int[] array2) {
        assertThat(Task3.isNestable(array1, array2)).isTrue();
    }

    @ParameterizedTest
    @MethodSource("nonNestableArrays")
    void testIsNestable_NegativeCases(int[] array1, int[] array2) {
        assertThat(Task3.isNestable(array1, array2)).isFalse();
    }

    private static Stream<Arguments> nestableArrays() {
        return Stream.of(
            Arguments.of(new int[] {1, 2, 3, 4}, new int[] {0, 6}),
            Arguments.of(new int[] {3, 1}, new int[] {4, 0})
        );
    }

    private static Stream<Arguments> nonNestableArrays() {
        return Stream.of(
            Arguments.of(new int[] {9, 9, 8}, new int[] {8, 9}),
            Arguments.of(new int[] {1, 2, 3, 4}, new int[] {2, 3})
        );
    }

    @Test
    void testFindMin() {
        int[] array = {5, 2, 8, 1, 3};
        assertThat(Task3.findMin(array)).isEqualTo(1);
    }

    @Test
    void testFindMax() {
        int[] array = {5, 2, 8, 1, 3};
        assertThat(Task3.findMax(array)).isEqualTo(8);
    }
}
