package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class Task6Test {
    @Test public void testKaprekarStepsWithValidInput() {
        assertThat(Task6.kaprekarSteps(6621)).isEqualTo(5);
        assertThat(Task6.kaprekarSteps(6554)).isEqualTo(4);
        assertThat(Task6.kaprekarSteps(1234)).isEqualTo(3);
        assertThat(Task6.kaprekarSteps(3524)).isEqualTo(3);
        assertThat(Task6.kaprekarSteps(6174)).isEqualTo(0);
    }

    @Test public void testKaprekarStepsWithInvalidInput() {
        assertThat(Task6.kaprekarSteps(9999)).isEqualTo(-1);
        assertThat(Task6.kaprekarSteps(10000)).isEqualTo(-1);
    }

    @Test public void testSortNumber() {
        assertThat(Task6.sortNumber(3254, true)).isEqualTo(2345);
        assertThat(Task6.sortNumber(3254, false)).isEqualTo(5432);
    }
}
