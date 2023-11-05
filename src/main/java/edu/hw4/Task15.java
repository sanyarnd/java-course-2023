package edu.hw4;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task15 {
    private Task15() {
    }

    public Map<Animal.Type, Integer> totalWeightOfAnimalsOfEachSpecies(List<Animal> animals, int k, int l) {
        return animals.stream()
            .filter(animal -> animal.age() <= l && animal.age() >= k)
            .collect(Collectors.groupingBy(
                Animal::type,
                Collectors.summingInt(Animal::weight)
            ));
    }
}
