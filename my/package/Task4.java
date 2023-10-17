package edu.hw1;
import java.util.Scanner;
public class Task4 {
    public static String fixString(String string) {
        char[] goodstring = new char[string.length()];

        for (int i = 0; i < string.length(); i++) {
            goodstring[i] = string.charAt(i);
        }

        for (int i = 0; i < string.length() - 1; i += 2) {
            char temp = goodstring[i];
            goodstring[i] = goodstring[i + 1];
            goodstring[i + 1] = temp;
        }

        // Создаем новую строку на основе массива символов
        String result = new String(goodstring);

        return result;
    }

    public static void main (String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String userInput;
        userInput = scanner.nextLine();
        scanner.close();
        System.out.println(fixString(userInput));
    }
    }

