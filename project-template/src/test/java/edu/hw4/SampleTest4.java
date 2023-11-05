package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SampleTest4 {
    @ParameterizedTest
    @MethodSource("data_for_validateAnimals")
    @DisplayName("Валидация животных")
    void animalsValidation_validInputNumber_successTest(List<Animal> animals) {
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
    private static Stream<Arguments> data_for_validateAnimals() {
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
