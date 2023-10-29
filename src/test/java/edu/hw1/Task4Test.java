package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task4Test {
    @Test
    void fixStringSuccess() {
        String str = "hTsii  s aimex dpus rtni.g";

        String expected = "This is a mixed up string.";
        String result = Task4.fixString(str);

        Assertions.assertEquals(expected, result);
    }
}
