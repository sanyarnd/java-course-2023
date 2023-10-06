package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task6Test {
    @Test
    void Standarttest(){
        assertEquals(5, Task6.funK(6621));
        assertEquals(4, Task6.funK(6554));
        assertEquals(3, Task6.funK(1234));
    }
    @Test
    void not_four_digit(){
        assertEquals(-1, Task6.funK(0000));
        assertEquals(-1, Task6.funK(1000));
    }

}
