package edu.hw4;

import java.util.Comparator;
import java.util.List;

public class Task7 {
    private Task7() {
    }

    public Animal theOldestAnimalUnderTheNumberK(List<Animal> animals, int k) {
        return animals.stream()
            .sorted(new TheOldestAnimalUnderTheNumberKComparator())
            .skip(k)
            .findFirst()
            .orElse(null);
    }

    static class TheOldestAnimalUnderTheNumberKComparator implements Comparator<Animal> {

        @Override
        public int compare(Animal animal1, Animal animal2) {

            if (animal1.weight() != animal2.weight()) {
                return Integer.compare(animal1.weight(), animal2.weight());
            }

            if (animal1.age() != animal2.age()) {
                return Integer.compare(animal1.age(), animal2.age());
            }

            return animal2.name().compareTo(animal1.name());
        }
    }
}
