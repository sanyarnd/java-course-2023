package edu;

import edu.hw1.Task1;
import edu.hw1.Task2;
import edu.hw1.Task3;
import edu.hw1.Task4;
import edu.hw1.Task5;
import edu.hw1.Task6;
import edu.hw1.Task7;
import edu.hw1.Task8;
import edu.hw2.task1.Addition;
import edu.hw2.task1.Constant;
import edu.hw2.task1.Exponent;
import edu.hw2.task1.Expr;
import edu.hw2.task1.Multiplication;
import edu.hw2.task1.Negate;
import edu.hw2.task4.CallingInfo;
import edu.hw3.task1.AtbashCipher;
import edu.hw3.task4.RomanNumerals;
import edu.hw3.task6.Stock;
import edu.hw3.task6.StockMarket;
import edu.hw3.task6.StockMarketImpl;
import edu.hw3.task8.ReverseIterator;
import edu.hw4.Animal;
import edu.hw4.AnimalTasks;
import edu.hw5.task3.DateParser;
import edu.project2.MazeLogic.ConsoleInterpreter;
import edu.project2.Components.Coordinates;
import edu.project2.MazeLogic.MazeGenerator;
import edu.project2.MazeLogic.MazeSolver;
import edu.project2.Interfaces.Generator;
import edu.project2.Components.Maze;
import edu.project2.Interfaces.Solver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;
import static edu.hw2.task4.CallingInfo.callingInfo;
import static edu.hw3.task2.ClusteringBrackets.clusterize;
import static edu.hw3.task3.FrequencyOfWords.countOfWords;
import static edu.hw3.task5.ContactlList.parseContacts;
import static edu.hw5.task1.ComputerClubAnalytics.calculateAverageSessionDuration;
import static edu.hw5.task2.FridayThirteenFinder.findFridaysThirteens;
import static edu.hw5.task2.FridayThirteenFinder.findNextFridayThirteen;
import static edu.hw5.task4.PasswordValidator.validatePassword;
import static edu.hw5.task5.CarNumberValidator.validateCarNumber;
import static edu.hw5.task6.SubsequenceValidator.isSubsequence;
import static edu.hw5.task7.SubsequenceValidatorForNumber.containsAtLeastThreeCharsWithThirdZero;
import static edu.hw5.task7.SubsequenceValidatorForNumber.lengthBetweenOneAndTree;
import static edu.hw5.task7.SubsequenceValidatorForNumber.startsAndEndsWithSameChar;

@SuppressWarnings("MagicNumber")
public final class Main {
    private final static Logger LOGGER = LogManager.getLogger();

    private Main() {
    }

