package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {
    @Test
    @DisplayName("01:00 -> 60")
    void test1() {
        // given
        String string = "01:00";

        // when
        int result = Task1.minutesToSeconds(string);

        // then
        assertEquals(result, 60);
    }

    @Test
    @DisplayName("13:56 -> 836")
    void test2() {
        // given
        String string = "13:56";

        // when
        int result = Task1.minutesToSeconds(string);

        // then
        assertEquals(result, 836);
    }

    @Test
    @DisplayName("10:60 -> -1")
    void test3() {
        // given
        String string = "10:60";

        // when
        int result = Task1.minutesToSeconds(string);

        // then
        assertEquals(result, -1);
    }
}
