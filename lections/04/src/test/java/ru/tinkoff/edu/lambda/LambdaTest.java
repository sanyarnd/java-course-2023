package ru.tinkoff.edu.lambda;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

class LambdaTest {

  private String someField = "test";

  @Test
  void lambdaTest() {
    final var collection = IntStream.range(0, 100).boxed().toList();

    // final Filter<Integer> isEven1 = (String it) -> it.length() > 0;
    final Filter<Integer> isEven = it -> it % 2 == 0;
    final Filter<Integer> isOdd = (Integer it) -> it % 2 == 0;
    final Filter<Integer> canBeDividedByThree = it -> it % 3 == 0;
    final Filter<Integer> filter = isEven.and(canBeDividedByThree);
    final Consumer<String> printer = (String line) -> System.out.println(line);
    final Consumer<String> printerMethod = System.out::println;
    final Filter<Integer> filterAnon = new Filter<Integer>() {
      @Override
      public boolean isConditionMatched(Integer object) {
        return false;
      }
    };

    final var result = new ArrayList<Integer>();
    for (final var element : collection) {
      if (filter.isConditionMatched(element)) {
        result.add(element);
      }
    }

    assertEquals(17, result.size());
    assertTrue(result.stream().allMatch(it -> it % 6 == 0));

    // Доступ к переменным
    final var collectionCopy1 = collection;
    // collectionCopy1 = result;
    var collectionCopy2 = new ArrayList<Integer>();

    final Filter<Integer> anotherFilter = it -> {
      if (collectionCopy1.size() > 10) {
        return true;
      }
      if (collectionCopy2.size() > 10) {
        integerFilter(10);
        // or();
        return someField.startsWith("!");
      }
      return it % 10 == 0;
    };

    // collectionCopy2 = new ArrayList<Integer>();
    // someField = "10";

    final Filter<Integer> methodRefFilter = this::integerFilter;
  }

  private boolean integerFilter(int value) {
    return true;
  }

  @FunctionalInterface
  private interface Filter<O> {

    boolean isConditionMatched(O object);

    default Filter<O> or(Filter<O> filter) {
      return object -> isConditionMatched(object) || filter.isConditionMatched(object);
    }

    default Filter<O> and(Filter<O> filter) {
      return object -> isConditionMatched(object) && filter.isConditionMatched(object);
    }

  }

}
