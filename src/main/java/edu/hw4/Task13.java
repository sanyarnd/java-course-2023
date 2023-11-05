package edu.hw4;

import java.util.List;

public class Task13 {
    private Task13() {
    }

    public List<Animal> listOfAnimalsWhoseNamesConsistOfMoreThanTwoWords(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.name().split(" ").length >= 2)
            .toList();
    }
}
