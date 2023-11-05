package edu.hw4;

import java.util.List;

public class Task17 {
    private Task17() {
    }

    public boolean whoBitesMoreOften(List<Animal> animals) {
        int spiders = (int) animals.stream()
            .filter(animal -> animal.type() == Animal.Type.SPIDER)
            .count();
        int bitingSpider = (int) animals.stream()
            .filter(animal -> animal.type() == Animal.Type.SPIDER && animal.bites())
            .count();

        int dogs = (int) animals.stream()
            .filter(animal -> animal.type() == Animal.Type.DOG)
            .count();
        int bitingDogs = (int) animals.stream()
            .filter(animal -> animal.type() == Animal.Type.DOG && animal.bites())
            .count();

        if (spiders == 0 || dogs == 0) {
            return false;
        } else {
            return (double) bitingSpider / spiders > (double) bitingDogs / dogs;
        }
    }
}
