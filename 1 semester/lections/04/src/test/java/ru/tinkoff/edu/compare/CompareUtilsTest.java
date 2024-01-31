package ru.tinkoff.edu.compare;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import org.junit.jupiter.api.Test;
import ru.tinkoff.edu.compare.CompareUtils.ClassWithImproperEquals;
import ru.tinkoff.edu.compare.CompareUtils.ClassWithProperEquals;

class CompareUtilsTest {

  @Test
  void properEqualsTest() {
    var map = new HashMap<ClassWithProperEquals, List<Integer>>();

    final var key = new ClassWithProperEquals(1, "test");
    putInnerElement(map, key, 1);
    putInnerElement(map, key, 2);
    putInnerElement(map, key, 3);

    assertEquals(1, map.size());

    final var elements = map.values().stream().toList();
    assertEquals(1, elements.size());

    final var innerElements = elements.get(0);
    assertEquals(3, innerElements.size());
  }

  @Test
  void improperEqualsTest() {
    var map = new HashMap<ClassWithImproperEquals, List<Integer>>();

    final var key = new ClassWithImproperEquals(1, "test");
    putInnerElement(map, key, 1);
    putInnerElement(map, key, 2);
    putInnerElement(map, key, 3);

//     assertNotNull(map.get(key));
    assertEquals(1, map.size());

    final var elements = map.values().stream().toList();
    assertEquals(1, elements.size());

    final var innerElements = elements.get(0);
    assertEquals(3, innerElements.size());
  }

  @Test
  void compareToTest() {
    final Integer one = 1;
    final Integer two = 2;

    assertEquals(0, one.compareTo(one));
    assertTrue(one.compareTo(two) < 0);
    assertTrue(two.compareTo(one) > 0);

    final var first = new ClassWithProperEquals(1, "test1");
    final var second = new ClassWithProperEquals(1, "test1");
    final var third = new ClassWithProperEquals(1, "test2");
    final var fourth = new ClassWithProperEquals(2, "test2");

    assertEquals(first, second);
    assertEquals(0, first.compareTo(second));
    assertTrue(first.compareTo(third) < 0);
    assertTrue(first.compareTo(fourth) < 0);

    final var collection =
        new ArrayList<>(
            LongStream.range(0, 100)
                .mapToObj(it -> new ClassWithImproperEquals(it, String.valueOf(it)))
                .toList());
    Collections.sort(
        collection,
        Comparator.comparingLong(ClassWithImproperEquals::id)
            .reversed());
    System.out.println(
        collection.stream()
            .map(Object::toString)
            .collect(Collectors.joining(", ")));
  }

  private static <K> void putInnerElement(Map<K, List<Integer>> map, K key, int value) {
    map.computeIfAbsent(key, ignored -> new ArrayList<>()).add(value);
  }

}
