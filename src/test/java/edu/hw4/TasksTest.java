package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TasksTest {
    Tasks tasks = new Tasks();

    @Test
    public final void test1() {
        Animal animal1 = new Animal(
            "Kaolina",
            Animal.Type.CAT,
            Animal.Sex.F,
            Integer.MIN_VALUE,
            1,
            Integer.MIN_VALUE,
            false
        );
        Animal animal2 = new Animal(
            "Branda",
            Animal.Type.CAT,
            Animal.Sex.F,
            Integer.MIN_VALUE,
            2,
            Integer.MIN_VALUE,
            false
        );
        Animal animal3 = new Animal(
            "Ollie",
            Animal.Type.DOG,
            Animal.Sex.F,
            Integer.MIN_VALUE,
            3,
            Integer.MIN_VALUE,
            false
        );

        List<Animal> animals = List.of(animal2, animal1, animal3);

        List<Animal> actual = tasks.sortByHeight(animals);
        List<Animal> expected = List.of(animal1, animal2, animal3);

        assertEquals(expected, actual);
    }

    @Test
    public final void test2() {
        Animal animal1 = new Animal(
            "Stan",
            Animal.Type.DOG,
            Animal.Sex.M,
            1,
            3,
            50,
            false
        );
        Animal animal2 = new Animal(
            "Lorrie",
            Animal.Type.DOG,
            Animal.Sex.F,
            1,
            3,
            40,
            false
        );
        Animal animal3 = new Animal(
            "Josephina",
            Animal.Type.DOG,
            Animal.Sex.F,
            1,
            3,
            30,
            false
        );
        Animal animal4 = new Animal(
            "1",
            Animal.Type.DOG,
            Animal.Sex.F,
            1,
            3,
            20,
            false
        );

        List<Animal> animals = List.of(animal2, animal1, animal4, animal3);

        List<Animal> actual = tasks.sortByWeight(animals, 2);
        List<Animal> expected = List.of(animal1, animal2);

        assertEquals(expected, actual);

    }

    @Test
    public final void test3() {
        Animal animal1 = new Animal(
            "2",
            Animal.Type.CAT,
            Animal.Sex.F,
            1,
            3,
            50,
            false
        );
        Animal animal2 = new Animal(
            "3",
            Animal.Type.DOG,
            Animal.Sex.F,
            1,
            3,
            40,
            false
        );
        Animal animal3 = new Animal(
            "1",
            Animal.Type.DOG,
            Animal.Sex.F,
            1,
            3,
            30,
            false
        );
        Animal animal4 = new Animal(
            "1",
            Animal.Type.SPIDER,
            Animal.Sex.F,
            1,
            3,
            20,
            false
        );

        List<Animal> animals = List.of(animal2, animal1, animal4, animal3);

        Map<Animal.Type, Integer> expected = new HashMap<>();
        expected.put(Animal.Type.DOG, 2);
        expected.put(Animal.Type.SPIDER, 1);
        expected.put(Animal.Type.CAT, 1);

        Map<Animal.Type, Integer> actual = tasks.differentSpeciesAnimalsCount(animals);

        assertEquals(expected, actual);
    }

    @Test
    public final void test4() {
        Animal animal1 = new Animal(
            "123456",
            Animal.Type.CAT,
            Animal.Sex.F,
            Integer.MIN_VALUE,
            1,
            Integer.MIN_VALUE,
            false
        );
        Animal animal2 = new Animal(
            "123",
            Animal.Type.CAT,
            Animal.Sex.F,
            Integer.MIN_VALUE,
            2,
            Integer.MIN_VALUE,
            false
        );
        Animal animal3 = new Animal(
            "5",
            Animal.Type.DOG,
            Animal.Sex.F,
            Integer.MIN_VALUE,
            3,
            Integer.MIN_VALUE,
            false
        );

        List<Animal> animals = List.of(animal2, animal1, animal3);

        Animal actual = tasks.longestName(animals);

        assertEquals(animal1, actual);
    }

    @Test
    public final void test5() {
        Animal animal1 = new Animal(
            "2",
            Animal.Type.CAT,
            Animal.Sex.F,
            1,
            3,
            50,
            false
        );
        Animal animal2 = new Animal(
            "3",
            Animal.Type.DOG,
            Animal.Sex.F,
            1,
            3,
            40,
            false
        );
        Animal animal3 = new Animal(
            "1",
            Animal.Type.DOG,
            Animal.Sex.M,
            1,
            3,
            30,
            false
        );
        Animal animal4 = new Animal(
            "1",
            Animal.Type.SPIDER,
            Animal.Sex.F,
            1,
            3,
            20,
            false
        );

        List<Animal> animals = List.of(animal2, animal1, animal4, animal3);

        Animal.Sex actual = tasks.whichGenderMore(animals);

        assertEquals(Animal.Sex.F, actual);
    }

    @Test
    public final void test6() {
        Animal animal1 = new Animal(
            "2",
            Animal.Type.CAT,
            Animal.Sex.F,
            1,
            3,
            50,
            false
        );
        Animal animal2 = new Animal(
            "3",
            Animal.Type.DOG,
            Animal.Sex.F,
            1,
            3,
            40,
            false
        );
        Animal animal3 = new Animal(
            "1",
            Animal.Type.DOG,
            Animal.Sex.F,
            1,
            3,
            30,
            false
        );
        Animal animal4 = new Animal(
            "1",
            Animal.Type.SPIDER,
            Animal.Sex.F,
            1,
            3,
            20,
            false
        );

        List<Animal> animals = List.of(animal2, animal1, animal4, animal3);

        Map<Animal.Type, Animal> expected = new HashMap<>();
        expected.put(Animal.Type.DOG, animal2);
        expected.put(Animal.Type.SPIDER, animal4);
        expected.put(Animal.Type.CAT, animal1);

        Map<Animal.Type, Animal> actual = tasks.heaviestAnimals(animals);

        assertEquals(expected, actual);
    }

    @Test
    public final void test7() {
        Animal animal1 = new Animal(
            "2",
            Animal.Type.CAT,
            Animal.Sex.F,
            10,
            3,
            50,
            false
        );
        Animal animal2 = new Animal(
            "3",
            Animal.Type.DOG,
            Animal.Sex.F,
            7,
            3,
            40,
            false
        );
        Animal animal3 = new Animal(
            "1",
            Animal.Type.DOG,
            Animal.Sex.F,
            12,
            3,
            30,
            false
        );
        Animal animal4 = new Animal(
            "1",
            Animal.Type.SPIDER,
            Animal.Sex.F,
            2,
            3,
            20,
            false
        );

        List<Animal> animals = List.of(animal2, animal1, animal4, animal3);

        Animal actual = tasks.oldestAnimal(animals, 3);

        assertEquals(animal2, actual);
    }

    @Test
    public final void test8() {
        Animal animal1 = new Animal(
            "2",
            Animal.Type.CAT,
            Animal.Sex.F,
            10,
            99,
            50,
            false
        );
        Animal animal2 = new Animal(
            "3",
            Animal.Type.DOG,
            Animal.Sex.F,
            7,
            90,
            40,
            false
        );
        Animal animal3 = new Animal(
            "1",
            Animal.Type.DOG,
            Animal.Sex.F,
            12,
            120,
            30,
            false
        );
        Animal animal4 = new Animal(
            "1",
            Animal.Type.SPIDER,
            Animal.Sex.F,
            2,
            35,
            20,
            false
        );

        List<Animal> animals = List.of(animal2, animal1, animal4, animal3);

        Animal actual = tasks.heaviestBelowK(animals, 100).get();

        assertEquals(animal1, actual);
    }

    @Test
    public final void test9() {
        Animal animal1 = new Animal(
            "2",
            Animal.Type.CAT,
            Animal.Sex.F,
            10,
            99,
            50,
            false
        );
        Animal animal2 = new Animal(
            "3",
            Animal.Type.FISH,
            Animal.Sex.F,
            7,
            90,
            40,
            false
        );
        Animal animal3 = new Animal(
            "1",
            Animal.Type.DOG,
            Animal.Sex.F,
            12,
            120,
            30,
            false
        );
        Animal animal4 = new Animal(
            "1",
            Animal.Type.SPIDER,
            Animal.Sex.F,
            2,
            35,
            20,
            false
        );

        List<Animal> animals = List.of(animal2, animal1, animal4, animal3);

        Integer actual = tasks.sumPaws(animals);

        assertEquals(16, actual);
    }

    @Test
    public final void test10() {
        Animal animal1 = new Animal(
            "2",
            Animal.Type.CAT,
            Animal.Sex.F,
            4,
            99,
            50,
            false
        );
        Animal animal2 = new Animal(
            "3",
            Animal.Type.FISH,
            Animal.Sex.F,
            7,
            90,
            40,
            false
        );
        Animal animal3 = new Animal(
            "1",
            Animal.Type.DOG,
            Animal.Sex.F,
            12,
            120,
            30,
            false
        );
        Animal animal4 = new Animal(
            "1",
            Animal.Type.SPIDER,
            Animal.Sex.F,
            8,
            35,
            20,
            false
        );

        List<Animal> animals = List.of(animal2, animal1, animal4, animal3);

        List<Animal> expected = List.of(animal2, animal3);
        List<Animal> actual = tasks.ageNotEqualPawsCount(animals);

        assertEquals(expected, actual);
    }

    @Test
    public final void test11() {
        Animal animal1 = new Animal(
            "2",
            Animal.Type.CAT,
            Animal.Sex.F,
            4,
            99,
            50,
            false
        );
        Animal animal2 = new Animal(
            "3",
            Animal.Type.FISH,
            Animal.Sex.F,
            7,
            110,
            40,
            false
        );
        Animal animal3 = new Animal(
            "1",
            Animal.Type.DOG,
            Animal.Sex.F,
            12,
            120,
            30,
            true
        );
        Animal animal4 = new Animal(
            "1",
            Animal.Type.SPIDER,
            Animal.Sex.F,
            8,
            35,
            20,
            true
        );

        List<Animal> animals = List.of(animal2, animal1, animal4, animal3);

        List<Animal> expected = List.of(animal3);
        List<Animal> actual = tasks.AnimalsCanBiteMoreThanHundred(animals);

        assertEquals(expected, actual);
    }

    @Test
    public final void test12() {
        Animal animal1 = new Animal(
            "2",
            Animal.Type.CAT,
            Animal.Sex.F,
            4,
            99,
            50,
            false
        );
        Animal animal2 = new Animal(
            "3",
            Animal.Type.FISH,
            Animal.Sex.F,
            7,
            10,
            40,
            false
        );
        Animal animal3 = new Animal(
            "1",
            Animal.Type.DOG,
            Animal.Sex.F,
            12,
            120,
            30,
            true
        );
        Animal animal4 = new Animal(
            "1",
            Animal.Type.SPIDER,
            Animal.Sex.F,
            8,
            15,
            20,
            true
        );

        List<Animal> animals = List.of(animal2, animal1, animal4, animal3);

        long actual = tasks.weightGreaterHeightCount(animals);

        assertEquals(2, actual);
    }

    @Test
    public final void test13() {
        Animal animal1 = new Animal(
            "a a a",
            Animal.Type.CAT,
            Animal.Sex.F,
            4,
            99,
            50,
            false
        );
        Animal animal2 = new Animal(
            "a a",
            Animal.Type.FISH,
            Animal.Sex.F,
            7,
            10,
            40,
            false
        );
        Animal animal3 = new Animal(
            "s",
            Animal.Type.DOG,
            Animal.Sex.F,
            12,
            120,
            30,
            true
        );
        Animal animal4 = new Animal(
            "asass",
            Animal.Type.SPIDER,
            Animal.Sex.F,
            8,
            15,
            20,
            true
        );

        List<Animal> animals = List.of(animal1, animal2, animal3, animal3);

        List<Animal> actual = tasks.nameMoreThanTwoWords(animals);
        List<Animal> expected = List.of(animal1, animal2);

        assertEquals(expected, actual);
    }

    @Test
    public final void test14() {
        Animal animal1 = new Animal(
            "2",
            Animal.Type.CAT,
            Animal.Sex.F,
            4,
            99,
            50,
            false
        );
        Animal animal2 = new Animal(
            "3",
            Animal.Type.FISH,
            Animal.Sex.F,
            7,
            10,
            40,
            false
        );
        Animal animal3 = new Animal(
            "1",
            Animal.Type.DOG,
            Animal.Sex.F,
            12,
            120,
            30,
            true
        );
        Animal animal4 = new Animal(
            "1",
            Animal.Type.SPIDER,
            Animal.Sex.F,
            8,
            15,
            20,
            true
        );

        List<Animal> animals = List.of(animal2, animal1, animal4, animal3);

        Boolean actual = tasks.hasDogMoreThanK(animals, 100);

        assertTrue(actual);
    }

    @Test
    public final void test15() {
        int l = 10;
        int k = 4;

        Animal animal1 = new Animal(
            "2",
            Animal.Type.CAT,
            Animal.Sex.F,
            4,
            99,
            50,
            false
        );
        Animal animal2 = new Animal(
            "3",
            Animal.Type.CAT,
            Animal.Sex.F,
            7,
            10,
            40,
            false
        );
        Animal animal3 = new Animal(
            "1",
            Animal.Type.DOG,
            Animal.Sex.F,
            12,
            120,
            30,
            true
        );
        Animal animal4 = new Animal(
            "1",
            Animal.Type.DOG,
            Animal.Sex.F,
            8,
            15,
            20,
            true
        );

        List<Animal> animals = List.of(animal2, animal1, animal4, animal3);

        Map<Animal.Type, Integer> expected = new HashMap<>();
        expected.put(Animal.Type.DOG, 20);
        expected.put(Animal.Type.CAT, 90);

        Map<Animal.Type, Integer> actual = tasks.sumWeightEachType(animals, k, l);

        assertEquals(expected, actual);
    }

    @Test
    public final void test16() {
        Animal animal1 = new Animal(
            "aaa",
            Animal.Type.CAT,
            Animal.Sex.F,
            4,
            99,
            50,
            false
        );
        Animal animal2 = new Animal(
            "bbb",
            Animal.Type.FISH,
            Animal.Sex.F,
            7,
            10,
            40,
            false
        );
        Animal animal3 = new Animal(
            "ccc",
            Animal.Type.CAT,
            Animal.Sex.M,
            12,
            120,
            30,
            true
        );
        Animal animal4 = new Animal(
            "ddd",
            Animal.Type.CAT,
            Animal.Sex.F,
            8,
            15,
            20,
            true
        );

        List<Animal> animals = List.of(animal1, animal2, animal3, animal4);

        List<Animal> actual = tasks.sortByTypeSexName(animals);
        List<Animal> expected = List.of(animal3, animal1, animal4, animal2);

        assertEquals(expected, actual);

    }

    @Test
    public final void test17() {
        Animal animal1 = new Animal(
            "aaa",
            Animal.Type.DOG,
            Animal.Sex.F,
            4,
            99,
            50,
            false
        );
        Animal animal2 = new Animal(
            "bbb",
            Animal.Type.SPIDER,
            Animal.Sex.F,
            7,
            10,
            40,
            true
        );
        Animal animal3 = new Animal(
            "ccc",
            Animal.Type.SPIDER,
            Animal.Sex.M,
            12,
            120,
            30,
            true
        );
        Animal animal4 = new Animal(
            "ddd",
            Animal.Type.DOG,
            Animal.Sex.F,
            8,
            15,
            20,
            true
        );

        List<Animal> animals = List.of(animal1, animal2, animal3, animal4);

        boolean actual = tasks.isSpidersBitesMoreThanDogs(animals);

        assertTrue(actual);
    }

    @Test
    public final void test18() {
        Animal animal1 = new Animal(
            "aaa",
            Animal.Type.FISH,
            Animal.Sex.F,
            4,
            99,
            50,
            false
        );
        Animal animal2 = new Animal(
            "bbb",
            Animal.Type.FISH,
            Animal.Sex.F,
            7,
            10,
            40,
            true
        );
        Animal animal3 = new Animal(
            "ccc",
            Animal.Type.SPIDER,
            Animal.Sex.M,
            12,
            120,
            30,
            true
        );
        Animal animal4 = new Animal(
            "ddd",
            Animal.Type.DOG,
            Animal.Sex.F,
            8,
            15,
            20,
            true
        );

        List<Animal> animals1 = List.of(animal1, animal3);
        List<Animal> animals2 = List.of(animal2, animal4);

        List<List<Animal>> animals = List.of(animals1, animals2);

        Animal actual = tasks.heaviestFish(animals);

        assertEquals(animal1, actual);
    }

    @Test
    void test20() {
        List<Animal> animals = List.of(
            new Animal(
                "",
                Animal.Type.SPIDER,
                Animal.Sex.F,
                3,
                1,
                -2,
                true)
        );
        Map<String, String> expected = Map.of(
            "", "name"
        );
        var actual = tasks.task20(animals);

        assertEquals(expected, actual);
    }
}
