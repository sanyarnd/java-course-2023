package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw1.Task1.minutesToSeconds;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test1 {
    @Test
    @DisplayName("Проверка времени")
    void checkTime() {
        //assertThat(evenNumbers);
        assertEquals(minutesToSeconds("44:56"), 44 * 60 + 56);
        assertEquals(minutesToSeconds("-2:00"), -1);
        assertEquals(minutesToSeconds("1:60"), -1);
        assertEquals(minutesToSeconds("one:zero"), -1);
        assertEquals(minutesToSeconds("0:98"), -1);
        assertEquals(minutesToSeconds("0:48"), 48);
    }
}
