package edu.hw4;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static edu.hw4.Animal.Sex;
import static edu.hw4.ValidationError.ErrorType;
import static edu.hw4.Animal.Type;

public final class TaskAll {
    // Subtask 1
    public static List<Animal> sortByHeightAsc(List<Animal> animals) {
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::height))
            .toList();
    }

    // Subtask 2
    public static List<Animal> sortByWeightDescTopK(List<Animal> animals, long k) {
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::weight).reversed())
            .limit(k)
            .toList();
    }

    // Subtask 3
    public static Map<Type, Integer> countAnimalsByType(List<Animal> animals) {
        return animals.stream()
            .collect(
                Collectors.groupingBy(
                    Animal::type,
                    Collectors.summingInt(animal -> 1)
                )
            );
    }

    // Subtask 4
    public static Animal selectLongestNameAnimal(List<Animal> animals) {
        return animals.stream()
            .max(Comparator.comparingInt(animal -> animal.name().length()))
            .orElse(null);
    }

    // Subtask 5
    public static Sex getDominantSex(List<Animal> animals) {
        Map<Sex, Long> sexCount = animals.stream()
            .collect(Collectors.groupingBy(Animal::sex, Collectors.counting()));

        return sexCount.entrySet().stream()
            .max(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey)
            .orElse(null);
    }

    // Subtask 6
    public static Map<Type, Optional<Animal>> findEachTypeHeaviestAnimal(List<Animal> animals) {
        return animals.stream()
            .collect(
                Collectors.groupingBy(
                    Animal::type,
                    Collectors.maxBy(Comparator.comparingInt(Animal::weight))
                ));
    }

    // Subtask 7
    public static Animal findKthOldestAnimal(List<Animal> animals, int k) {
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::age).reversed())
            .skip(k - 1)
            .findFirst()
            .orElse(null);
    }

    // Subtask 8
    public static Optional<Animal> findHeaviestAnimalBelowK(List<Animal> animals, int k) {
        return animals.stream()
            .filter(animal -> animal.height() < k)
            .max(Comparator.comparingInt(Animal::weight));
    }

    // Subtask 9
    public static Integer getTotalPawsCount(List<Animal> animals) {
        return animals.stream()
            .mapToInt(Animal::paws)
            .sum();
    }

    // Subtask 10
    public static List<Animal> findAnimalsDiffAgeAndPaws(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.age() != animal.paws())
            .toList();
    }

    // Subtask 11
    public static List<Animal> findCanBiteAndAboveAnimals(List<Animal> animals) {
        int minHeight = 101;

        return animals.stream()
            .filter(animal -> animal.bites() && animal.height() >= minHeight)
            .toList();
    }

    // Subtask 12
    public static int getWeightGreaterHeightCount(List<Animal> animals) {
        return (int) animals.stream()
            .filter(animal -> animal.weight() > animal.height())
            .count();
    }

    // Subtask 13
    public static List<Animal> getComposeNameAnimals(List<Animal> animals) {
        int minNameWords = 3;

        return animals.stream()
            .filter(animal -> animal.name().split(" ").length >= minNameWords)
            .toList();
    }

    // Subtask 14
    public static boolean hasDogAboveHeight(List<Animal> animals, int k) {
        return animals.stream()
            .anyMatch(animal -> animal.type() == Animal.Type.DOG && animal.height() > k);
    }

    // Subtask 15
    public static Map<Animal.Type, Integer> totalWeightByTypeInAgeRange(List<Animal> animals, int k, int l) {
        return animals.stream()
            .filter(animal -> animal.age() >= k && animal.age() <= l)
            .collect(
                Collectors.groupingBy(
                    Animal::type,
                    Collectors.summingInt(Animal::weight)
                ));
    }

    // Subtask 16
    public static List<Animal> sortAnimalsByTypeSexName(List<Animal> animals) {
        return animals.stream()
            .sorted(Comparator
                .comparing(Animal::type)
                .thenComparing(Animal::sex)
                .thenComparing(Animal::name))
            .toList();
    }

    // Subtask 17
    public static boolean isSpidersBitesMoreDogs(List<Animal> animals) {
        long bitingSpiders = animals.stream()
            .filter(animal -> animal.type() == Type.SPIDER && animal.bites())
            .count();

        long bitingDogs = animals.stream()
            .filter(animal -> animal.type() == Type.DOG && animal.bites())
            .count();

        return bitingSpiders > bitingDogs;
    }

    // Subtask 18
    public static Animal findHeaviestFishInLists(List<List<Animal>> animalLists) {
        return animalLists.stream()
            .flatMap(List::stream)
            .filter(animal -> animal.type() == Animal.Type.FISH)
            .max(Comparator.comparingInt(Animal::weight))
            .orElse(null);
    }

    // Subtask 19
    public static Map<String, Set<ValidationError>> validateAnimals(List<Animal> animals) {
        var errorsMap = new HashMap<String, Set<ValidationError>>();

        for (Animal animal : animals) {
            var errors = new HashSet<ValidationError>();

            if (animal.age() < 0) {
                errors.add(new ValidationError(ErrorType.NEGATIVE_AGE, "Age can`t be negative"));
            }

            if (animal.height() < 0) {
                errors.add(new ValidationError(ErrorType.NEGATIVE_HEIGHT, "Height can`t be negative"));
            }

            if (animal.weight() < 0) {
                errors.add(new ValidationError(ValidationError.ErrorType.NEGATIVE_WEIGHT, "Weight can`t be negative"));
            }

            if (animal.name() == null || !animal.name().matches("[A-Za-z]+")) {
                errors.add(new ValidationError(ValidationError.ErrorType.INVALID_NAME, "Invalid name format"));
            }

            if (!errors.isEmpty()) {
                errorsMap.put(animal.name(), errors);
            }
        }

        return errorsMap;
    }

    // Subtask 20
    public static Map<String, String> getReadableErrors(List<Animal> animals) {
        Map<String, Set<ValidationError>> errors = validateAnimals(animals);

        return errors.entrySet().stream()
            .collect(
                Collectors.toMap(
                    Map.Entry::getKey,
                    error -> error.getValue().stream()
                        .map(ValidationError::getTypeString)
                        .collect(Collectors.joining(", "))
                ));
    }
}
