package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {
    @ParameterizedTest
    @ValueSource(strings = {"01:00", "13:56", "10:60", ":01", "1234"})
    @DisplayName("new")
    void test1(String input) {
        // given

        // when
        int result = Task1.minutesToSeconds(input);

        // then
        assertEquals(result, 60);
    }
}
