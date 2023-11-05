package edu.hw4;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class Task18 {
    private Task18() {
    }

    public Animal task18(List<List<Animal>> animalsSuperList) {
        return animalsSuperList.stream()
            .flatMap(Collection::stream)
            .filter(animal -> animal.type() == Animal.Type.FISH)
            .max(Comparator.comparingInt(Animal::weight))
            .orElse(null);
    }
}
