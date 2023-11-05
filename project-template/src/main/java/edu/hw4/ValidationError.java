package edu.hw4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ValidationError {
    private final String msg;

    public ValidationError(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    //task19
    public static Map<String, Set<ValidationError>> validAnimals(List<Animal> animals) {
        Map<String, Set<ValidationError>> errors = new HashMap<>();
        for (Animal animal : animals) {
            Set<ValidationError> animalErrors = new HashSet<>();
            if (animal.name() == null || animal.name().isEmpty()) {
                animalErrors.add(new ValidationError("Имя не может быть пустым "));
            }
            if (animal.age() <= 0) {
                animalErrors.add(new ValidationError("Возраст не может быть отрицательным "));
            }
            if (animal.height() <= 0) {
                animalErrors.add(new ValidationError("Рост не может быть отрицательным "));
            }
            if (animal.weight() <= 0) {
                animalErrors.add(new ValidationError("Вес не может быть отрицательным "));
            }
            if (animal.type() == null) {
                animalErrors.add(new ValidationError("Тип не может быть пустым значением "));
            }
            if (animal.sex() == null) {
                animalErrors.add(new ValidationError("Пол не может быть пустым значением "));
            }
            errors.put(animal.name(), animalErrors);
        }
        return errors;
    }

    //task20
    public static Map<String, String> upgradeValidAnimals(List<Animal> animals) {
        Map<String, String> errors = new HashMap<>();
        for (Animal animal : animals) {
            StringBuilder animalErrors = new StringBuilder();
            if (animal.name() == null || animal.name().isEmpty()) {
                animalErrors.append("Имя не может быть пустым ");
            }
            if (animal.age() < 0) {
                animalErrors.append("Возраст не может быть отрицательным ");
            }
            if (animal.height() < 0) {
                animalErrors.append("Рост не может быть отрицательным ");
            }
            if (animal.weight() < 0) {
                animalErrors.append("Вес не может быть отрицательным ");
            }
            if (animal.type() == null) {
                animalErrors.append("Тип не может быть пустым значением ");
            }
            if (animal.sex() == null) {
                animalErrors.append("Пол не может быть пустым значением ");
            }
            if (animalErrors.length() > 0) {
                errors.put(animal.name(), animalErrors.toString());
            }
        }
        return errors;
    }

//    public enum Errors {
//        EMPTY_NAME,
//        INVALID_AGE,
//        INVALID_HEIGHT,
//        INVALID_WEIGHT,
//        INVALID_TYPE,
//        INVALID_SEX,
//    }
}
