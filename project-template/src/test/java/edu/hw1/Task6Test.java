package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Task6Test {
    @Test public void testKaprekarStepsWithValidInput() {
        assertEquals(Task6.kaprekarSteps(6621), 5);
        assertEquals(Task6.kaprekarSteps(6554), 4);
        assertEquals(Task6.kaprekarSteps(1234), 3);
        assertEquals(Task6.kaprekarSteps(3524), 3);
        assertEquals(Task6.kaprekarSteps(6174), 0);
        assertEquals(Task6.kaprekarSteps(1110), 5);
    }

    @Test public void testKaprekarStepsWithInvalidInput() {
        assertEquals(Task6.kaprekarSteps(9999), -1);
        assertEquals(Task6.kaprekarSteps(10000), -1);
    }

    @Test public void testCheckIfAllDigSame() {
        assertTrue(Task6.checkIfAllDigSame(9999));
        assertTrue(Task6.checkIfAllDigSame(1111));
    }

    @Test public void testSortNumber() {
        assertEquals(Task6.sortNumber(3254, true), 2345);
        assertEquals(Task6.sortNumber(3254, false), 5432);
    }
}
