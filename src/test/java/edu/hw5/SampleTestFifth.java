package edu.hw5;

import edu.hw4.Animal;
import edu.hw4.AnimalTasks;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import static edu.hw5.task1.ComputerClubAnalytics.calculateAverageSessionDuration;
import static edu.hw5.task2.FridayThirteenFinder.findFridaysThirteens;
import static edu.hw5.task2.FridayThirteenFinder.findNextFridayThirteen;
import static edu.hw5.task3.DateParser.parseDate;
import static edu.hw5.task4.PasswordValidator.validatePassword;
import static edu.hw5.task5.CarNumberValidator.validateCarNumber;
import static edu.hw5.task6.SubsequenceValidator.isSubsequence;
import static edu.hw5.task7.SubsequenceValidatorForNumber.containsAtLeastThreeCharsWithThirdZero;
import static edu.hw5.task7.SubsequenceValidatorForNumber.lengthBetweenOneAndTree;
import static edu.hw5.task7.SubsequenceValidatorForNumber.startsAndEndsWithSameChar;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SampleTestFifth {
    @ParameterizedTest
    @MethodSource("dataForComputerClubAnalytics")
    @DisplayName("Среднее время")
    void computerClubAnalytics_validInputArrayList_successTest(List<String> dates, String res) {
        Duration avr = calculateAverageSessionDuration(dates);
        String result = avr.toHours() + "ч " +
            (avr.toMinutes() % 60) + "м";

        assertThat(result).isEqualTo(res);
    }

    private static Stream<Arguments> dataForComputerClubAnalytics() {
        return Stream.of(
            Arguments.of(Arrays.asList(
                "2023-03-21, 20:00 - 2023-03-22, 01:00",
                "2022-09-01, 22:00 - 2022-09-02, 01:20"
            ), "4ч 10м")
        );
    }

    @ParameterizedTest
    @MethodSource("dataForFridayThirteenFinder")
    @DisplayName("Количество пятниц 13-х в году")
    void fridayThirteenFinder_validInputArrayList_successTest(int year, String res) {
        List<LocalDate> fridaysThirteens = findFridaysThirteens(year);
        String result = "Fridays the 13th in " + year + ": " + fridaysThirteens;

        assertThat(result).isEqualTo(res);
    }

    private static Stream<Arguments> dataForFridayThirteenFinder() {
        return Stream.of(
            Arguments.of(1855, "Fridays the 13th in 1855: [1855-04-13, 1855-07-13]"),
            Arguments.of(1900, "Fridays the 13th in 1900: [1900-04-13, 1900-07-13]")
        );
    }

    @ParameterizedTest
    @MethodSource("dataForFindNextFridayThirteen")
    @DisplayName("Следующая пятница 13-ое")
    void findNextFridayThirteen_validInputArrayList_successTest(int year, int month, int day, String res) {
        LocalDate date = LocalDate.of(year, month, day);
        LocalDate nextFridayThirteen = findNextFridayThirteen(date);
        String result = "Next Friday the 13th after " + date + ": " + nextFridayThirteen;

        assertThat(result).isEqualTo(res);
    }

    private static Stream<Arguments> dataForFindNextFridayThirteen() {
        return Stream.of(
            Arguments.of(2023, 11, 19, "Next Friday the 13th after 2023-11-19: 2024-09-13"),
            Arguments.of(2025, 5, 19, "Next Friday the 13th after 2025-05-19: 2025-06-13")
        );
    }

    @ParameterizedTest
    @MethodSource("dataForDateParser")
    @DisplayName("Парсинг дат")
    void dateParser_validInputArrayList_successTest(String date, String res) {
        Optional<LocalDate> validDate = parseDate(date);
        String result = validDate.toString();

        assertThat(result).isEqualTo(res);
    }

    private static Stream<Arguments> dataForDateParser() {
        return Stream.of(
            Arguments.of("edsfsfds", "Optional.empty"),
            Arguments.of("05-11-22", "Optional.empty")
        );
    }

    @ParameterizedTest
    @MethodSource("dataForPasswordValidator")
    @DisplayName("Валидация пароля")
    void passwordValidator_validInputArrayList_successTest(String pass, boolean res) {
        boolean result = validatePassword(pass);

        assertThat(result).isEqualTo(res);
    }

    private static Stream<Arguments> dataForPasswordValidator() {
        return Stream.of(
            Arguments.of("edsfsfds", false),
            Arguments.of("edsf@#sfds", true),
            Arguments.of("05-11-22", false)
        );
    }

    @ParameterizedTest
    @MethodSource("dataForCarNumberValidator")
    @DisplayName("Валидация номеров машин")
    void carNumberValidator_validInputArrayList_successTest(String pass, boolean res) {
        boolean result = validateCarNumber(pass);

        assertThat(result).isEqualTo(res);
    }

    private static Stream<Arguments> dataForCarNumberValidator() {
        return Stream.of(
            Arguments.of("В125АВ777", true),
            Arguments.of("edsf@#sfds", false),
            Arguments.of("К555КК999", true)
        );
    }

    @ParameterizedTest
    @MethodSource("dataForSubsequenceValidator")
    @DisplayName("Регулярные выражения для строк - 1")
    void subsequenceValidator_validInputArrayList_successTest(String str, String subStr, boolean res) {
        boolean result = isSubsequence(str, subStr);

        assertThat(result).isEqualTo(res);
    }

    private static Stream<Arguments> dataForSubsequenceValidator() {
        return Stream.of(
            Arguments.of("awd", "awjdkawjawdjkjklfdnmkl", true),
            Arguments.of("edsf@#sfds", "sadawdefdsg@#@D#@DSF", false),
            Arguments.of("К555КК999", "dsfsdfsdf8795468К555КК99989ds4a656wa85d", true)
        );
    }

    @ParameterizedTest
    @MethodSource("dataForContainsAtLeastThreeCharsWithThirdZero")
    @DisplayName("Регулярные выражения для строк - 2.1")
    void containsAtLeastThreeCharsWithThirdZero_validInputArrayList_successTest(String str, boolean res) {
        boolean result = containsAtLeastThreeCharsWithThirdZero(str);

        assertThat(result).isEqualTo(res);
    }

    private static Stream<Arguments> dataForContainsAtLeastThreeCharsWithThirdZero() {
        return Stream.of(
            Arguments.of("11011", true),
            Arguments.of("120123", false),
            Arguments.of("0001", true)
        );
    }

    @ParameterizedTest
    @MethodSource("dataForStartsAndEndsWithSameChar")
    @DisplayName("Регулярные выражения для строк - 2.2")
    void startsAndEndsWithSameChar_validInputArrayList_successTest(String str, boolean res) {
        boolean result = startsAndEndsWithSameChar(str);

        assertThat(result).isEqualTo(res);
    }

    private static Stream<Arguments> dataForStartsAndEndsWithSameChar() {
        return Stream.of(
            Arguments.of("11011", true),
            Arguments.of("120123", false),
            Arguments.of("0001", false)
        );
    }

    @ParameterizedTest
    @MethodSource("dataForLengthBetweenOneAndTree")
    @DisplayName("Регулярные выражения для строк - 2.3")
    void lengthBetweenOneAndTree_validInputArrayList_successTest(String str, boolean res) {
        boolean result = lengthBetweenOneAndTree(str);

        assertThat(result).isEqualTo(res);
    }

    private static Stream<Arguments> dataForLengthBetweenOneAndTree() {
        return Stream.of(
            Arguments.of("11011", false),
            Arguments.of("120123", false),
            Arguments.of("01", true)
        );
    }
}
