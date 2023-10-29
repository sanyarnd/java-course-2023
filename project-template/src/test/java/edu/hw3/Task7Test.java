package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.TreeMap;
import static edu.hw3.Task7.nullFirstComparator;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task7Test {

    @Test
    @DisplayName("()()() -> (),(),()")
    void test1() {
        // given
        TreeMap<String, String> tree = new TreeMap<>(nullFirstComparator());

        // when
        tree.put(null, "test");

        // then
        assertTrue(tree.containsKey(null));
    }
}
