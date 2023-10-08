package edu.hw1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {

    @ParameterizedTest
    @CsvSource({"4666, 4", "544, 3", "0, 1", "-123, 3"})
    public void testCountDigits(int input, int expected) {
        assertThat(Task2.countDigits(input)).isEqualTo(expected);
    }
}
