package ru.tinkoff.edu.stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import lombok.Data;
import org.junit.jupiter.api.Test;

public class SpliteratorTest {

  @Test
  public void tryAdvanceTest() {
    final var articles = Stream.generate(() -> new Article(0, "Java", List.of()))
        .limit(10)
        .collect(Collectors.toList());

    Spliterator<Article> spliterator = articles.spliterator();
    while (spliterator.tryAdvance(article -> System.out.println("Обрабатываем статью: " + article)))
      ;
  }

  @Test
  public void trySplitTest() {
    final var articles = Stream.generate(() -> new Article(0, "Java", List.of()))
        .limit(35000)
        .collect(Collectors.toList());

    Spliterator<Article> split1 = articles.spliterator();
    Spliterator<Article> split2 = split1.trySplit();

    List<Article> articlesListOne = new ArrayList<>();
    List<Article> articlesListTwo = new ArrayList<>();

    split1.forEachRemaining(articlesListOne::add);
    split2.forEachRemaining(articlesListTwo::add);

    assertEquals(articlesListOne.size(), 17500);
    assertEquals(articlesListTwo.size(), 17500);
  }

  @Test
  public void parallelReduceTest() {
    final var article = new Article(
        0, "Some Article",
        Arrays.asList(
            new Author("Sergey", 0), new Author("Eugen", 0), new Author("Alice", 1),
            new Author("Alice", 1), new Author("Mike", 0), new Author("Alice", 1),
            new Author("Mike", 0), new Author("Alice", 1), new Author("Mike", 0),
            new Author("Alice", 1), new Author("Mike", 0), new Author("Mike", 0),
            new Author("Alice", 1), new Author("Mike", 0), new Author("Alice", 1),
            new Author("Mike", 0), new Author("Alice", 1), new Author("Mike", 0),
            new Author("Alice", 1), new Author("Mike", 0), new Author("Michał", 0),
            new Author("Loredana", 1)));

    Stream<Author> stream1 = article.getListOfAuthors().stream();
    assertNotEquals(9, countAuthors(stream1.parallel()));

    final var spliterator = new SplitCounter(article.getListOfAuthors());

    Stream<Author> stream2 = StreamSupport.stream(spliterator, true);
    assertEquals(9, countAuthors(stream2.parallel()));
  }

  private static int countAuthors(Stream<Author> stream) {
    return stream.reduce(
            new BaseCounter(0, true),
            BaseCounter::accumulate, BaseCounter::combine)
        .getCounter();
  }

  @Data
  private static class Article {

    private final int id;
    private final String name;
    private final List<Author> listOfAuthors;

  }

  @Data
  private static class Author {

    private final String name;
    private final int relatedArticleId;

  }

  private static class BaseCounter {

    private final int counter;
    private final boolean isRelated;

    public BaseCounter(int counter, boolean isRelated) {
      this.counter = counter;
      this.isRelated = isRelated;
    }

    public BaseCounter accumulate(Author author) {
      if (author.getRelatedArticleId() == 0) {
        return isRelated ? this : new BaseCounter(counter, true);
      } else {
        return isRelated ? new BaseCounter(counter + 1, false) : this;
      }
    }

    public BaseCounter combine(BaseCounter other) {
      return new BaseCounter(counter + other.counter, other.isRelated);
    }

    public int getCounter() {
      return counter;
    }

  }

  private static class SplitCounter implements Spliterator<Author> {

    private final List<Author> list;
    AtomicInteger current = new AtomicInteger();

    public SplitCounter(List<Author> list) {
      this.list = list;
    }

    @Override
    public boolean tryAdvance(Consumer<? super Author> action) {

      action.accept(list.get(current.getAndIncrement()));
      return current.get() < list.size();
    }

    @Override
    public Spliterator<Author> trySplit() {
      int currentSize = list.size() - current.get();
      if (currentSize < 10) {
        return null;
      }

      for (
          int splitPos = currentSize / 2 + current.intValue();
          splitPos < list.size();
          splitPos++) {

        if (list.get(splitPos).getRelatedArticleId() == 0) {
          Spliterator<Author> spliterator = new SplitCounter(list.subList(current.get(), splitPos));
          current.set(splitPos);
          return spliterator;
        }
      }

      return null;
    }

    @Override
    public long estimateSize() {
      return list.size() - current.get();
    }

    @Override
    public int characteristics() {
      return CONCURRENT;
    }

  }

}
