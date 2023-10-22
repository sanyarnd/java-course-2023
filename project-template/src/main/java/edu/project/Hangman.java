package edu.project;

import java.util.Arrays;
import java.util.Scanner;

public class Hangman {
    private static final String[] WORDS = {"fork", "snake", "lamp", "glasses", "bakery"};

    static final int MIN_WORD_LENGTH = 4;
    static final int MAX_WORD_LENGTH = 10;
    public static int MAX_TRIES = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String wordToGuess = getValidWordToGuess();

        if (wordToGuess == null) {
            System.out.println("No valid words. Exiting the game.");
            scanner.close();
            return;
        }

        char[] wordState = new char[wordToGuess.length()];
        Arrays.fill(wordState, '_');
        int tries = 0;

        while (tries < MAX_TRIES) {
            System.out.println("Current state: " + String.valueOf(wordState));
            System.out.println("Tries left: " + (MAX_TRIES - tries));
            System.out.print("Enter a letter (Ctrl+D to surrender): ");
            String input = readInput(scanner);
            if (input == null) {
                System.out.println("Surrendered! The word was: " + wordToGuess);
                break;
            }
            char c = input.charAt(0);
            if (!updateState(wordToGuess, wordState, c)) {
                tries++;
                System.out.println("Incorrect! Try again.");
            }
            if (isWordGuessed(wordState)) {
                System.out.println("You win! Secret word - " + wordToGuess);
                break;
            }
        }
        if (tries == MAX_TRIES) {
            System.out.println("End of tries! Secret word - " + wordToGuess);
        }
        scanner.close();
    }

    static String readInput(Scanner scanner) {
        String input = null;
        try {
            input = scanner.nextLine();
            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                System.out.println("Please enter only one letter.");
                return readInput(scanner);
            }
            input = input.toLowerCase();
        } catch (Exception e) {
        }
        return input;
    }

    static boolean updateState(String wordToGuess, char[] wordState, char c) {
        boolean isUpdate = false;
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == c) {
                wordState[i] = c;
                isUpdate = true;
            }
        }
        return isUpdate;
    }

    private static boolean isWordGuessed(char[] wordState) {
        for (char c : wordState) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }

    static String getValidWordToGuess() {
        String wordToGuess = null;
        while (wordToGuess == null) {
            wordToGuess = WORDS[(int) (Math.random() * WORDS.length)];
            if (wordToGuess.length() < MIN_WORD_LENGTH || wordToGuess.length() > MAX_WORD_LENGTH) {
                wordToGuess = null;
            }
        }
        return wordToGuess;
    }

    static boolean isGameOver(char[] wordState) {
        for (char c : wordState) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }

}
