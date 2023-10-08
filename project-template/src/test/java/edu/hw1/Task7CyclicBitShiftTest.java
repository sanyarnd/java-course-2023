package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7CyclicBitShiftTest {
    @Test
    @DisplayName("LR Меньше 1")
    void test1() {
        // given
        int value = -1;
        int shift = 2;
        // when
        int test = Task7CyclicBitShift.rotateLeft(value, shift);
        // then
        assertThat(test).isEqualTo(-1);
        // when
        test = Task7CyclicBitShift.rotateRight(value, shift);
        // then
        assertThat(test).isEqualTo(-1);

    }
    @Test
    @DisplayName("LR Сдвиг отрицательный")
    void test2() {
        // given
        int value = 5;
        int shift = -2;
        // when
        int test = Task7CyclicBitShift.rotateLeft(value, shift);
        // then
        assertThat(test).isEqualTo(-1);
        // when
        test = Task7CyclicBitShift.rotateRight(value, shift);
        // then
        assertThat(test).isEqualTo(-1);
    }
    @Test
    @DisplayName("L 1 Тест.Сдвиг два с половиной цикла")
    void test3() {
        // given
        int value = 8;
        int shift = 10;
        // when
        int test = Task7CyclicBitShift.rotateLeft(value, shift);
        // then
        assertThat(test).isEqualTo(2);
    }
    @Test
    @DisplayName("L 2 Тест")
    void test4() {
        // given
        int value = 18;
        int shift = 1;
        // when
        int test = Task7CyclicBitShift.rotateLeft(value, shift);
        // then
        assertThat(test).isEqualTo(5);
    }
    @Test
    @DisplayName("L 3 Тест")
    void test5() {
        // given
        int value = 17;
        int shift = 2;
        // when
        int test = Task7CyclicBitShift.rotateLeft(value, shift);
        // then
        assertThat(test).isEqualTo(6);
    }
    @Test
    @DisplayName("L Двоичное число из единиц")
    void test6() {
        // given
        int value = 17;
        int shift = 2;
        // when
        int test = Task7CyclicBitShift.rotateLeft(value, shift);
        // then
        assertThat(test).isEqualTo(6);
    }
    @Test
    @DisplayName("R 1 Тест")
    void test7() {
        // given
        int value = 8;
        int shift = 1;
        // when
        int test = Task7CyclicBitShift.rotateRight(value, shift);
        // then
        assertThat(test).isEqualTo(4);
    }
    @Test
    @DisplayName("R C переходом единицы")
    void test8() {
        // given
        int value = 9;
        int shift = 2;
        // when
        int test = Task7CyclicBitShift.rotateRight(value, shift);
        // then
        //1001 -> 1100->110
        assertThat(test).isEqualTo(6);
    }
}
