package ru.tinkoff.edu.sorted;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

class SortedCollectionsTest {

  @Test
  void sortedSetTest() {
    // Тестировать не будем, так как под капотом - TreeMap
    final var set = new TreeSet<String>();
  }

  @Test
  void sortedMapTest() {
    // Red-Black tree
    final var map = new TreeMap<Integer, String>(Comparator.reverseOrder());

    IntStream.range(0, 10).forEach(it -> map.put(it, "test" + it));

    // SortedMap
    assertEquals(9, map.firstKey());
    assertEquals(0, map.lastKey());

    // to - exclusive
    final var head = map.headMap(5);
    assertEquals(4, head.size());
    assertTrue(head.keySet().containsAll(Set.of(9, 8, 7, 6)));

    // from - inclusive
    final var tail = map.tailMap(5);
    assertEquals(6, tail.size());
    assertTrue(tail.keySet().containsAll(Set.of(0, 1, 2, 3, 4, 5)));

    // NavigableMap
    assertEquals(7, map.lowerKey(6));   // <
    assertEquals(6, map.floorKey(6));   // <=
    assertEquals(5, map.higherKey(6));  // >
    assertEquals(6, map.ceilingKey(6)); // >=

    final var reversed = map.descendingKeySet();
    assertEquals(
        reversed,
        map.keySet().stream()
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toCollection(LinkedHashSet::new)));
  }

}
