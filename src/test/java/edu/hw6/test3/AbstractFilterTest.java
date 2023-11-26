package edu.hw6.test3;

import edu.hw6.task3.Filter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class AbstractFilterTest {
    @ParameterizedTest
    @MethodSource("providePaths")
    @DisplayName("Метод - больше чем")
    void filterLargerThan_successTest(Path path) throws IOException {
        long size = 1024;
        boolean result = Filter.largerThan(size).accept(path);
        Assertions.assertFalse(
            result,
            "Метод Filter `larger Than` должен возвращать значение false для предоставленного пути"
        );
    }

    @ParameterizedTest
    @MethodSource("providePaths")
    @DisplayName("Метод - магические числа")
    void filterMagicNumber_successTest(Path path) throws IOException {
        int[] magicBytes = {0x50, 0x4B, 0x03, 0x04};
        boolean result = Filter.magicNumber(magicBytes).accept(path);
        Assertions.assertFalse(
            result,
            "Метод Filter `magicNumber` должен возвращать значение false для предоставленного пути"
        );
    }

    @ParameterizedTest
    @MethodSource("providePaths")
    @DisplayName("Метод - глобальные совпадения")
    void filterGlobMatches_successTest(Path path) throws IOException {
        String glob = ".txt";
        boolean result = Filter.globMatches(glob).accept(path);
        Assertions.assertFalse(
            result,
            "Метод Filter `globMatches` должен возвращать значение false для предоставленного пути"
        );
    }

    @ParameterizedTest
    @MethodSource("providePaths")
    @DisplayName("Метод - включения в себя регулярного выражения")
    void filterRegexContains_successTest(Path path) throws IOException {
        String regex = ".*\\.txt";
        boolean result = Filter.regexContains(regex).accept(path);
        Assertions.assertTrue(
            result,
            "Метод Filter `regexContains` должен возвращать значение true для предоставленного пути"
        );
    }

    static Stream<Path> providePaths() {
        return Stream.of(
            Paths.get("src/test/java/edu/hw6/test3/fileToTest1.txt"),
            Paths.get("src/test/java/edu/hw6/test3/fileToTest2.txt"),
            Paths.get("src/test/java/edu/hw6/test3/fileToTest3.txt")
        );
    }
}
