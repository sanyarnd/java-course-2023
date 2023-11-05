package edu.hw1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTask5 {
    @ParameterizedTest(name = "{index}: {0} = {1}")
    @CsvSource({
        "11211230, true",
        "13001120, true",
        "23336014, true",
        "425765276, false"
    })
    void test(long num, boolean ans) {
        assertEquals(Task5.isPalindromeDescendant(num), ans);
    }
}
