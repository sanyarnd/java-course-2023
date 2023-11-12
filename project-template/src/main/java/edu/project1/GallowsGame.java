package edu.project1;

import java.util.Random;
import java.util.Scanner;

public class GallowsGame {
    private static final String[] WORDS = {"hello", "world", "java", "hangman"};
    private static final int MAX_MISTAKES = 5;

    public static void main(String[] args) {
        Random random = new Random();
        String word = WORDS[random.nextInt(WORDS.length)];
        char[] guessedLetters = new char[word.length()];
        boolean isSurrender = false;
        int mistakes = 0;

        Scanner scanner = new Scanner(System.in);

        while (mistakes < MAX_MISTAKES) {
            System.out.println("Чтобы закончить играть введите '!':");
            System.out.println("Введите букву:");
            char letter = scanner.nextLine().charAt(0);

            if (letter == '!') {
                mistakes = MAX_MISTAKES;
                isSurrender = true;
                break;
            }

            if (word.indexOf(letter) != -1) {
                System.out.println("Такая буква есть!");
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == letter) {
                        guessedLetters[i] = letter;
                    }
                }
            } else {
                mistakes++;
                System.out.println("Такой буквы нет, попытка " + mistakes + " из " + MAX_MISTAKES);
            }

            System.out.println("Загаданное слово: " + String.valueOf(guessedLetters));

            if (String.valueOf(guessedLetters).equals(word)) {
                System.out.println("Ты победил!");
                return;
            }
        }

        if (isSurrender) {
            System.out.println("Игра закончена досрочно. Загаданное слово " + word);
        } else {
            System.out.println("Ты проиграл! Загаданное слово: " + word);
        }
    }
}
