package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task7Test {

    @Test
    @DisplayName("За сколько шагов получим 6174")
    void testCountK() {
        assertThat(Task7.countK(6621)).isEqualTo(5);
        assertThat(Task7.countK(6554)).isEqualTo(4);
        assertThat(Task7.countK(1234)).isEqualTo(3);
    }

    @Test
    @DisplayName("Правильно ли сортирует функция SortDigits")
    void testSortDigits() {
        assertThat(Task7.sortDigits(
            new int[] {1, 2},
            true
        )).isEqualTo(12);
        assertThat(Task7.sortDigits(
            new int[] {6, 6, 2, 1},
            true
        )).isEqualTo(1266);
        assertThat(Task7.sortDigits(
            new int[] {6, 5, 5, 4},
            false
        )).isEqualTo(6554);
        assertThat(Task7.sortDigits(
            new int[] {1, 2, 3, 4},
            false
        )).isEqualTo(4321);
    }
}
