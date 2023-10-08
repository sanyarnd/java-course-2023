package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

public class Task7Test {

    @ParameterizedTest
    @MethodSource("testCountKArguments")
    @DisplayName("За сколько шагов получим 6174")
    void testCountK(int input, int expectedSteps) {
        assertThat(Task7.countK(input)).isEqualTo(expectedSteps);
    }

    private static Stream<Arguments> testCountKArguments() {
        return Stream.of(
            Arguments.of(6621, 5),
            Arguments.of(6554, 4),
            Arguments.of(1234, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("testSortDigitsArguments")
    @DisplayName("Правильно ли сортирует функция SortDigits")
    void testSortDigits(int[] input, boolean ascending, int expectedSortedNumber) {
        assertThat(Task7.sortDigits(input, ascending)).isEqualTo(expectedSortedNumber);
    }

    private static Stream<Arguments> testSortDigitsArguments() {
        return Stream.of(
            Arguments.of(new int[] {1, 2}, true, 12),
            Arguments.of(new int[] {6, 6, 2, 1}, true, 1266),
            Arguments.of(new int[] {6, 5, 5, 4}, false, 6554),
            Arguments.of(new int[] {1, 2, 3, 4}, false, 4321)
        );
    }
}
