package edu.hw4;

import java.util.Comparator;
import java.util.List;

public class Task16 {
    private Task16() {
    }

    public List<Animal> listOfAnimalsSortedBySpeciesThenByGenderThenByName(List<Animal> animals) {
        return animals.stream()
            .sorted(new ListOfAnimalsSortedBySpeciesThenByGenderThenByNameComparator())
            .toList();
    }

    static class ListOfAnimalsSortedBySpeciesThenByGenderThenByNameComparator implements Comparator<Animal> {

        @Override
        public int compare(Animal animal1, Animal animal2) {
            if (animal1.type().ordinal() != animal2.type().ordinal()) {
                return Integer.compare(animal1.type().ordinal(), animal2.type().ordinal());
            }

            if (animal1.sex().ordinal() != animal2.sex().ordinal()) {
                return Integer.compare(animal1.sex().ordinal(), animal2.sex().ordinal());
            }

            return animal1.name().compareTo(animal2.name());
        }
    }
}
