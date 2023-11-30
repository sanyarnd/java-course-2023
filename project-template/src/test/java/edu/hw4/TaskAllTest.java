package edu.hw4;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

class TaskAllTest {
    @Test
    void sortByHeightAsc() {
        List<Animal> animals = List.of(
            new Animal("Cat1", Animal.Type.CAT, Animal.Sex.M, 5, 30, 5, false),
            new Animal("Dog1", Animal.Type.DOG, Animal.Sex.F, 8, 60, 25, true),
            new Animal("Bird1", Animal.Type.BIRD, Animal.Sex.M, 2, 10, 0, false)
        );

        List<Animal> result = TaskAll.sortByHeightAsc(animals);

        assertEquals("Bird1", result.get(0).name());
        assertEquals("Cat1", result.get(1).name());
        assertEquals("Dog1", result.get(2).name());
    }

    @Test
    void sortByWeightDescTopK() {
        List<Animal> animals = List.of(
            new Animal("Cat1", Animal.Type.CAT, Animal.Sex.M, 5, 30, 5, false),
            new Animal("Dog1", Animal.Type.DOG, Animal.Sex.F, 8, 60, 25, true),
            new Animal("Bird1", Animal.Type.BIRD, Animal.Sex.M, 2, 10, 0, false)
        );

        List<Animal> result = TaskAll.sortByWeightDescTopK(animals, 2);

        assertEquals("Dog1", result.get(0).name());
        assertEquals("Cat1", result.get(1).name());
    }

    @Test
    void countAnimalsByType() {
        List<Animal> animals = List.of(
            new Animal("Cat1", Animal.Type.CAT, Animal.Sex.M, 5, 30, 5, false),
            new Animal("Dog1", Animal.Type.DOG, Animal.Sex.F, 8, 60, 25, true),
            new Animal("Bird1", Animal.Type.BIRD, Animal.Sex.M, 2, 10, 0, false),
            new Animal("Dog2", Animal.Type.DOG, Animal.Sex.M, 4, 40, 15, true)
        );

        Map<Animal.Type, Integer> result = TaskAll.countAnimalsByType(animals);

        assertEquals(1, result.get(Animal.Type.CAT));
        assertEquals(2, result.get(Animal.Type.DOG));
        assertEquals(1, result.get(Animal.Type.BIRD));
    }

