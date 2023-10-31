package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task4Test {
    @Test
    @DisplayName("123456 -> 214365")
    void test1() {
        // given
        String string = "123456";

        // when
        String result = Task4.fixString(string);

        // then
        assertEquals(result, "214365");
    }

    @Test
    @DisplayName("hTsii  s aimex dpus rtni.g -> This is a mixed up string.")
    void test2() {
        // given
        String string = "hTsii  s aimex dpus rtni.g";

        // when
        String result = Task4.fixString(string);

        // then
        assertEquals(result, "This is a mixed up string.");
    }

    @Test
    @DisplayName("badce -> abcde")
    void test3() {
        // given
        String string = "badce";

        // when
        String result = Task4.fixString(string);

        // then
        assertEquals(result, "abcde");
    }
}
