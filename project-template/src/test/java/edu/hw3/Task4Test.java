package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task4Test {

    @Test
    @DisplayName("2 -> II")
    void test1() {
        // given
        int number = 2;

        // when
        String result = String.valueOf(Task4.convertToRoman(number));

        // then
        assertEquals(result, "II");
    }

    @Test
    @DisplayName("12 -> XII")
    void test2() {
        // given
        int number = 12;

        // when
        String result = String.valueOf(Task4.convertToRoman(number));

        // then
        assertEquals(result, "XII");
    }

    @Test
    @DisplayName("16 -> XVI")
    void test3() {
        // given
        int number = 16;

        // when
        String result = String.valueOf(Task4.convertToRoman(number));

        // then
        assertEquals(result, "XVI");
    }
}
