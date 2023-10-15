package org.lisi4ka;

import org.lisi4ka.tasks.Task0;

import java.util.NoSuchElementException;
import java.util.Scanner;

import static java.lang.Thread.sleep;
import static org.lisi4ka.Messages.*;
import static org.lisi4ka.tasks.Task1.task1;
import static org.lisi4ka.tasks.Task2.task2;
import static org.lisi4ka.tasks.Task3.task3;
import static org.lisi4ka.tasks.Task4.task4;
import static org.lisi4ka.tasks.Task5.task5;
import static org.lisi4ka.tasks.Task6.task6;
import static org.lisi4ka.tasks.Task7.*;
import static org.lisi4ka.tasks.Task8.task8;

public class Main {
    static boolean exit = false;
    private static String input(){
        Scanner scanner = new Scanner(System.in);
        String input = null;
        try {
             input = scanner.nextLine();
        } catch (NoSuchElementException ex){
            System.out.println("Принудительное завершение программы");
            exit = true;
        }
        return input;
    }
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        while (!exit){
            int input;
            System.out.print("Введите номер проверяемого задания (от 0 до 8), \"exit\" для выхода, \"help\" для помощи: ");
            String inputs;
            try {
                inputs = scanner.nextLine().trim().toLowerCase();
            } catch (NoSuchElementException ex){
                System.out.println("Принудительное завершение программы");
                exit = true;
                continue;
            }
            if (inputs.equals("exit")){
                exit = true;
                System.out.println("Завершение программы");
            } else if (inputs.equals("help")){
                System.out.println(helpMessage);
            } else {
                try {
                    input = Integer.parseInt(inputs);
                } catch (NumberFormatException ex) {
                    System.out.println("Некорректное значение! Попробуйте еще раз!");
                    continue;
                }
                if (input == 0) {
                    Task0.task0();
                    sleep(100);
                } else {
                    if (input == 1) {
                        System.out.print("Введите время в формате \"mm:ss\": ");
                        try {
                            System.out.println("Результат: " + task1(input()));
                        } catch (NumberFormatException ex){
                            System.out.println(formatMessage);
                        } catch (Exception ex){
                            System.out.println(errMessage);
                        }
                    } else if (input == 2) {
                        System.out.print("Введите любое число (целое или дробное): ");
                        try {
                            System.out.println("Результат: " + task2(input()));
                        } catch (NumberFormatException ex){
                            System.out.println(formatMessage);
                        } catch (Exception ex){
                            System.out.println(errMessage);
                        }
                    } else if (input == 3) {
                        System.out.print("Введите два массива целых чисел (числа в массиве должны идти через пробел, массивы должны быть разделены знаком \",\"): ");
                        try {
                            System.out.println("Результат: " + task3(input()));
                        } catch (NumberFormatException ex){
                            System.out.println(formatMessage);
                        } catch (Exception ex){
                            System.out.println(errMessage);
                        }
                    } else if (input == 4) {
                        System.out.print("Введите строку, которую надо исправить: ");
                        try {
                            System.out.println("Результат: " + task4(input()));
                        } catch (NumberFormatException ex){
                            System.out.println(formatMessage);
                        } catch (Exception ex){
                            System.out.println(errMessage);
                        }
                    } else if (input == 5) {
                        System.out.print("Введите целое положительное число: ");
                        try {
                            System.out.println("Результат: " + task5(input()));
                        } catch (NumberFormatException ex){
                            System.out.println(formatMessage);
                        } catch (Exception ex){
                            System.out.println(errMessage);
                        }
                    } else if (input == 6) {
                        System.out.print("Введите целое четырехзначное число, в котором не все числа одинаковые: ");
                        try {
                            System.out.println("Результат: " + task6(input()));
                        } catch (NumberFormatException ex){
                            System.out.println(formatMessage);
                        } catch (Exception ex){
                            System.out.println(errMessage);
                        }
                    } else if (input == 7) {
                        System.out.print("Введите \"right\" для циклического сдвига вправо и \"left\" для циклического сдвига влево: ");
                        try {
                            String chose = input();
                        if (chose.equalsIgnoreCase("right") || chose.equalsIgnoreCase("r")){
                            System.out.print("Введите два числа (целые, положительные) через запятую (первое - число для сдвига, второе - размер циклического сдвига): ");
                            System.out.println("Результат: " + task7right(input()));
                        } else if (chose.equalsIgnoreCase("left") || chose.equalsIgnoreCase("l")) {
                            System.out.print("Введите два числа (целые, положительные) через запятую (первое - число для сдвига, второе - размер циклического сдвига): ");
                            System.out.println("Результат: " + task7left(input()));
                        } else {
                            System.out.println("Некорректные входные данные!");
                        }
                        } catch (NumberFormatException ex){
                            System.out.println(formatMessage);
                        } catch (Exception ex){
                            System.out.println(errMessage);
                        }
                    } else if (input == 8) {
                        System.out.print("Введите расположение фигур коней на доске (0 - нет коня, 1 - есть конь): ");
                        try {
                            StringBuilder stringBuilder = new StringBuilder();
                            for (int i = 0; i < 7; i++){
                                stringBuilder.append(input().trim()).append(":");
                            }
                            stringBuilder.append(input().trim());
                            System.out.println("Результат: " + task8(stringBuilder.toString()));
                        } catch (NumberFormatException ex){
                            System.out.println(formatMessage);
                        } catch (Exception ex){
                            System.out.println(errMessage);
                        }
                    }else {
                        System.out.println("Некорректный номер задания! Попробуйте еще раз!");
                    }
                }
            }
        }
    }
}