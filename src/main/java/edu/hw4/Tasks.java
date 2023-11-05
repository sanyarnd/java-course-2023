package edu.hw4;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import static edu.hw4.Animal.Sex;
import java.util.Collection;

public class Tasks {
    // Задача 1
    public static List<Animal> sortByHeight(List<Animal> animals){
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::height))
            .toList();
    }

    // Задача 2
    public static List<Animal> sortByWeight(List<Animal> animals, int k){
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::weight).reversed())
            .limit(k)
            .toList();
    }

    // Задача 3
    public static Map<Animal.Type, Integer> differentSpeciesAnimalsCount(List<Animal> animals){
        return animals.stream()
            .collect(Collectors.groupingBy(
                Animal::type,
                Collectors.summingInt(e -> 1)
            ));
    }

    // Задача 4
    public static Animal longestName(List<Animal> animals){
        return animals.stream()
            .max(Comparator.comparingInt(animal -> animal.name().length()))
            .orElse(null);
    }

    // Задача 5
    public static Sex whichGenderMore(List<Animal> animals) {
        int male = (int) animals.stream()
            .filter(animal -> animal.sex() == Sex.M)
            .count();
        int female = animals.size() - male;

        return female > male ? Sex.F : Sex.M;
    }

    // Задача 6
    public static Map<Animal.Type, Animal> heaviestAnimals(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.toMap(
                Animal::type,
                Function.identity(),
                BinaryOperator.maxBy(Comparator.comparingInt(Animal::weight))
            ));
    }

    // Задача 7
    public static Animal oldestAnimal(List<Animal> animals, int k) {
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::age).reversed())
            .skip(k - 1)
            .findFirst()
            .orElse(null);
    }

    // Задача 8
    public static Optional<Animal> heaviestBelowK(List<Animal> animals, int k) {
        return animals.stream()
            .filter(animal -> animal.height() < k)
            .max(Comparator.comparingInt(Animal::weight));
    }

    // Задача 9
    public static Integer sumPaws(List<Animal> animals) {
        return animals.stream()
            .mapToInt(Animal::paws)
            .sum();
    }

    // Задача 10
    public static List<Animal> ageNotEqualPawsCount(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.paws() != animal.age())
            .toList();
    }

    // Задача 11
    public static List<Animal> AnimalsCanBiteMoreThanHundred(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.bites() && animal.height() > 100)
            .toList();
    }

    // Задача 12
    public static Integer weightGreaterHeightCount(List<Animal> animals) {
        return (int) animals.stream()
            .filter(animal -> animal.weight() > animal.height())
            .count();
    }

    // Задача 13
    public List<Animal> nameMoreThanTwoWords(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.name().split(" ").length > 1)
            .toList();
    }

    // Задача 14
    public boolean hasDogMoreThanK(List<Animal> animals, int k) {
        return animals.stream()
            .anyMatch(animal -> animal.type() == Animal.Type.DOG && animal.height() > k);
    }

    // Задача 15
    public Map<Animal.Type, Integer> sumWeightEachType(List<Animal> animals, int k, int l) {
        return animals.stream()
            .filter(animal -> k <= animal.age() && animal.age() <= l)
            .collect(Collectors.groupingBy(
                Animal::type,
                Collectors.summingInt(Animal::weight)
            ));
    }

    // Задача 16
    public List<Animal> sortByTypeSexName(List<Animal> animals) {
        Comparator<Animal> animalComparator = Comparator
            .comparing(Animal::type)
            .thenComparing(Animal::sex)
            .thenComparing(Animal::name);

        return animals.stream()
            .sorted(animalComparator)
            .toList();
    }

    // Задача 17
    public boolean isSpidersBitesMoreThanDogs(List<Animal> animals) {
        int countDogs = (int) animals.stream().filter(animal -> animal.type() == Animal.Type.DOG).count();
        int countSpiders = (int) animals.stream().filter(animal -> animal.type() == Animal.Type.SPIDER).count();

        int countByteDogs = (int) animals.stream()
            .filter(animal -> animal.type() == Animal.Type.DOG && animal.bites())
            .count();

        int countByteSpiders = (int) animals.stream()
            .filter(animal -> animal.type() == Animal.Type.SPIDER && animal.bites())
            .count();

        if (countDogs * countSpiders == 0) {
            return false;
        }
        return (double) countByteSpiders / countSpiders > (double) countByteDogs / countDogs;
    }

    // Задача 18
    public Animal heaviestFish(List<List<Animal>> listAnimals) {
        return listAnimals.stream()
            .flatMap(Collection::stream)
            .filter(animal -> animal.type() == Animal.Type.FISH)
            .max(Comparator.comparingInt(Animal::weight))
            .orElse(null);
    }

    // Задача 19
    public static Map<String, Set<ValidationError>> animalValidation(List<Animal> animals) {
        Map<String, Set<ValidationError>> res = new HashMap<>();
        for (Animal a : animals) {
            Set<ValidationError> curSet = new HashSet<>();

            if(a.name()==null || a.name()==""){
                curSet.add(new ValidationError("name", "must not be null or empty"));
            }
            if (a.type() == null) {
                curSet.add(new ValidationError("type", "must not be null"));
            }
            if (a.age() < 0) {
                curSet.add(new ValidationError("age", "must be greater than zero"));
            }
            if (a.height() <= 0) {
                curSet.add(new ValidationError("height", "must be greater than zero"));
            }

            if (a.name() != null && !curSet.isEmpty()) {
                res.put(a.name(), curSet);
            }
        }

        return res;
    }

    // Задача 20
    public static Map<String, String> task20(List<Animal> animals) {
        Map<String, Set<ValidationError>> res = animalValidation(animals);
        return res.entrySet().stream()
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                entry -> entry.getValue().stream().map(ValidationError::getField).collect(Collectors.joining(", "))
            ));
    }
}
