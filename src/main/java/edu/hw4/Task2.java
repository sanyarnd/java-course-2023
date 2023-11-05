package edu.hw4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Task2 {
    private Task2() {
    }

    public static List<Animal> toSortAnimalByWeightReverse(List<Animal> animals, int k) {
        List<Animal> newAnimals = new ArrayList<>();
        animals.stream().sorted(Comparator.comparingInt(Animal::weight).reversed()).limit(k).forEach(newAnimals::add);
        return newAnimals;
    }

}
