package edu.hw6.test1;

import edu.hw6.task1.DiskMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DiskMapTest {
    private static final String FILE_PATH_FOR_PUT = "src/test/java/edu/hw6/test1/testToPut.txt";
    private static final String FILE_PATH_FOR_REMOVE = "src/test/java/edu/hw6/test1/testToRemove.txt";
    private static final String FILE_PATH_FOR_EMPTY = "src/test/java/edu/hw6/test1/textToEmpty";
    private static final String FILE_PATH_FOR_CONTAINS = "src/test/java/edu/hw6/test1/testToContains.txt";

    @ParameterizedTest
    @MethodSource("dataForDiskMap")
    @DisplayName("Жесткий диск - запись")
    void diskMapPutMethod_validInput_successTest(
        String key1,
        String key2,
        String key3,
        String value1,
        String value2,
        String value3
    ) {
        DiskMap diskMap = new DiskMap(FILE_PATH_FOR_PUT);

        diskMap.put(key1, value1);
        diskMap.put(key2, value2);
        diskMap.put(key3, value3);

        assertEquals(value1, diskMap.get(key1));
        assertEquals(value2, diskMap.get(key2));
        assertEquals(value3, diskMap.get(key3));
    }

    @ParameterizedTest
    @MethodSource("dataForDiskMap")
    @DisplayName("Жесткий диск - удаление")
    void diskMapRemoveMethod_validInput_successTest(
        String key1,
        String key2,
        String key3,
        String value1,
        String value2,
        String value3
    ) {
        DiskMap diskMap = new DiskMap(FILE_PATH_FOR_REMOVE);

        diskMap.put(key1, value1);
        diskMap.put(key2, value2);
        diskMap.put(key3, value3);

        assertEquals(value1, diskMap.remove(key1));
        assertNull(diskMap.get(key1));
        assertEquals(value3, diskMap.get(key3));
        assertEquals(value2, diskMap.get(key2));
    }

    @ParameterizedTest
    @MethodSource("dataForDiskMap")
    @DisplayName("Жесткий диск - проверка на пустоту")
    void diskMapIsEmptyMethod_validInput_successTest(
        String key1,
        String key2,
        String key3,
        String value1,
        String value2,
        String value3
    ) {
        DiskMap diskMap = new DiskMap(FILE_PATH_FOR_EMPTY);

        assertTrue(diskMap.isEmpty());

        diskMap.put(key1, value1);
        diskMap.put(key2, value2);
        diskMap.put(key3, value3);

        assertFalse(diskMap.isEmpty());

        assertEquals(3, diskMap.size());

        diskMap.remove(key1);
        diskMap.remove(key2);
        diskMap.remove(key3);
    }

    @ParameterizedTest
    @MethodSource("dataForDiskMap")
    @DisplayName("Жесткий диск - проверка на включение")
    void diskMapContainsMethod_validInput_successTest(
        String key1,
        String key2,
        String key3,
        String value1,
        String value2,
        String value3
    ) {
        DiskMap diskMap = new DiskMap(FILE_PATH_FOR_CONTAINS);

        diskMap.put(key1, value1);
        diskMap.put(key2, value2);

        assertTrue(diskMap.containsKey(key1));
        assertFalse(diskMap.containsKey(key3));
        assertTrue(diskMap.containsValue(value2));
        assertFalse(diskMap.containsValue(value3));
    }

    private static Stream<Arguments> dataForDiskMap() {
        return Stream.of(
            Arguments.of("Игра первая", "Игра вторая", "Игра третья", "Шрек", "Мадагаскар", "Пингвины из Мадагаскара"),
            Arguments.of("Игра первая", "Игра вторая", "Игра третья", "Мадагаскар", "Шрек", "Пингвины из Мадагаскара"),
            Arguments.of("Порт первая", "Игра вторая", "Игра третья", "Пингвины из Мадагаскара", "Мадагаскар", "Шрек")
        );
    }
}
