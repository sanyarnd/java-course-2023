package edu.hw4;

import java.util.List;

public class Task11 {
    private Task11() {
    }

    private final static int TASK11_HEIGHT_CONST = 100;

    public List<Animal> listOfAnimalsThatCanBiteAndWhoseHeightExceeds(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.bites() && animal.height() > TASK11_HEIGHT_CONST)
            .toList();
    }
}
