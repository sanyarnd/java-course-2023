package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class Task1Test {
    @Test
    void testGetMovieLenSecInvalidInput() {
        assertEquals(Task1.getMovieLenSec("10:60"), -1);
        assertEquals(Task1.getMovieLenSec("-10:60"), -1);
    }

    @Test
    void testGetMovieLenSecThrowException() {
        Throwable thrown = catchThrowable(() -> {
            Task1.getMovieLenSec("10-60");
        });
        assertInstanceOf(NumberFormatException.class, thrown);

        thrown = catchThrowable(() -> {
            Task1.getMovieLenSec("266");
        });
        assertInstanceOf(NumberFormatException.class, thrown);
    }

    @Test
    void testGetMovieLenSecValidInput() {
        assertEquals(Task1.getMovieLenSec("01:00"), 60);
        assertEquals(Task1.getMovieLenSec("13:56"), 836);
    }
}
