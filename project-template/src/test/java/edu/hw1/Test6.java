package edu.hw1;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.*;

public class Test6 {

    @Test
    void testKaprekar() {
        assertThat(Task6.countK(6174)).isEqualTo(0);
    }

    @Test
    public void testCountK() {
        assertEquals(3, Task6.countK(3524));
        assertEquals(5, Task6.countK(6621));
        assertEquals(4, Task6.countK(6554));
        assertEquals(3, Task6.countK(1234));
    }

    @Test
    public void testCountK_InvalidInput() {
        // меньше 1000
        assertThrows(IllegalArgumentException.class, () -> Task6.countK(123));

        // больше 9999
        assertThrows(IllegalArgumentException.class, () -> Task6.countK(10000));

        // Все цифры одинаковы
        assertThrows(IllegalArgumentException.class, () -> Task6.countK(1111));
        assertThrows(IllegalArgumentException.class, () -> Task6.countK(9999));
        assertThrows(IllegalArgumentException.class, () -> Task6.countK(0000));
    }



}
