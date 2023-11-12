package edu.hw4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import static edu.hw4.ValidationError.upgradeValidAnimals;
import static edu.hw4.ValidationError.validAnimals;

public class AnimalTasks {
    //task1
    public static List<Animal> sortByHeight(List<Animal> animals){
        animals.sort(Comparator.comparingInt(Animal::height));

        return animals;
    }

    //task2
    public static List<Animal> sortByWeight(List<Animal> animals, int count){
        List<Animal> sort = animals.stream()
            .sorted(Comparator.comparingInt(Animal::weight).reversed())
            .limit(count)
            .toList();

        return sort;
    }

    //task3
    public static Map<Animal.Type, Long> countByType(List<Animal> animals){
        Map<Animal.Type, Long> count = animals.stream()
            .collect(Collectors.groupingBy(Animal::type, Collectors.counting()));

        return count;
    }

    //task4
    public static Optional<Animal> getLongestName(List<Animal> animals){
        Optional<Animal> longestName = animals.stream()
            .max(Comparator.comparingInt(animal -> animal.name().length()));

        return longestName;
    }

    //task5
    public static String numberOfAnimalsByGender(List<Animal> animals){
        long maleCount = animals.stream()
            .filter(animal -> animal.sex() == Animal.Sex.M)
            .count();
        long femaleCount = animals.size() - maleCount;
        if (maleCount > femaleCount) {
            return "Самцов больше";
        } else if (femaleCount > maleCount) {
            return "Самок больше";
        } else {
            return "Самцов и самок одинаковое количество";
        }
    }

    //task6
    public static Map<Animal.Type, Optional<Animal>> heaviestByType(List<Animal> animals){
        Map<Animal.Type, Optional<Animal>> heaviestByType = animals.stream()
            .collect(Collectors.groupingBy(Animal::type, Collectors.maxBy(Comparator.comparingInt(Animal::weight))));
        System.out.println("Самое тяжелое животное каждого вида:");

        return heaviestByType;
    }

    //task7
    public static Animal oldestAnimal(List<Animal> animals, int age){
        animals.sort(Comparator.comparingInt(Animal::age).reversed());
        Animal OldestAnimal = animals.get(age - 1);
        return OldestAnimal;
    }

    //task8
    public static Optional<Animal> heaviestAnimal(List<Animal> animals, int height){
        Optional<Animal> heaviest = animals.stream()
            .filter(animal -> animal.height() < height)
            .max(Comparator.comparingInt(Animal::weight));
        return heaviest;
    }

    //task9
    public static int sumOfPaws(List<Animal> animals){
        int sum = animals.stream()
            .mapToInt(Animal::paws)
            .sum();
        return sum;
    }

    //task10
    public static List<Animal> differentPaws(List<Animal> animals){
        List<Animal> different = animals.stream()
            .filter(animal -> animal.age() != animal.paws())
            .toList();

        return different;
    }

    //task11
    public static List<Animal> biteAndHighAnimals(List<Animal> animals) {
        List<Animal> biteAndHigh = animals.stream()
            .filter(animal -> animal.bites() && animal.height() > 100)
            .toList();

        return biteAndHigh;
    }

    //task12
    public static long weightGreaterThanHeightCount(List<Animal> animals) {
        long weight = animals.stream()
            .filter(animal -> animal.weight() > animal.height())
            .count();

       return weight;
    }

    //task13
    public static List<Animal> namesWithMoreThanTwoWords(List<Animal> animals) {
        List<Animal> names = animals.stream()
            .filter(animal -> animal.name().split(" ").length > 2)
            .toList();

        return names;
    }

    //task14
    public static boolean tallDog(List<Animal> animals, int dogHeight) {
        boolean dog = animals.stream()
            .filter(animal -> animal.type() == Animal.Type.DOG)
            .anyMatch(animal -> animal.height() > dogHeight);

        return dog;
    }

    //task15
    public static Map<Animal.Type, Integer> totalWeightByType(List<Animal> animals, int minAge, int maxAge) {
        Map<Animal.Type, Integer> totalWeight = animals.stream()
            .filter(animal -> animal.age() >= minAge && animal.age() <= maxAge)
            .collect(Collectors.groupingBy(Animal::type, Collectors.summingInt(Animal::weight)));

        return totalWeight;
    }

    //task16
    public static List<Animal> sortedByTypeSexName(List<Animal> animals) {
        List<Animal> sorted = animals.stream()
            .sorted(Comparator.comparing(Animal::type)
                .thenComparing(Animal::sex)
                .thenComparing(Animal::name))
            .toList();

        return sorted;
    }

    //task17
    public static boolean spidersBiteMoreThanDogs(List<Animal> animals) {
        boolean spidersAndDogs = animals.stream()
            .filter(animal -> animal.type() == Animal.Type.SPIDER || animal.type() == Animal.Type.DOG)
            .anyMatch(Animal::bites);

        return spidersAndDogs;
    }

    //task18
    public static Optional<Animal> allFish(List<Animal> animals, List<Animal> animals2) {
        List<Animal> allFish = new ArrayList<>();
        allFish.addAll(animals);
        allFish.addAll(animals2);

        Optional<Animal> heaviest = allFish.stream()
            .filter(animal -> animal.type() == Animal.Type.FISH)
            .max(Comparator.comparingInt(Animal::weight));

        return heaviest;
    }

    //task19
    public static void validation(List<Animal> animalsForValidate) {
        int order19 = 1;
        Map<String, Set<ValidationError>> validError = validAnimals(animalsForValidate);
        for (Map.Entry<String, Set<ValidationError>> entry : validError.entrySet()) {
            System.out.print(order19 + ") ");
            System.out.print(entry.getKey() + " - ");
            if (entry.getValue().size() > 0) {
                for (var i : entry.getValue()) {
                    System.out.print(i.getMsg() + " ");
                }
                System.out.println();
            }
            else {
                System.out.println("Все корректно");
            }
            order19++;
        }
    }

    //task20
    public static void upgradeValidation(List<Animal> animalsForValidate) {
        int order20 = 1;
        Map<String, String> validError2 = upgradeValidAnimals(animalsForValidate);
        for (Map.Entry<String, String> entry : validError2.entrySet()) {
            System.out.print(order20 + ") ");
            System.out.println(entry.getKey() + " - " + entry.getValue());
            order20++;
        }
    }
}
