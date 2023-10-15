package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class Task1Test {
    @Test
    void testGetMovieLenSecInvalidInput() {
        assertThat(Task1.getMovieLenSec("10:60")).isEqualTo(-1);
        assertThat(Task1.getMovieLenSec("-10:60")).isEqualTo(-1);
    }

    @Test
    void testGetMovieLenSecThrowException() {
        Throwable thrown = catchThrowable(() -> {
            Task1.getMovieLenSec("10-60");
        });
        assertThat(thrown).isInstanceOf(NumberFormatException.class);

        thrown = catchThrowable(() -> {
            Task1.getMovieLenSec("266");
        });
        assertThat(thrown).isInstanceOf(NumberFormatException.class);
    }

    @Test
    void testGetMovieLenSecValidInput() {
        assertThat(Task1.getMovieLenSec("01:00")).isEqualTo(60);
        assertThat(Task1.getMovieLenSec("13:56")).isEqualTo(836);
    }
}
