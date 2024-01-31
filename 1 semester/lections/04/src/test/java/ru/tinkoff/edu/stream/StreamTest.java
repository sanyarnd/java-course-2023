package ru.tinkoff.edu.stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import lombok.Data;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;

class StreamTest {

  private static final Random RANDOM = new Random();
  private static final EasyRandom EASY_RANDOM = new EasyRandom();


  @Test
  void streamTest() {
    // 1. Создание стримов
    printStream(Stream.empty());
    printStream(Stream.of(1, 2, 3, 4));
    printStream((new ArrayList<Integer>()).stream());
    printStream((new HashMap<Integer, Integer>()).entrySet().stream());
    printStream(Arrays.stream(new int[]{1, 2, 3, 4}).boxed());
    printStream(
        Stream.builder()
            .add(1)
            .add(2)
            .build());
    printStream(Stream.generate(RANDOM::nextInt).limit(10));
    printStream(Stream.iterate(0, it -> it + 2).limit(10));

    // 1.1 Примитивные стримы - избегаем автобоксинга
    printStream(IntStream.range(0, 10).boxed());
    printStream(LongStream.range(0, 10).boxed());
    printStream(DoubleStream.of(0, 10).boxed());

    // 2. Стримы - очень ленивые
    final var someStream = IntStream.range(0, 10).boxed()
        .peek(it -> System.out.println("Обрабатываем элемент " + it));

    System.out.println("\nНачало обработки");
    someStream.forEach(it -> System.out.println("Обработали элемент " + it));

    // 3. Stream pipeline
    System.out.println("\nНачало обработки");
    IntStream.range(0, 10).boxed()
        // intermediate ops (отладка)
        .peek(it -> System.out.println("Начали обрабатывать элемент " + it))
        .filter(it -> it % 2 == 0)
        .peek(it -> System.out.println("После первой фильтрации остался элемент " + it))
        .filter(it -> it % 3 == 0)
        .peek(it -> System.out.println("После второй фильтрации остался элемент " + it))
        .map(it -> it * it)
        .peek(it -> System.out.println("После возведения в квадрат остался элемент " + it))
        // .anyMatch(it -> it == 0);
        .sorted()
        .distinct()
        .limit(10)
        // .dropWhile()
        // .takeWhile()
        .skip(0)
        // terminal op
        .forEach(it -> System.out.println("Итоговый элемент: " + it));

    // 4. Reduce & Collect
    assertEquals(
        155,
        IntStream.rangeClosed(0, 10).boxed()
            .reduce(100, Integer::sum));

    final List<DataClass> list = generateRandomStream()
        .toList();
    final Set<DataClass> set = generateRandomStream()
        .collect(Collectors.toSet());
    final Map<Long, DataClass> map = generateRandomStream()
        .collect(
            Collectors.toMap(
                DataClass::getId,
                Function.identity()));
    final Map<String, List<DataClass>> multimap = generateRandomStream()
        .collect(Collectors.groupingBy(DataClass::getName));

    assertEquals(
        5.0,
        IntStream.rangeClosed(0, 10).boxed()
            .collect(Collectors.averagingDouble(Integer::doubleValue)),
        1e-6);

    assertTrue(
        IntStream.rangeClosed(0, 10).boxed()
            .anyMatch(it -> it % 2 == 0));

    final var stats = IntStream.rangeClosed(0, 10).boxed()
        .collect(Collectors.summarizingInt(Integer::intValue));
    assertEquals(55, stats.getSum());
    assertEquals(10, stats.getMax());
    assertEquals(0, stats.getMin());
    assertEquals(5.0, stats.getAverage());
    assertEquals(11, stats.getCount());

    // 5. Ссылки на стримы (stateful & stateless op)
    final var intStream = IntStream.range(0, 10).boxed();
    final var intStreamCopy = intStream;

    intStream.findFirst();
    assertThrows(IllegalStateException.class, () -> intStream.findFirst());
    assertThrows(IllegalStateException.class, () -> intStreamCopy.findFirst());
  }

  @Test
  void parallelStreamTest() {
    // ForkJoin Pool
    printStream(
        IntStream.range(0, 10).boxed()
            .peek(it -> logOp("peek", it))
            .parallel()
            .filter(it -> {
              logOp("filter", it);
              return it % 2 == 0;
            })
            .peek(it -> logOp("peek after filter", it))
            // .sequential()
            // .unordered()
            // .forEachOrdered()
            .peek(it -> logOp("peek after sequential", it)));

    System.out.println("\nБез сохранения последовательности элементов");
    printStream(
        IntStream.range(0, 10).boxed()
            .sequential()
            .peek(it -> logOp("peek", it))
            .parallel()
            .filter(it -> {
              logOp("filter", it);
              return it % 2 == 0;
            })
            .peek(it -> logOp("peek after filter", it))
            .unordered());
  }

  private static <E> void printStream(Stream<E> stream) {
    var elements = stream.map(Object::toString).collect(Collectors.joining(", "));
    System.out.println("Элементы стрима: " + elements);
  }

  private static Stream<DataClass> generateRandomStream() {
    return IntStream.range(0, 10)
        .mapToObj(it -> EASY_RANDOM.nextObject(DataClass.class));
  }

  private static void logOp(String op, Integer element) {
    System.out.printf(
        "Выполняем операция %s над элементом %s в потоке %s%n",
        op, element, Thread.currentThread().getName());
  }

  @Data
  private static class DataClass {

    private long id;
    private String name;

  }

}
