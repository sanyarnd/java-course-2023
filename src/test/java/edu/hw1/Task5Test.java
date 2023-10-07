package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task5Test {
    @Test
    void testFixString() {
        assertThat(Task5.fixString("123456")).isEqualTo("214365");
        assertThat(Task5.fixString("hTsii  s aimex dpus rtni.g")).isEqualTo("This is a mixed up string.");
        assertThat(Task5.fixString("badce")).isEqualTo("abcde");
    }
}
