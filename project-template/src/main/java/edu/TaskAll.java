package edu;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static edu.Animal.Sex;
import static edu.Animal.Type;

public final class TaskAll {
    // Subtask 1
    public static List<Animal> sortByHeightAsc(List<Animal> animals) {
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::height))
            .collect(Collectors.toList());
    }

    // Subtask 2
    public static List<Animal> sortByWeightDescTopK(List<Animal> animals, long k) {
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::weight).reversed())
            .limit(k)
            .collect(Collectors.toList());
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
    public static Map<Type, Animal> findEachTypeHeaviestAnimal(List<Animal> animals) {

//        return animals.stream()
//            .collect(Collectors.toMap(
//                Animal::type,
//                animal -> animal,
//                (animal1, animal2) -> (animal1.weight() >= animal2.weight()) ? animal1 : animal2
//            ));

        return animals.stream()
            .collect(
                Collectors.groupingBy(
                    Animal::type,
                    Collectors.reducing(null, (animal1, animal2) ->
                        (((Animal) animal1).weight() >= ((Animal) animal1).weight()) ? animal1 : animal2
                    )
                ));
    }
}
