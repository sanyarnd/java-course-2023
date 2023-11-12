package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SampleTest4 {
    @ParameterizedTest
    @MethodSource("dataForSortByHeight")
    @DisplayName("Сортировка животных по росту")
    void sortByHeight_validInputArrayList_successTest(List<Animal> animals, List<Animal> res) {
        List<Animal> result = AnimalTasks.sortByHeight(animals);

        assertThat(result).isEqualTo(res);
    }
    private static Stream<Arguments> dataForSortByHeight() {
        return Stream.of(
            Arguments.of(Arrays.asList(
                new Animal("Бомбино", Animal.Type.CAT, Animal.Sex.M, 3, 30, 5, true),
                new Animal("Хатико", Animal.Type.DOG, Animal.Sex.M, 200, 64, 41, true),
                new Animal("БомБом", Animal.Type.CAT, Animal.Sex.M, 3, 30, 5, true),
                new Animal("БимБим", Animal.Type.BIRD, Animal.Sex.M, 200, 64, 41, true)
            ), Arrays.asList(
                new Animal("Бомбино", Animal.Type.CAT, Animal.Sex.M, 3, 30, 5, true),
                new Animal("БомБом", Animal.Type.CAT, Animal.Sex.M, 3, 30, 5, true),
                new Animal("Хатико", Animal.Type.DOG, Animal.Sex.M, 200, 64, 41, true),
                new Animal("БимБим", Animal.Type.BIRD, Animal.Sex.M, 200, 64, 41, true)
            ))
        );
    }

    @ParameterizedTest
    @MethodSource("dataForSortByWeight")
    @DisplayName("Сортировка животных по весу")
    void sortByWeight_validInputArrayList_successTest(List<Animal> animals, List<Animal> res, int count) {
        List<Animal> result = AnimalTasks.sortByWeight(animals, count);

        assertThat(result).isEqualTo(res);
    }
    private static Stream<Arguments> dataForSortByWeight() {
        return Stream.of(
            Arguments.of(Arrays.asList(
                new Animal("Бомбино", Animal.Type.CAT, Animal.Sex.M, 3, 30, 50, true),
                new Animal("Хатико", Animal.Type.DOG, Animal.Sex.M, 200, 64, 41, true),
                new Animal("БомБом", Animal.Type.CAT, Animal.Sex.M, 3, 30, 5, true),
                new Animal("БимБим", Animal.Type.BIRD, Animal.Sex.M, 200, 64, 36, true)
            ), Arrays.asList(
                new Animal("Бомбино", Animal.Type.CAT, Animal.Sex.M, 3, 30, 50, true),
                new Animal("Хатико", Animal.Type.DOG, Animal.Sex.M, 200, 64, 41, true)
            ), 2)
        );
    }

    @ParameterizedTest
    @MethodSource("dataForCountByType")
    @DisplayName("Количество животных каждого вида")
    void countByType_validInputArrayList_successTest(List<Animal> animals, Map<Animal.Type, Long> res) {
        Map<Animal.Type, Long> result = AnimalTasks.countByType(animals);

        assertThat(result).isEqualTo(res);
    }
    private static Stream<Arguments> dataForCountByType() {
        return Stream.of(
            Arguments.of(Arrays.asList(
                new Animal("Бомбино", Animal.Type.CAT, Animal.Sex.M, 3, 30, 50, true),
                new Animal("Хатико", Animal.Type.DOG, Animal.Sex.M, 200, 64, 41, true),
                new Animal("БомБом", Animal.Type.CAT, Animal.Sex.M, 3, 30, 5, true),
                new Animal("БимБим", Animal.Type.BIRD, Animal.Sex.M, 200, 64, 36, true)
            ), Map.of(
                Animal.Type.CAT, 2L,
                Animal.Type.DOG, 1L,
                Animal.Type.BIRD, 1L
            ))
        );
    }

    @ParameterizedTest
    @MethodSource("dataForGetLongestName")
    @DisplayName("Самое длинное имя")
    void getLongestName_validInputArrayList_successTest(List<Animal> animals, Optional<Animal> res) {
        Optional<Animal> result = AnimalTasks.getLongestName(animals);

        assertThat(result).isEqualTo(res);
    }
    private static Stream<Arguments> dataForGetLongestName() {
        return Stream.of(
            Arguments.of(Arrays.asList(
                new Animal("Бомбиноc", Animal.Type.CAT, Animal.Sex.M, 3, 30, 50, true),
                new Animal("Хатик", Animal.Type.DOG, Animal.Sex.M, 200, 64, 41, true),
                new Animal("БомБом", Animal.Type.CAT, Animal.Sex.M, 3, 30, 5, true),
                new Animal("БимБим", Animal.Type.BIRD, Animal.Sex.M, 200, 64, 36, true)
            ), Optional.of(new Animal("Бомбиноc", Animal.Type.CAT, Animal.Sex.M, 3, 30, 50, true)))
        );
    }

    @ParameterizedTest
    @MethodSource("dataForNumberOfAnimalsByGender")
    @DisplayName("Самый распространенный пол")
    void numberOfAnimalsByGender_validInputArrayList_successTest(List<Animal> animals, String res) {
        String result = AnimalTasks.numberOfAnimalsByGender(animals);

        assertThat(result).isEqualTo(res);
    }
    private static Stream<Arguments> dataForNumberOfAnimalsByGender() {
        return Stream.of(
            Arguments.of(Arrays.asList(
                new Animal("Бомбиноc", Animal.Type.CAT, Animal.Sex.M, 3, 30, 50, true),
                new Animal("Хатик", Animal.Type.DOG, Animal.Sex.M, 200, 64, 41, true),
                new Animal("БомБом", Animal.Type.CAT, Animal.Sex.F, 3, 30, 5, true),
                new Animal("БимБим", Animal.Type.BIRD, Animal.Sex.M, 200, 64, 36, true)
            ), "Самцов больше")
        );
    }

    @ParameterizedTest
    @MethodSource("dataForHeaviestByType")
    @DisplayName("Самое тяжелое животное каждого вида")
    void heaviestByType_validInputArrayList_successTest(List<Animal> animals, Map<Animal.Type, Optional<Animal>> res) {
        Map<Animal.Type, Optional<Animal>> result = AnimalTasks.heaviestByType(animals);

        assertThat(result).isEqualTo(res);
    }
    private static Stream<Arguments> dataForHeaviestByType() {
        return Stream.of(
            Arguments.of(Arrays.asList(
                new Animal("Бомбиноc", Animal.Type.CAT, Animal.Sex.M, 3, 30, 50, true),
                new Animal("Хатико", Animal.Type.DOG, Animal.Sex.M, 200, 64, 41, true),
                new Animal("БомБом", Animal.Type.CAT, Animal.Sex.F, 3, 30, 5, true),
                new Animal("БимБим", Animal.Type.BIRD, Animal.Sex.M, 200, 64, 36, true)
            ), Map.of(
                Animal.Type.CAT, Optional.of(new Animal("Бомбиноc", Animal.Type.CAT, Animal.Sex.M, 3, 30, 50, true)),
                Animal.Type.DOG, Optional.of(new Animal("Хатико", Animal.Type.DOG, Animal.Sex.M, 200, 64, 41, true)),
                Animal.Type.BIRD, Optional.of(new Animal("БимБим", Animal.Type.BIRD, Animal.Sex.M, 200, 64, 36, true))
            ))
        );
    }

    @ParameterizedTest
    @MethodSource("dataForOldestAnimal")
    @DisplayName("K-е самое старое животное")
    void oldestAnimal_validInputArrayList_successTest(List<Animal> animals, Animal res, int age) {
        Animal result = AnimalTasks.oldestAnimal(animals, age);

        assertThat(result).isEqualTo(res);
    }
    private static Stream<Arguments> dataForOldestAnimal() {
        return Stream.of(
            Arguments.of(Arrays.asList(
                new Animal("Бомбиноc", Animal.Type.CAT, Animal.Sex.M, 14, 30, 50, true),
                new Animal("Хатико", Animal.Type.DOG, Animal.Sex.M, 201, 64, 41, true),
                new Animal("БомБом", Animal.Type.CAT, Animal.Sex.F, 3, 30, 5, true),
                new Animal("БимБим", Animal.Type.BIRD, Animal.Sex.M, 20, 64, 36, true)
            ), new Animal("БимБим", Animal.Type.BIRD, Animal.Sex.M, 20, 64, 36, true), 2)
        );
    }

    @ParameterizedTest
    @MethodSource("dataForHeaviestAnimal")
    @DisplayName("Самое тяжелое животное среди животных ниже k см")
    void heaviestAnimal_validInputArrayList_successTest(List<Animal> animals, Optional<Animal> res, int height) {
        Optional<Animal> result = AnimalTasks.heaviestAnimal(animals, height);

        assertThat(result).isEqualTo(res);
    }
    private static Stream<Arguments> dataForHeaviestAnimal() {
        return Stream.of(
            Arguments.of(Arrays.asList(
                new Animal("Бомбиноc", Animal.Type.CAT, Animal.Sex.M, 3, 10, 50, true),
                new Animal("Хатик", Animal.Type.DOG, Animal.Sex.M, 200, 64, 41, true),
                new Animal("БомБом", Animal.Type.CAT, Animal.Sex.M, 3, 9, 5, true),
                new Animal("БимБим", Animal.Type.BIRD, Animal.Sex.M, 200, 64, 36, true)
            ), Optional.of(new Animal("Бомбиноc", Animal.Type.CAT, Animal.Sex.M, 3, 10, 50, true)), 20)
        );
    }

    @ParameterizedTest
    @MethodSource("dataForSumOfPaws")
    @DisplayName("Сколько в сумме лап у животных в списке")
    void sumOfPaws_validInputArrayList_successTest(List<Animal> animals, int res) {
        int result = AnimalTasks.sumOfPaws(animals);

        assertThat(result).isEqualTo(res);
    }
    private static Stream<Arguments> dataForSumOfPaws() {
        return Stream.of(
            Arguments.of(Arrays.asList(
                new Animal("Бомбиноc", Animal.Type.CAT, Animal.Sex.M, 3, 10, 50, true),
                new Animal("Хатик", Animal.Type.DOG, Animal.Sex.M, 200, 64, 41, true),
                new Animal("БомБом", Animal.Type.CAT, Animal.Sex.M, 3, 9, 5, true),
                new Animal("БимБим", Animal.Type.BIRD, Animal.Sex.M, 200, 64, 36, true)
            ), 14)
        );
    }
    @ParameterizedTest
    @MethodSource("dataForDifferentPaws")
    @DisplayName("Список животных, возраст у которых не совпадает с количеством лап")
    void differentPaws_validInputArrayList_successTest(List<Animal> animals, List<Animal> res) {
        List<Animal> result = AnimalTasks.differentPaws(animals);

        assertThat(result).isEqualTo(res);
    }
    private static Stream<Arguments> dataForDifferentPaws() {
        return Stream.of(
            Arguments.of(Arrays.asList(
                new Animal("Бомбиноc", Animal.Type.CAT, Animal.Sex.M, 3, 10, 50, true),
                new Animal("Хатик", Animal.Type.DOG, Animal.Sex.M, 200, 64, 41, true),
                new Animal("БомБом", Animal.Type.CAT, Animal.Sex.M, 3, 9, 5, true),
                new Animal("БимБим", Animal.Type.BIRD, Animal.Sex.M, 200, 64, 36, true)
            ), Arrays.asList(
                new Animal("Бомбиноc", Animal.Type.CAT, Animal.Sex.M, 3, 10, 50, true),
                new Animal("Хатик", Animal.Type.DOG, Animal.Sex.M, 200, 64, 41, true),
                new Animal("БомБом", Animal.Type.CAT, Animal.Sex.M, 3, 9, 5, true),
                new Animal("БимБим", Animal.Type.BIRD, Animal.Sex.M, 200, 64, 36, true)
            ))
        );
    }

    @ParameterizedTest
    @MethodSource("dataForBiteAndHighAnimals")
    @DisplayName("Список животных, которые могут укусить")
    void biteAndHighAnimals_validInputArrayList_successTest(List<Animal> animals, List<Animal> res) {
        List<Animal> result = AnimalTasks.biteAndHighAnimals(animals);

        assertThat(result).isEqualTo(res);
    }
    private static Stream<Arguments> dataForBiteAndHighAnimals() {
        return Stream.of(
            Arguments.of(Arrays.asList(
                new Animal("Бомбиноc", Animal.Type.CAT, Animal.Sex.M, 3, 10, 50, true),
                new Animal("Хатик", Animal.Type.DOG, Animal.Sex.M, 200, 64, 41, true),
                new Animal("БомБом", Animal.Type.CAT, Animal.Sex.M, 3, 101, 5, true),
                new Animal("БимБим", Animal.Type.BIRD, Animal.Sex.M, 200, 64, 36, true)
            ), Arrays.asList(
                new Animal("БомБом", Animal.Type.CAT, Animal.Sex.M, 3, 101, 5, true)
            ))
        );
    }

    @ParameterizedTest
    @MethodSource("dataForWeightGreaterThanHeightCount")
    @DisplayName("Сколько в списке животных, вес которых превышает рост")
    void weightGreaterThanHeightCount_validInputArrayList_successTest(List<Animal> animals, long res) {
        long result = AnimalTasks.weightGreaterThanHeightCount(animals);

        assertThat(result).isEqualTo(res);
    }
    private static Stream<Arguments> dataForWeightGreaterThanHeightCount() {
        return Stream.of(
            Arguments.of(Arrays.asList(
                new Animal("Бомбиноc", Animal.Type.CAT, Animal.Sex.M, 3, 10, 50, true),
                new Animal("Хатик", Animal.Type.DOG, Animal.Sex.M, 200, 64, 41, true),
                new Animal("БомБом", Animal.Type.CAT, Animal.Sex.M, 3, 101, 5, true),
                new Animal("БимБим", Animal.Type.BIRD, Animal.Sex.M, 200, 64, 36, true)
            ), 1)
        );
    }

    @ParameterizedTest
    @MethodSource("dataForNamesWithMoreThanTwoWords")
    @DisplayName("Список животных, имена которых состоят из более чем двух слов")
    void namesWithMoreThanTwoWords_validInputArrayList_successTest(List<Animal> animals, List<Animal> res) {
        List<Animal> result = AnimalTasks.namesWithMoreThanTwoWords(animals);

        assertThat(result).isEqualTo(res);
    }
    private static Stream<Arguments> dataForNamesWithMoreThanTwoWords() {
        return Stream.of(
            Arguments.of(Arrays.asList(
                new Animal("Бомбиноc", Animal.Type.CAT, Animal.Sex.M, 3, 10, 50, true),
                new Animal("Хатик", Animal.Type.DOG, Animal.Sex.M, 200, 64, 41, true),
                new Animal("БомБом биби", Animal.Type.CAT, Animal.Sex.M, 3, 101, 5, true),
                new Animal("БимБим", Animal.Type.BIRD, Animal.Sex.M, 200, 64, 36, true)
            ), Arrays.asList())
        );
    }

    @ParameterizedTest
    @MethodSource("dataForTallDog")
    @DisplayName("Есть ли в списке собака ростом более k см")
    void tallDog_validInputArrayList_successTest(List<Animal> animals, int dogHeight, boolean res) {
        boolean result = AnimalTasks.tallDog(animals, dogHeight);

        assertThat(result).isEqualTo(res);
    }
    private static Stream<Arguments> dataForTallDog() {
        return Stream.of(
            Arguments.of(Arrays.asList(
                new Animal("Бомбиноc", Animal.Type.CAT, Animal.Sex.M, 3, 10, 50, true),
                new Animal("Хатик", Animal.Type.DOG, Animal.Sex.M, 200, 64, 41, true),
                new Animal("БомБом биби", Animal.Type.CAT, Animal.Sex.M, 3, 101, 5, true),
                new Animal("БимБим", Animal.Type.BIRD, Animal.Sex.M, 200, 64, 36, true)
            ), 40, true)
        );
    }

    @ParameterizedTest
    @MethodSource("dataForTotalWeightByType")
    @DisplayName("Найти суммарный вес животных каждого вида")
    void totalWeightByType_validInputArrayList_successTest(List<Animal> animals, int minAge, int maxAge, Map<Animal.Type, Integer> res) {
        Map<Animal.Type, Integer> result = AnimalTasks.totalWeightByType(animals, minAge, maxAge);

        assertThat(result).isEqualTo(res);
    }
    private static Stream<Arguments> dataForTotalWeightByType() {
        return Stream.of(
            Arguments.of(Arrays.asList(
                new Animal("Бомбиноc", Animal.Type.CAT, Animal.Sex.M, 3, 10, 50, true),
                new Animal("Хатик", Animal.Type.DOG, Animal.Sex.M, 200, 64, 41, true),
                new Animal("БомБом биби", Animal.Type.CAT, Animal.Sex.M, 3, 101, 5, true),
                new Animal("БимБим", Animal.Type.BIRD, Animal.Sex.M, 200, 64, 36, true)
            ), 1, 50, Map.of(
                Animal.Type.CAT, 55
            ))
        );
    }

    @ParameterizedTest
    @MethodSource("dataForSortedByTypeSexName")
    @DisplayName("Список животных, отсортированный по виду, затем по полу, затем по имени")
    void sortedByTypeSexName_validInputArrayList_successTest(List<Animal> animals, List<Animal> res) {
        List<Animal> result = AnimalTasks.sortedByTypeSexName(animals);

        assertThat(result).isEqualTo(res);
    }
    private static Stream<Arguments> dataForSortedByTypeSexName() {
        return Stream.of(
            Arguments.of(Arrays.asList(
                new Animal("Бомбиноc", Animal.Type.CAT, Animal.Sex.M, 3, 10, 50, true),
                new Animal("Хатик", Animal.Type.DOG, Animal.Sex.M, 200, 64, 41, true),
                new Animal("БомБом биби", Animal.Type.CAT, Animal.Sex.M, 3, 101, 5, true),
                new Animal("БимБим", Animal.Type.BIRD, Animal.Sex.M, 200, 64, 36, true)
            ), Arrays.asList(
                new Animal("БомБом биби", Animal.Type.CAT, Animal.Sex.M, 3, 101, 5, true),
                new Animal("Бомбиноc", Animal.Type.CAT, Animal.Sex.M, 3, 10, 50, true),
                new Animal("Хатик", Animal.Type.DOG, Animal.Sex.M, 200, 64, 41, true),
                new Animal("БимБим", Animal.Type.BIRD, Animal.Sex.M, 200, 64, 36, true)
            ))
        );
    }

    @ParameterizedTest
    @MethodSource("dataForSpidersBiteMoreThanDogs")
    @DisplayName("Правда ли, что пауки кусаются чаще, чем собаки")
    void spidersBiteMoreThanDogs_validInputArrayList_successTest(List<Animal> animals, boolean res) {
        boolean result = AnimalTasks.spidersBiteMoreThanDogs(animals);

        assertThat(result).isEqualTo(res);
    }
    private static Stream<Arguments> dataForSpidersBiteMoreThanDogs() {
        return Stream.of(
            Arguments.of(Arrays.asList(
                new Animal("Бомбиноc", Animal.Type.CAT, Animal.Sex.M, 3, 10, 50, true),
                new Animal("Хатик", Animal.Type.DOG, Animal.Sex.M, 200, 64, 41, true),
                new Animal("БомБом биби", Animal.Type.CAT, Animal.Sex.M, 3, 101, 5, true),
                new Animal("БимБим", Animal.Type.SPIDER, Animal.Sex.M, 200, 64, 36, true)
            ), true)
        );
    }

    @ParameterizedTest
    @MethodSource("dataForAllFish")
    @DisplayName("Найти самую тяжелую рыбку в 2-х или более списках")
    void allFish_validInputArrayList_successTest(List<Animal> animals, List<Animal> animals2, Optional<Animal> res) {
        Optional<Animal> result = AnimalTasks.allFish(animals, animals2);

        assertThat(result).isEqualTo(res);
    }
    private static Stream<Arguments> dataForAllFish() {
        return Stream.of(
            Arguments.of(Arrays.asList(
                new Animal("Бомбиноc", Animal.Type.FISH, Animal.Sex.M, 3, 10, 50, true),
                new Animal("Хатик", Animal.Type.DOG, Animal.Sex.M, 200, 64, 41, true),
                new Animal("БомБом биби", Animal.Type.CAT, Animal.Sex.M, 3, 101, 5, true),
                new Animal("БимБим", Animal.Type.SPIDER, Animal.Sex.M, 200, 64, 36, true)
            ), Arrays.asList(
                new Animal("Бомбиноc", Animal.Type.CAT, Animal.Sex.M, 3, 10, 50, true),
                new Animal("Хатик", Animal.Type.FISH, Animal.Sex.M, 200, 64, 41, true),
                new Animal("БомБом биби", Animal.Type.CAT, Animal.Sex.M, 3, 101, 5, true),
                new Animal("БимБим", Animal.Type.FISH, Animal.Sex.M, 200, 64, 36, true)
            ), Optional.of(new Animal("Бомбиноc", Animal.Type.FISH, Animal.Sex.M, 3, 10, 50, true)))
        );
    }

    @ParameterizedTest
    @MethodSource("dataForValidateAnimals")
    @DisplayName("Валидация животных")
    void animalsValidation_validInputArrayList_successTest(List<Animal> animals) {
        Map<String, String> errors = ValidationError.upgradeValidAnimals(animals);

        String firstError = errors.get("Хатико");
        assertEquals("Возраст не может быть отрицательным ", firstError);

        String secondError = errors.get("");
        assertEquals("Имя не может быть пустым ", secondError);

        String thirdError = errors.get("БомБом");
        assertNull(thirdError);

        String fourthError = errors.get("БимБим");
        assertEquals("Возраст не может быть отрицательным Рост не может быть отрицательным Вес не может быть отрицательным " +
            "Тип не может быть пустым значением Пол не может быть пустым значением ", fourthError);
    }
    private static Stream<Arguments> dataForValidateAnimals() {
        return Stream.of(
            Arguments.of( new ArrayList<>(List.of(
                new Animal("", Animal.Type.CAT, Animal.Sex.M, 3, 30, 5, true),
                new Animal("Хатико", Animal.Type.DOG, Animal.Sex.M, -200, 64, 41, true),
                new Animal("БомБом", Animal.Type.CAT, Animal.Sex.M, 3, 30, 5, true),
                new Animal("БимБим", null, null, -200, -64, -41, true)
            )))
        );
    }
}
