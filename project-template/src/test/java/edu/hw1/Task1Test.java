package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task1Test {
    @Test
    void minutesToSecondsSuccess() {
        String minutes = "13:56";

        int expected = 836;
        int result = Task1.minutesToSeconds(minutes);

        Assertions.assertEquals(expected, result);
    }

    @Test
    void minutesToSecondsSuccessInvalidString() {
        String minutes = "10:68";

        int expected = -1;
        int result = Task1.minutesToSeconds(minutes);

        Assertions.assertEquals(expected, result);
    }
}
