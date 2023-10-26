package ru.tinkoff.edu.utils;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.IntStream;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.ListUtils;
import org.junit.jupiter.api.Test;

class CollectionCommonUtilsTest {

  /**
   * {@link org.apache.commons.collections.CollectionUtils}
   */
  @Test
  void javaCollectionUtilsTest() {
    final var collection = new ArrayList<>(IntStream.range(1000, 1100).boxed().toList());
    Collections.shuffle(collection);

    // ARRAYS
    var array = new Integer[100];
    array = collection.toArray(array);
    assertEquals(100, array.length);

    // 1. Creating (copyOf, copyOfRange)
    var arrayCopy = Arrays.copyOf(array, array.length);
    assertArrayEquals(array, arrayCopy);
    assertFalse(arrayCopy == array);
    // Note: ссылки остаются теми же
    assertTrue(array[58] == arrayCopy[58]);

    // 2. Fill
    var filledArray = new int[100];
    Arrays.fill(filledArray, 30);
    assertEquals(30, filledArray[88]);

    // 3. Comparing - equals & hashCode + deep impls (вложенные массивы)
    assertTrue(Arrays.deepEquals(array, arrayCopy));
    assertEquals(Arrays.hashCode(array), Arrays.hashCode(arrayCopy));

    // 4. Sort (есть параллельный аналог)
    // O(NlogN) - merge sort
    Arrays.sort(array, Comparator.reverseOrder());
    assertTrue(array[58] <= array[57]);

    // 5. binary search
    Arrays.sort(array, Comparator.naturalOrder());
    assertTrue(Arrays.binarySearch(array, 66) < 0);
    assertTrue(Arrays.binarySearch(array, 1066) >= 0);

    // 6. Transforming
    Arrays.toString(array);
    Arrays.asList(array);
    Arrays.stream(array);

    // Collections
    // 1. Empty collections
    // List.of, Map.of - Java 9
    assertTrue(Collections.emptyList().isEmpty());
    assertTrue(Collections.emptyMap().isEmpty());

    // 2. Copying and filling
    final var collectionCopy = new ArrayList<>(IntStream.range(0, 100).boxed().toList());
    Collections.fill(collectionCopy, 0);
    assertEquals(0, collectionCopy.get(77));

    Collections.copy(collectionCopy, collection);
    assertEquals(collection, collectionCopy);

    // 3. Synchronized collections
    final var syncList = Collections.synchronizedList(collectionCopy);

    // 4. Unmodifiable collections
    final var unmodifiableList = Collections.unmodifiableList(collectionCopy);
    assertThrows(UnsupportedOperationException.class, () -> unmodifiableList.add(10));
  }

  @Test
  @SuppressWarnings("unchecked")
  void apacheCommonsTest() {
    final var collection = new ArrayList<>(IntStream.range(0, 100).boxed().toList());
    Collections.shuffle(collection);

    CollectionUtils.filter(collection, it -> (int) it % 2 == 0);
    assertEquals(50, collection.size());

    final var select =
        new ArrayList<Integer>(
            CollectionUtils.select(
                collection,
                it -> (int) it % 3 == 0));
    CollectionUtils.forAllDo(select, it -> System.out.println("Элемент = " + it));

    var validatedList = ListUtils.predicatedList(select, it -> (int) it % 3 == 0);
    validatedList.add(6);
    assertTrue(validatedList.contains(6));
    assertThrows(IllegalArgumentException.class, () -> validatedList.add(7));
  }

}
