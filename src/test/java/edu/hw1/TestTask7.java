package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTask7 {
    @DisplayName("TestRotateRight")
    @ParameterizedTest(name = "{index}: {0} = {1}")
    @CsvSource({
        "8, 1, 4",
        "128, 10, 32",
        "54, 7, 27"
    })
    void TestRotateRight(int n, int shift, int ans) {
        assertEquals(Task7.rotateRight(n, shift), ans);
    }
    @DisplayName("TestRotateLeft")
    @ParameterizedTest(name = "{index}: {0} = {1}")
    @CsvSource({
        "16, 1, 1",
        "17, 2, 6",
        "67, 30, 14"
    })
    void TestRotateLeft(int n, int shift, int ans) {
        assertEquals(Task7.rotateLeft(n, shift), ans);
    }
}
