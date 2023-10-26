package ru.tinkoff.edu.iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.IntStream;
import lombok.Data;
import org.junit.jupiter.api.Test;

class IteratorTest {

  @Test
  void iteratorTest() {
    // 1. Работа с итераторами
    final var collection = new ArrayList<>(IntStream.range(0, 100).boxed().toList());
    final var iterator = collection.listIterator();
    var isFirstCall = true;

    // 1. Проверяем, что данные все еще есть
    while (iterator.hasNext()) {
      // Получаем данные, без вызова метода курсор не сдвинется
      if (isFirstCall) {
        assertThrows(IllegalStateException.class, () -> iterator.remove());
        isFirstCall = false;
      }
      final var element = iterator.next();
      if (element % 2 == 0) {
        iterator.remove();
      } else {
        iterator.set(0);
      }
      assertTrue(element < 100 && element >= 0);
    }
    assertEquals(50, collection.size());
    assertEquals(0, collection.get(25));
  }

  @Test
  void customIteratorTest() {
    final var collection = IntStream.range(0, 101).boxed().toList();
    final var iterator = new SkippingIterator(collection);

    var elementsCnt = 0;
    while (iterator.hasNext()) {
      final var element = iterator.next();
      assertEquals(0, element % 2);
      elementsCnt++;
    }
    assertEquals(50, elementsCnt);
  }

  @Test
  void concurrentModificationTest() {
    final var collection = new ArrayList<>(IntStream.range(0, 100).boxed().toList());
    assertThrows(ConcurrentModificationException.class, () -> {
      for (var element : collection) {
        if (element % 2 == 0) {
          collection.remove(element);
        }
      }
    });
  }

  /**
   * {@link java.util.ArrayList} -> ListItr
   */
  @Data
  private static class SkippingIterator implements ListIterator<Integer> {

    private final List<Integer> collection;
    private int cursor = 0;

    @Override
    public boolean hasNext() {
      return cursor + 2 < collection.size();
    }

    @Override
    public Integer next() {
      cursor += 2;
      return collection.get(cursor);
    }

    @Override
    public boolean hasPrevious() {
      return cursor - 2 >= 0;
    }

    @Override
    public Integer previous() {
      cursor -= 2;
      return collection.get(cursor);
    }

    @Override
    public int nextIndex() {
      throw new UnsupportedOperationException();
    }

    @Override
    public int previousIndex() {
      throw new UnsupportedOperationException();
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException();
    }

    @Override
    public void set(Integer integer) {
      throw new UnsupportedOperationException();
    }

    @Override
    public void add(Integer integer) {
      throw new UnsupportedOperationException();
    }
  }

}