    public static void Hw1() {
        Task1 task1 = new Task1();
        String length = "01:00";
        int totalSeconds = task1.minutesToSeconds(length);
        System.out.println(totalSeconds);
        length = "13:56";
        totalSeconds = task1.minutesToSeconds(length);
        System.out.println(totalSeconds);
        length = "10:60";
        totalSeconds = task1.minutesToSeconds(length);
        System.out.println(totalSeconds);

        System.out.println();
        //Task2
        Task2 task2 = new Task2();
        int number = 4666;
        int totalDigits = task2.countDigits(number);
        System.out.println(totalDigits);
        number = 544;
        totalDigits = task2.countDigits(number);
        System.out.println(totalDigits);
        number = 0;
        totalDigits = task2.countDigits(number);
        System.out.println(totalDigits);

        System.out.println();
        //Task3
        Task3 task3 = new Task3();
        int[] array1_1 = {1, 2, 3, 4};
        int[] array2_1 = {0, 6};
        System.out.println(task3.isNestable(array1_1, array2_1));
        int[] array1_2 = {3, 1};
        int[] array2_2 = {4, 0};
        System.out.println(task3.isNestable(array1_2, array2_2));
        int[] array1_3 = {9, 9, 8};
        int[] array2_3 = {8, 9};
        System.out.println(task3.isNestable(array1_3, array2_3));
        int[] array1_4 = {1, 2, 3, 4};
        int[] array2_4 = {2, 3};
        System.out.println(task3.isNestable(array1_4, array2_4));

        System.out.println();
        //Task4
        Task4 task4 = new Task4();
        String str = "123456";
        char[] arr = str.toCharArray();
        System.out.println(task4.fixString(arr));
        str = "hTsii  s aimex dpus rtni.g";
        arr = str.toCharArray();
        System.out.println(task4.fixString(arr));
        str = "badce";
        arr = str.toCharArray();
        System.out.println(task4.fixString(arr));

        System.out.println();
        //Task5
        Task5 task5 = new Task5();
        int num = 11211230;
        System.out.println(task5.isPalindromeDescendant(num));
        num = 13001120;
        System.out.println(task5.isPalindromeDescendant(num));
        num = 23336014;
        System.out.println(task5.isPalindromeDescendant(num));
        num = 11;
        System.out.println(task5.isPalindromeDescendant(num));

        System.out.println();
        //Task6
        Task6 task6 = new Task6();
        int numForK = 6621;
        System.out.println(task6.countK(numForK));
        numForK = 6554;
        System.out.println(task6.countK(numForK));
        numForK = 1234;
        System.out.println(task6.countK(numForK));

        System.out.println();
        //Task7
        Task7 task7 = new Task7();
        int n = 8;
        int shift = 1;
        System.out.println(task7.rotateRight(n, shift));
        n = 16;
        shift = 1;
        System.out.println(task7.rotateLeft(n, shift));
        n = 17;
        shift = 2;
        System.out.println(task7.rotateLeft(n, shift));

        System.out.println();
        //Task8
        Task8 task8 = new Task8();
        int[][] board = {
            {0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1, 0, 0, 0}
        };
        System.out.println(task8.knightBoardCapture(board));

        int[][] board1 = {
            {1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 1, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 1, 0, 1}
        };
        System.out.println(task8.knightBoardCapture(board1));

        int[][] board2 = {
            {0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0}
        };
        System.out.println(task8.knightBoardCapture(board2));
    }

    public static void Hw2() {
        //task1
        Expr two = new Constant(2);
        Expr four = new Constant(4);
        Expr negOne = new Negate(new Constant(1));
        Expr sumTwoFour = new Addition(two, four);
        Expr mult = new Multiplication(sumTwoFour, negOne);
        Expr exp = new Exponent(mult, 2);
        Expr res = new Addition(exp, new Constant(1));

        System.out.println(res + " = " + res.evaluate());

        System.out.println();
        //Task4
        CallingInfo info = callingInfo();
        System.out.println("Called from " + info.className() + "#" + info.methodName());
    }