    @Test
    void selectLongestNameAnimal() {
        List<Animal> animals = List.of(
            new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 5, 30, 5, false),
            new Animal("DogWithLongName", Animal.Type.DOG, Animal.Sex.F, 8, 60, 25, true),
            new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 2, 10, 0, false)
        );

        Animal result = TaskAll.selectLongestNameAnimal(animals);

        assertEquals("DogWithLongName", result.name());
    }

    @Test
    void getDominantSex() {
        List<Animal> animals = List.of(
            new Animal("Cat1", Animal.Type.CAT, Animal.Sex.M, 5, 30, 5, false),
            new Animal("Dog1", Animal.Type.DOG, Animal.Sex.F, 8, 60, 25, true),
            new Animal("Bird1", Animal.Type.BIRD, Animal.Sex.M, 2, 10, 0, false),
            new Animal("Dog2", Animal.Type.DOG, Animal.Sex.M, 4, 40, 15, true)
        );

        Animal.Sex result = TaskAll.getDominantSex(animals);

        assertEquals(Animal.Sex.M, result);
    }

    @Test
    void findEachTypeHeaviestAnimal() {
        List<Animal> animals = List.of(
            new Animal("Cat1", Animal.Type.CAT, Animal.Sex.M, 5, 30, 5, false),
            new Animal("Dog1", Animal.Type.DOG, Animal.Sex.F, 8, 60, 25, true),
            new Animal("Bird1", Animal.Type.BIRD, Animal.Sex.M, 2, 10, 0, false),
            new Animal("Dog2", Animal.Type.DOG, Animal.Sex.M, 4, 40, 15, true)
        );

        Map<Animal.Type, Optional<Animal>> result = TaskAll.findEachTypeHeaviestAnimal(animals);

        assertEquals("Cat1", result.get(Animal.Type.CAT).orElse(null).name());
        assertEquals("Dog1", result.get(Animal.Type.DOG).orElse(null).name());
        assertEquals("Bird1", result.get(Animal.Type.BIRD).orElse(null).name());
    }

    @Test
    void findKthOldestAnimal() {
        var trueAnimal = new Animal("Dog2", Animal.Type.DOG, Animal.Sex.M, 4, 4, 15, true);
        List<Animal> animals = List.of(
            new Animal("Dog1", Animal.Type.DOG, Animal.Sex.F, 54, 60, 25, true),
            new Animal("Cat1", Animal.Type.CAT, Animal.Sex.M, 1, 30, 30, false),
            new Animal("Bird1", Animal.Type.BIRD, Animal.Sex.M, 2, 10, 11, false),
            trueAnimal
        );

        Animal result = TaskAll.findKthOldestAnimal(animals, 2);

        assertEquals(trueAnimal, result);
    }

    @Test
    void findHeaviestAnimalBelowK() {
        var trueAnimal = new Animal("Dog2", Animal.Type.DOG, Animal.Sex.M, 4, 4, 15, true);
        List<Animal> animals = List.of(
            new Animal("Dog1", Animal.Type.DOG, Animal.Sex.F, 5, 60, 25, true),
            new Animal("Cat1", Animal.Type.CAT, Animal.Sex.M, 5, 30, 30, false),
            new Animal("Bird1", Animal.Type.BIRD, Animal.Sex.M, 2, 10, 11, false),
            trueAnimal
        );

        Optional<Animal> result = TaskAll.findHeaviestAnimalBelowK(animals, 20);

        assertTrue(result.isPresent());
        assertEquals(trueAnimal, result.get());
    }

    @Test
    void getTotalPawsCount() {
        List<Animal> animals = List.of(
            new Animal("Dog1", Animal.Type.DOG, Animal.Sex.F, 5, 60, 25, true),
            new Animal("Cat1", Animal.Type.CAT, Animal.Sex.M, 5, 30, 30, false),
            new Animal("Bird1", Animal.Type.BIRD, Animal.Sex.M, 2, 10, 11, false),
            new Animal("Dog2", Animal.Type.DOG, Animal.Sex.M, 4, 4, 15, true)
        );

        int result = TaskAll.getTotalPawsCount(animals);

        assertEquals(14, result);
    }

    @Test
    void findAnimalsDiffAgeAndPaws() {
        List<Animal> animals = List.of(
            new Animal("Dog1", Animal.Type.DOG, Animal.Sex.F, 5, 60, 25, true),
            new Animal("Cat1", Animal.Type.CAT, Animal.Sex.M, 5, 311, 5, false),
            new Animal("Dog2", Animal.Type.DOG, Animal.Sex.M, 4, 40, 15, true)
        );

        List<Animal> result = TaskAll.findAnimalsDiffAgeAndPaws(animals);

        assertEquals(2, result.size());
    }

    @Test
    void findCanBiteAndAboveAnimals() {
        var trueAnimal = new Animal("Bird1", Animal.Type.BIRD, Animal.Sex.M, 2, 120, 0, true);
        List<Animal> animals = List.of(
            new Animal("Dog1", Animal.Type.DOG, Animal.Sex.F, 5, 60, 25, true),
            new Animal("Cat1", Animal.Type.CAT, Animal.Sex.M, 5, 311, 5, false),
            new Animal("Dog2", Animal.Type.DOG, Animal.Sex.M, 4, 40, 15, true),
            trueAnimal
        );

        List<Animal> result = TaskAll.findCanBiteAndAboveAnimals(animals);

        assertEquals(1, result.size());
        assertTrue(result.contains(trueAnimal));
    }

    @Test
    void getWeightGreaterHeightCount() {
        List<Animal> animals = List.of(
            new Animal("Dog1", Animal.Type.DOG, Animal.Sex.F, 5, 60, 25, true),
            new Animal("Cat1", Animal.Type.CAT, Animal.Sex.M, 5, 30, 30, false),
            new Animal("Bird1", Animal.Type.BIRD, Animal.Sex.M, 2, 10, 11, false),
            new Animal("Dog2", Animal.Type.DOG, Animal.Sex.M, 4, 4, 15, true)
        );

        int result = TaskAll.getWeightGreaterHeightCount(animals);

        assertEquals(2, result);
    }

    @Test
    void getComposeNameAnimals() {
        var trueAnimal = new Animal("Cat cat cat", Animal.Type.CAT, Animal.Sex.M, 5, 30, 5, false);
        List<Animal> animals = List.of(
            new Animal("Dog dog", Animal.Type.DOG, Animal.Sex.F, 5, 60, 25, true),
            new Animal("Bird1", Animal.Type.BIRD, Animal.Sex.M, 2, 10, 0, false),
            new Animal("Dog2", Animal.Type.DOG, Animal.Sex.M, 4, 40, 15, true),
            trueAnimal
        );

        List<Animal> result = TaskAll.getComposeNameAnimals(animals);

        assertEquals(1, result.size());
        assertTrue(result.contains(trueAnimal));
    }

    @Test
    void hasDogAboveHeight() {
        List<Animal> animals = List.of(
            new Animal("Dog1", Animal.Type.DOG, Animal.Sex.F, 5, 60, 25, true),
            new Animal("Cat1", Animal.Type.CAT, Animal.Sex.M, 5, 30, 5, false),
            new Animal("Bird1", Animal.Type.BIRD, Animal.Sex.M, 2, 10, 0, false),
            new Animal("Dog2", Animal.Type.DOG, Animal.Sex.M, 4, 40, 15, true)
        );

        assertTrue(TaskAll.hasDogAboveHeight(animals, 50));
        assertFalse(TaskAll.hasDogAboveHeight(animals, 60));
    }

    @Test
    void totalWeightByTypeInAgeRange() {
        List<Animal> animals = List.of(
            new Animal("Dog1", Animal.Type.DOG, Animal.Sex.F, 5, 60, 25, true),
            new Animal("Cat1", Animal.Type.CAT, Animal.Sex.M, 5, 30, 5, false),
            new Animal("Bird1", Animal.Type.BIRD, Animal.Sex.M, 2, 10, 0, false),
            new Animal("Dog2", Animal.Type.DOG, Animal.Sex.M, 4, 40, 15, true)
        );

        Map<Animal.Type, Integer> result = TaskAll.totalWeightByTypeInAgeRange(animals, 3, 5);

        assertEquals(5, result.get(Animal.Type.CAT));
        assertEquals(40, result.get(Animal.Type.DOG));
    }

    @Test
    void sortAnimalsByTypeSexName() {
        List<Animal> animals = List.of(
            new Animal("Dog1", Animal.Type.DOG, Animal.Sex.F, 8, 60, 25, true),
            new Animal("Cat1", Animal.Type.CAT, Animal.Sex.M, 5, 30, 5, false),
            new Animal("Bird1", Animal.Type.BIRD, Animal.Sex.M, 2, 10, 0, false),
            new Animal("Dog2", Animal.Type.DOG, Animal.Sex.M, 4, 40, 15, true)
        );

        List<Animal> result = TaskAll.sortAnimalsByTypeSexName(animals);

        assertEquals("Cat1", result.get(0).name());
        assertEquals("Dog2", result.get(1).name());
        assertEquals("Dog1", result.get(2).name());
        assertEquals("Bird1", result.get(3).name());
    }

    @Test
    void isSpidersBitesMoreDogs() {
        List<Animal> animals = List.of(
            new Animal("Spider1", Animal.Type.SPIDER, Animal.Sex.F, 1, 5, 0, true),
            new Animal("Dog1", Animal.Type.DOG, Animal.Sex.M, 8, 60, 25, false)
        );

        assertTrue(TaskAll.isSpidersBitesMoreDogs(animals));

        animals = List.of(
            new Animal("Spider1", Animal.Type.SPIDER, Animal.Sex.F, 1, 5, 0, true),
            new Animal("Dog1", Animal.Type.DOG, Animal.Sex.M, 8, 60, 25, true),
            new Animal("Dog2", Animal.Type.DOG, Animal.Sex.M, 4, 40, 15, true)
        );

        assertFalse(TaskAll.isSpidersBitesMoreDogs(animals));

        animals = List.of(
            new Animal("Dog1", Animal.Type.DOG, Animal.Sex.M, 8, 60, 25, false)
        );

        assertFalse(TaskAll.isSpidersBitesMoreDogs(animals));
    }

    @Test
    void findHeaviestFishInLists() {
        List<Animal> list1 = List.of(
            new Animal("Fish1", Animal.Type.FISH, Animal.Sex.M, 2, 15, 2, false),
            new Animal("Dog", Animal.Type.DOG, Animal.Sex.M, 8, 60, 25, false)
        );

        List<Animal> list2 = List.of(
            new Animal("Fish2", Animal.Type.FISH, Animal.Sex.F, 3, 20, 3, false),
            new Animal("Cat", Animal.Type.CAT, Animal.Sex.F, 5, 30, 5, false)
        );

        Animal result = TaskAll.findHeaviestFishInLists(List.of(list1, list2));
        assertEquals("Fish2", result.name());
    }

    @Test
    void validateAnimals() {
        getReadableErrors();
    }

    @Test
    void getReadableErrors() {
        List<Animal> animals = List.of(
            new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, -59, 30, 5, false),
            new Animal("Dog229", Animal.Type.DOG, Animal.Sex.F, 8, 1, 25, true)
        );

        Map<String, String> result = TaskAll.getReadableErrors(animals);

        assertEquals(2, result.size());
        assertTrue(result.containsKey("Cat"));
        assertTrue(result.containsKey("Dog229"));

        assertEquals(
            "NEGATIVE_AGE",
            result.get("Cat")
        );
        assertEquals(
            "INVALID_NAME",
            result.get("Dog229")
        );
    }
}
