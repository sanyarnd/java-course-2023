package edu.hw4;

import java.util.List;

public class Task12 {
    private Task12() {
    }

    public int howManyAnimalsAreInTheListWhoseWeightExceedsHeight(List<Animal> animals) {
        return (int) animals.stream()
            .filter(animal -> animal.weight() > animal.height())
            .count();
    }
}