    public static void Hw3() {
        //task1
        String encryptedText1 = AtbashCipher.encrypt("Hello, World!");
        System.out.println(encryptedText1);
        String encryptedText2 = AtbashCipher.encrypt(
            "Any fool can write code that a computer can understand. Good programmers write code that humans can understand. ― Martin Fowler");
        System.out.println(encryptedText2);

        System.out.println();
        //task2
        String input1 = "()()()";
        List<String> clusters1 = clusterize(input1);
        System.out.println(clusters1);
        String input2 = "((()))";
        List<String> clusters2 = clusterize(input2);
        System.out.println(clusters2);
        String input3 = "((()))(())()()(()())";
        List<String> clusters3 = clusterize(input3);
        System.out.println(clusters3);
        String input4 = "((())())(()(()()))";
        List<String> clusters4 = clusterize(input4);
        System.out.println(clusters4);

        System.out.println();
        //task3
        List<String> words = List.of("a", "bb", "a", "bb");
        Map<String, Integer> freqMap1 = countOfWords(words);
        System.out.println(freqMap1);

        System.out.println();
        //task4
        RomanNumerals number = new RomanNumerals();
        String result = number.getRomanNumber(2);
        System.out.println(result);
        result = number.getRomanNumber(12);
        System.out.println(result);
        result = number.getRomanNumber(16);
        System.out.println(result);

        System.out.println();
        //task5
        String[] contacts1 = {"John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"};
        String[] sortedContacts1 = parseContacts(contacts1, "ASC");
        System.out.println(Arrays.toString(sortedContacts1));

        String[] contacts2 = {"Paul Erdos", "Leonhard Euler", "Carl Gauss"};
        String[] sortedContacts2 = parseContacts(contacts2, "DESC");
        System.out.println(Arrays.toString(sortedContacts2));

        System.out.println();
        //task6
        StockMarket market = new StockMarketImpl();

        Stock stock1 = new Stock("Apple", 19650.50);
        Stock stock2 = new Stock("Google", 11200.75);
        Stock stock3 = new Stock("Mak", 20250.80);

        market.add(stock1);
        market.add(stock2);
        market.add(stock3);

        System.out.println(market.mostValuableStock().getSymbol());
        Stock delete = market.mostValuableStock();

        market.remove(delete);

        System.out.println(market.mostValuableStock().getSymbol());

        System.out.println();
        //task8
        List<Integer> numbers = List.of(1, 2, 3);
        ReverseIterator<Integer> iterator = new ReverseIterator<>(numbers);

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void Hw4() {
        List<Animal> animals = new ArrayList<>(List.of(
            new Animal("Марсель", Animal.Type.CAT, Animal.Sex.M, 3, 30, 5, true),
            new Animal("Хатико", Animal.Type.DOG, Animal.Sex.M, 12, 64, 41, true),
            new Animal("Птица говорун", Animal.Type.BIRD, Animal.Sex.M, 30, 15, 1, false),
            new Animal("Моби Дик", Animal.Type.FISH, Animal.Sex.M, 32, 500, 1500, true),
            new Animal("Черная вдова", Animal.Type.SPIDER, Animal.Sex.F, 2, 1, 0, true),
            new Animal("Базилио", Animal.Type.CAT, Animal.Sex.M, 5, 35, 7, false),
            new Animal("Муму", Animal.Type.DOG, Animal.Sex.M, 6, 35, 30, false),
            new Animal("Кеша", Animal.Type.BIRD, Animal.Sex.M, 25, 25, 2, false),
            new Animal("Немо", Animal.Type.FISH, Animal.Sex.M, 10, 15, 0, false),
            new Animal("Дори", Animal.Type.FISH, Animal.Sex.F, 20, 20, 2, false)
        ));

        List<Animal> animals2 = new ArrayList<>(List.of(
            new Animal("Шариков", Animal.Type.DOG, Animal.Sex.M, 40, 40, 35, true),
            new Animal("Яго", Animal.Type.BIRD, Animal.Sex.M, 14, 20, 2, true),
            new Animal("Блум", Animal.Type.FISH, Animal.Sex.F, 10, 19, 1, false),
            new Animal("Флора", Animal.Type.FISH, Animal.Sex.F, 11, 21, 2, false)
        ));

        List<Animal> animalsForValidate = new ArrayList<>(List.of(
            new Animal("", Animal.Type.CAT, Animal.Sex.M, 3, 30, 5, true),
            new Animal("Хатико", Animal.Type.DOG, Animal.Sex.M, -200, 64, 41, true),
            new Animal("Птица говорун", null, Animal.Sex.M, 30, 15, 1, false),
            new Animal("Моби Дик", Animal.Type.FISH, null, 32, 500, 1500, true),
            new Animal("Черная вдова", Animal.Type.SPIDER, Animal.Sex.F, 2, 1, -16925, true),
            new Animal("Флора", Animal.Type.FISH, Animal.Sex.F, 11, -250505, 2, false),
            new Animal("Марсель", Animal.Type.CAT, Animal.Sex.M, 3, 30, 5, true)
        ));

        System.out.println("---Задача 1---");
        List<Animal> output = AnimalTasks.sortByHeight(animals);
        for (Animal animal : output) {
            System.out.println(animal.name() + " - " + animal.height());
        }

        System.out.println();
        System.out.println("---Задача 2---");
        int countFirst = 2;
        List<Animal> sortedByWeight = AnimalTasks.sortByWeight(animals, countFirst);
        for (Animal animal : sortedByWeight) {
            System.out.println(animal.name() + " - " + animal.weight());
        }

        System.out.println();
        System.out.println("---Задача 3---");
        Map<Animal.Type, Long> countedByType = AnimalTasks.countByType(animals);
        countedByType.forEach((type, count) -> System.out.println(type + " - " + count));

        System.out.println();
        System.out.println("---Задача 4---");
        Optional<Animal> longestName = AnimalTasks.getLongestName(animals);
        longestName.ifPresent(animal -> System.out.println(animal.name()));

        System.out.println();
        System.out.println("---Задача 5---");
        String popularGender = AnimalTasks.numberOfAnimalsByGender(animals);
        System.out.println(popularGender);

        System.out.println();
        System.out.println("---Задача 6---");
        Map<Animal.Type, Optional<Animal>> heaviest = AnimalTasks.heaviestByType(animals);
        heaviest.forEach((type, animal) -> {
            if (animal.isPresent()) {
                System.out.println(type + " - " + animal.get().name());
            } else {
                System.out.println(type + " - Нет животных этого вида");
            }
        });

        System.out.println();
        System.out.println("---Задача 7---");
        int age = 2;
        Animal olderAnimal = AnimalTasks.oldestAnimal(animals, age);
        System.out.println(olderAnimal);

        System.out.println();
        System.out.println("---Задача 8---");
        int height = 20;
        Optional<Animal> heviest = AnimalTasks.heaviestAnimal(animals, height);
        heviest.ifPresent(animal -> System.out.println(animal.name()));

        System.out.println();
        System.out.println("---Задача 9---");
        int sumPaws = AnimalTasks.sumOfPaws(animals);
        System.out.println(sumPaws);

        System.out.println();
        System.out.println("---Задача 10---");
        List<Animal> different = AnimalTasks.differentPaws(animals);
        different.forEach(animal -> System.out.println(animal.name()));

        System.out.println();
        System.out.println("---Задача 11---");
        List<Animal> biteAndHigh = AnimalTasks.biteAndHighAnimals(animals);
        biteAndHigh.forEach(animal -> System.out.println(animal.name()));

        System.out.println();
        System.out.println("---Задача 12---");
        long weight = AnimalTasks.weightGreaterThanHeightCount(animals);
        System.out.println(weight);

        System.out.println();
        System.out.println("---Задача 13---");
        List<Animal> names = AnimalTasks.namesWithMoreThanTwoWords(animals);
        if (names.size() > 0) {
            for (var animal : names) {
                System.out.println(animal);
            }
        } else {
            System.out.println("Нет таких животных");
        }

        System.out.println();
        System.out.println("---Задача 14---");
        int dogHeight = 35;
        boolean dog = AnimalTasks.tallDog(animals, dogHeight);
        if (dog) {
            System.out.println("В списке есть собака ростом более " + dogHeight + " см");
        } else {
            System.out.println("В списке нет собаки ростом более " + dogHeight + " см");
        }

        System.out.println();
        System.out.println("---Задача 15---");
        int minAge = 1;
        int maxAge = 50;
        Map<Animal.Type, Integer> totalWeightByType = AnimalTasks.totalWeightByType(animals, minAge, maxAge);
        totalWeightByType.forEach((type, totalWeight) -> System.out.println(type + " - " + totalWeight));

        System.out.println();
        System.out.println("---Задача 16---");
        List<Animal> sorted = AnimalTasks.sortedByTypeSexName(animals);
        sorted.forEach(animal -> System.out.println(animal.name()));

        System.out.println();
        System.out.println("---Задача 17---");
        boolean spidersAndDogs = AnimalTasks.spidersBiteMoreThanDogs(animals);
        System.out.println(spidersAndDogs);

        System.out.println();
        System.out.println("---Задача 18---");
        Optional<Animal> heaviestFish = AnimalTasks.allFish(animals, animals2);
        heaviestFish.ifPresent(animal -> System.out.println(animal.name()));

        System.out.println();
        System.out.println("---Задача 19---");
        AnimalTasks.validation(animalsForValidate);

        System.out.println();
        System.out.println("---Задача 20---");
        AnimalTasks.upgradeValidation(animalsForValidate);
    }

    public static void ProjectMaze() {
        int height = 10;
        int width = 10;

        Generator generator = new MazeGenerator(new Random());
        Maze maze = generator.generate(height, width);

        System.out.println("Лабиринт:");
        System.out.println(new ConsoleInterpreter().render(maze));

        System.out.println("Вам необходимо ввести координаты конечной и начальной точки:");
        Scanner scanner = new Scanner(System.in);
        System.out.print("x1: ");
        int x1 = scanner.nextInt();
        System.out.print("y1: ");
        int y1 = scanner.nextInt();
        Coordinates start = new Coordinates(x1, y1);
        System.out.print("x2: ");
        int x2 = scanner.nextInt();
        System.out.print("y2: ");
        int y2 = scanner.nextInt();
        Coordinates end = new Coordinates(x2, y2);

        System.out.print("Вы хотите проложить путь из ");
        System.out.print("(" + start.row() + ", " + start.col() + ")");
        System.out.print(" в ");
        System.out.print("(" + end.row() + ", " + end.col() + ")");
        System.out.println();
        Solver solver = new MazeSolver();
        List<Coordinates> path = solver.solve(maze, start, end);
        System.out.println();
        System.out.println();
        if (path.size() != 0) {
            System.out.println("Вывод пути в лабиринте:");
            System.out.println(new ConsoleInterpreter().render(maze, path));
        } else {
            System.out.println("Такого пути не существует");
        }
    }

    public static void main(String[] args) {
        //Hw1();
        //Hw2();
        //Hw3();
        //Hw4();
        //ProjectMaze();

        //task1
        List<String> sessions = List.of(
            "2022-03-12, 20:20 - 2022-03-12, 23:50",
            "2022-04-01, 21:30 - 2022-04-02, 01:20"
        );

        Duration averageDuration = calculateAverageSessionDuration(sessions);
        System.out.println("Average session duration: " + averageDuration.toHours() + "ч " +
            (averageDuration.toMinutes() % 60) + "м");

        System.out.println();
        //task2
        int year = 1925;
        List<LocalDate> fridaysThirteens = findFridaysThirteens(year);
        System.out.println("Fridays the 13th in " + year + ": " + fridaysThirteens);

        LocalDate date = LocalDate.of(2020, 11, 19);
        LocalDate nextFridayThirteen = findNextFridayThirteen(date);
        System.out.println("Next Friday the 13th after " + date + ": " + nextFridayThirteen);

        System.out.println();
        //task3
        DateParser dateParser = new DateParser();
        System.out.println(dateParser.parseDate("2020-10-10"));
        System.out.println(dateParser.parseDate("2020-12-2"));
        System.out.println(dateParser.parseDate("1/3/1976"));
        System.out.println(dateParser.parseDate("1/3/20"));
        System.out.println(dateParser.parseDate("tomorrow"));
        System.out.println(dateParser.parseDate("today"));
        System.out.println(dateParser.parseDate("yesterday"));
        System.out.println(dateParser.parseDate("1 day ago"));
        System.out.println(dateParser.parseDate("2234 days ago"));
        System.out.println(dateParser.parseDate("invalid date"));

        System.out.println();
        //task4
        System.out.println(validatePassword("password"));
        System.out.println(validatePassword("pass@word"));
        System.out.println(validatePassword("pa$$word"));

        System.out.println();
        //task5
        System.out.println(validateCarNumber("А123ВЕ777"));
        System.out.println(validateCarNumber("О777ОО177"));
        System.out.println(validateCarNumber("123АВЕ777"));
        System.out.println(validateCarNumber("А123ВГ77"));
        System.out.println(validateCarNumber("А123ВЕ7777"));

        System.out.println();
        //task6
        System.out.println(isSubsequence("abc", "achfdbaabgabcaabg"));
        System.out.println(isSubsequence("xyz", "achfdbaabgabcaabg"));
        System.out.println(isSubsequence("aab", "achfdbaabgabcaabg"));

        System.out.println();
        //task7
        System.out.println(containsAtLeastThreeCharsWithThirdZero("110"));
        System.out.println(containsAtLeastThreeCharsWithThirdZero("1101"));
        System.out.println(containsAtLeastThreeCharsWithThirdZero("1110"));
        System.out.println(containsAtLeastThreeCharsWithThirdZero("10"));

        System.out.println(startsAndEndsWithSameChar("010"));
        System.out.println(startsAndEndsWithSameChar("101"));

        System.out.println(lengthBetweenOneAndTree("0"));
        System.out.println(lengthBetweenOneAndTree("00"));
        System.out.println(lengthBetweenOneAndTree("0000"));
    }
}
