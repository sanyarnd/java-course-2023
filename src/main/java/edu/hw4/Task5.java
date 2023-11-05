package edu.hw4;

import java.util.List;

public class Task5 {
    private Task5() {
    }

    public Animal.Sex how(List<Animal> animals) {
        int maleAmount = (int) animals.stream().filter(animal -> animal.sex() == Animal.Sex.M).count();
        if (maleAmount > animals.size() / 2) {
            return Animal.Sex.M;
        }
        return Animal.Sex.F;
    }
}
