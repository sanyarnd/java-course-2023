package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task8Test {

    @Test
    @DisplayName("1,2,3 -> 3,2,1")
    void test1() {
        // given
        List<Integer> list = List.of(1, 2, 3);

        // when
        BackwardIterator<Integer> iterator = new BackwardIterator<>(list);
        List<Integer> result = new ArrayList<>();
        while (iterator.hasNext()) {
            result.add(iterator.next());
        }

        // then
        assertEquals(result, List.of(3,2,1));
    }
}
