package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    @Test
    public void testCountDigits() {
        assertThat(Task3.countDigits(4666)).isEqualTo(4);
        assertThat(Task3.countDigits(544)).isEqualTo(3);
        assertEquals(1, Task3.countDigits(0));
        assertEquals(3, Task3.countDigits(-123));
    }
}
