package edu.hw3;

import edu.hw2.task3.Connection;
import edu.hw2.task3.ConnectionException;
import edu.hw2.task3.ConnectionManager;
import edu.hw2.task3.DefaultConnectionManager;
import edu.hw3.task1.AtbashCipher;
import edu.hw3.task4.RomanNumerals;
import edu.hw3.task6.Stock;
import edu.hw3.task6.StockMarket;
import edu.hw3.task6.StockMarketImpl;
import edu.hw3.task7.TreeAndNull;
import edu.hw3.task8.ReverseIterator;
import org.apache.commons.collections.comparators.NullComparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;
import static edu.hw3.task2.ClusteringBrackets.clusterize;
import static edu.hw3.task3.FrequencyOfWords.countOfWords;
import static edu.hw3.task4.RomanNumerals.getRomanNumber;
import static edu.hw3.task5.ContactlList.parseContacts;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SampleTestThree {
    @ParameterizedTest
    @MethodSource("data_for_atbashCipher")
    @DisplayName("Шифр Атбаш")
    void atbashCipher_validInputString_successTest(String word, String res) {
        String result = AtbashCipher.encrypt(word);

        assertThat(result).isEqualTo(res);
    }
    private static Stream<Arguments> data_for_atbashCipher() {
        return Stream.of(
            Arguments.of("AAZZAAZZ", "ZZAAZZAA"),
            Arguments.of("All the best and thanks for the fish", "Zoo gsv yvhg zmw gszmph uli gsv urhs")
        );
    }

    @ParameterizedTest
    @MethodSource("data_for_clusterize")
    @DisplayName("Кластеризация скобок")
    void clusterize_validInputString_successTest(String word, List<String> res) {
        List<String> result = clusterize(word);

        assertThat(result).isEqualTo(res);
    }
    private static Stream<Arguments> data_for_clusterize() {
        return Stream.of(
            Arguments.of("(())()()((((()))))()()", Arrays.asList ("(())", "()", "()", "((((()))))", "()", "()")),
            Arguments.of("(((())))(())()()()(())", Arrays.asList ("(((())))", "(())", "()", "()", "()", "(())"))
        );
    }

    @ParameterizedTest
    @MethodSource("data_for_countOfWords")
    @DisplayName("Частота слов")
    void countOfWords_validInputList_successTest(List<String> word) {
        Map<Object, Integer> res = new HashMap<>();
        res.put("to", 2);
        res.put("be", 2);
        res.put("or", 1);
        res.put("not", 1);

        Map<String, Integer> result = countOfWords(word);

        assertThat(result).isEqualTo(res);
    }
    private static Stream<Arguments> data_for_countOfWords() {
        return Stream.of(
            Arguments.of(Arrays.asList("to", "be", "or", "not", "to", "be"))
        );
    }

    @ParameterizedTest
    @MethodSource("data_for_RomanNumber")
    @DisplayName("Римские цифры")
    void romanNumber_validInputNumber_successTest(int number, String res) {
        String result = getRomanNumber(number);

        assertThat(result).isEqualTo(res);
    }
    private static Stream<Arguments> data_for_RomanNumber() {
        return Stream.of(
            Arguments.of(566, "DLXVI"),
            Arguments.of(696, "DCXCVI")
        );
    }

    @ParameterizedTest
    @MethodSource("data_for_parseContactsAsc")
    @DisplayName("Список контактов по возрастанию")
    void parseContactsAsc_validInputNumber_successTest(String[] names, String order) {
        String[] result;
        String[] res;

        result = parseContacts(names, order);
        res = new String[] {"Sandy Chicks", "Eugene Krabs", "Squidward Octopus", "Sheldon Plankton", "Gary Snail", "SpongeBob Squepens", "Patrick Star"};

        assertThat(Arrays.toString(result)).isEqualTo(Arrays.toString(res));
    }
    private static Stream<Arguments> data_for_parseContactsAsc() {
        return Stream.of(
            Arguments.of(new String[] {"SpongeBob Squepens", "Squidward Octopus", "Eugene Krabs", "Patrick Star", "Sandy Chicks", "Sheldon Plankton", "Gary Snail"}, "ASC")
        );
    }

    @ParameterizedTest
    @MethodSource("data_for_parseContactsDesc")
    @DisplayName("Список контактов по убываюнию")
    void parseContactsDesc_validInputNumber_successTest(String[] names, String order) {
        String[] result;
        String[] res;

        result = parseContacts(names, order);
        res = new String[]{"Patrick Star", "SpongeBob Squepens", "Gary Snail", "Sheldon Plankton", "Squidward Octopus", "Eugene Krabs", "Sandy Chicks"};

        assertThat(Arrays.toString(result)).isEqualTo(Arrays.toString(res));
    }
    private static Stream<Arguments> data_for_parseContactsDesc() {
        return Stream.of(
            Arguments.of(new String[] {"SpongeBob Squepens", "Squidward Octopus", "Eugene Krabs", "Patrick Star", "Sandy Chicks", "Sheldon Plankton", "Gary Snail"}, "DESC")
        );
    }

    @ParameterizedTest
    @MethodSource("data_for_StockMarket")
    @DisplayName("Биржа")
    void StockMarket_validInputNumber_successTest(String[] name, double[] price, String res) {
        StockMarket market = new StockMarketImpl();
        for(int i = 0 ; i < name.length ; i++){
            Stock stock = new Stock(name[i], price[i]);
            market.add(stock);
        }

        String result = market.mostValuableStock().getSymbol();

        assertThat(result).isEqualTo(res);
    }
    private static Stream<Arguments> data_for_StockMarket() {
        return Stream.of(
            Arguments.of(new String[] {"Apple", "Aaple", "Aplle", "Aplee"}, new double[] {19650.50, 19890.50, 15650.50, 11450.50}, "Aaple"),
            Arguments.of(new String[] {"Google", "Ggogle", "Goggle", "Goglle"}, new double[] {89650.50, 45890.50, 15650.50, 45450.50}, "Google")
        );
    }

    @ParameterizedTest
    @MethodSource("data_for_TreeAndNull")
    @DisplayName("Дерево и null")
    void treeAndNull_validInputNumber_successTest(String text) {
        TreeMap<String, String> tree = new TreeMap<>(new TreeAndNull<>());
        tree.put(null, text);
        assertTrue(tree.containsKey(null));

        TreeAndNull<Object> comparator = new TreeAndNull<>();
        int result = comparator.compare(null, null);
        assertEquals(0, result);
    }

    private static Stream<Arguments> data_for_TreeAndNull() {
        return Stream.of(
            Arguments.of("pervii"),
            Arguments.of("vtoroii")
        );
    }

    @ParameterizedTest
    @MethodSource("data_for_ReverseIterator")
    @DisplayName("Обратный итератор")
    void reverseIterator_validInputNumber_successTest(List<Integer> numbers, List<Integer> res) {
        ReverseIterator<Integer> mas = new ReverseIterator<>(numbers);
        List<Integer> result = new ArrayList<Integer>();

        while (mas.hasNext()) {
            result.add(mas.next());
        }

        assertThat(result).isEqualTo(res);
    }
    private static Stream<Arguments> data_for_ReverseIterator() {
        return Stream.of(
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10),Arrays.asList(10, 9, 8, 7, 6, 5, 4, 3, 2, 1)),
            Arguments.of(Arrays.asList(1000, 900, 800, 700, 600, 500, 400, 300, 200, 100),Arrays.asList(100, 200, 300, 400, 500, 600, 700, 800, 900, 1000))
        );
    }
}
