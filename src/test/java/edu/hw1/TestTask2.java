package edu.hw1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTask2 {
    @ParameterizedTest(name = "{index}: {0} = {1}")
    @CsvSource({
        "0, 1",
        "5666, 4",
        "544, 3",
        "1092328, 7"
    })
    void test(int number, int ans) {
        assertEquals(Task2.countDigits(number), ans);
    }
}
