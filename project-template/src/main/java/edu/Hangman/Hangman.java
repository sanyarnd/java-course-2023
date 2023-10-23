package edu.Hangman;

import java.util.Random;
import java.util.Scanner;

public class Hangman {
    private static final String[] WORDS = {"hello", "world", "java", "hangman"};
    private static final int MAX_MISTAKES = 5;

    public static void main(String[] args) {
        Random random = new Random();
        String wordToGuess = WORDS[random.nextInt(WORDS.length)];
        char[] guessedWord = new char[wordToGuess.length()];
        for (int i = 0; i < wordToGuess.length(); i++) {
            guessedWord[i] = '*';
        }

        int mistakes = 0;
        Scanner scanner = new Scanner(System.in);
        String guessedLetters = "";

        System.out.println("Welcome to Hangman!");
        while (mistakes < MAX_MISTAKES) {
            System.out.println("Guess a letter:");
            char guess = scanner.next().charAt(0);

            if (guessedLetters.contains(String.valueOf(guess))) {
                System.out.println("You've already guessed that letter.");
                continue;
            }
            guessedLetters += guess;

            if (wordToGuess.contains(String.valueOf(guess))) {
                System.out.println("Hit!");
                for (int i = 0; i < wordToGuess.length(); i++) {
                    if (wordToGuess.charAt(i) == guess) {
                        guessedWord[i] = guess;
                    }
                }
            } else {
                System.out.println("Missed, mistake " + (mistakes + 1) + " out of " + MAX_MISTAKES);
                mistakes++;
            }

            System.out.println("The word: " + new String(guessedWord));
            if (new String(guessedWord).equals(wordToGuess)) {
                System.out.println("You won!");
                break;
            }
        }

        if (mistakes == MAX_MISTAKES) {
            System.out.println("You lost! The word was: " + wordToGuess);
        }
    }
}
