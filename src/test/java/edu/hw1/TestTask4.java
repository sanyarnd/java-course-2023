package edu.hw1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTask4 {
    @ParameterizedTest(name = "{index}: {0} = {1}")
    @CsvSource({
        "123456, 214365",
        "hTsii  s aimex dpus rtni.g, This is a mixed up string.",
        "badce, abcde",
        "abacaba, bacabaa"
    })
    void test(String str, String ans) {
        assertEquals(Task4.fixString(str), ans);
    }
}
