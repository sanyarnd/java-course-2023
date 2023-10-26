package edu.project1;

import java.util.Arrays;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class HangmanGame {
    private static final int MAX_ATTEMPTS = 5;
    private final static Logger LOGGER = LogManager.getLogger();
    private WordProvider wordProvider;

    HangmanGame(WordProvider wordProvider) {
        this.wordProvider = wordProvider;
    }

    public void run() {
        char[] answer = wordProvider.selectRandomWord();
        char[] answerUser = initializeAnswerUser(answer.length);
        int mistakes = 0;

        LOGGER.trace("Welcome to the club, buddy!");

        while (countUnknownLetters(answerUser) > 0 && mistakes < MAX_ATTEMPTS) {
            char guess = promptForGuess();
            if (guess == '1') {
                break;
            }

            if (checkGuess(answer, answerUser, guess)) {
                LOGGER.trace("Hit!");
            } else {
                mistakes++;
                LOGGER.trace("Missed, mistake {} out of {}.", mistakes, MAX_ATTEMPTS);
            }

            displayCurrentProgress(answerUser);
        }

        if (mistakes == MAX_ATTEMPTS) {
            LOGGER.trace("Have a nice dead!");
        } else {
            LOGGER.trace("Ok, you can live while it's possible");
        }
    }

    private char[] initializeAnswerUser(int length) {
        char[] answerUser = new char[length];
        Arrays.fill(answerUser, '*');
        return answerUser;
    }

    private int countUnknownLetters(char[] answerUser) {
        int count = 0;
        for (char c : answerUser) {
            if (c == '*') {
                count++;
            }
        }
        return count;
    }

    private char promptForGuess() {
        LOGGER.trace("Guess a letter:");
        char guess = '1';
        boolean correctInput = false;
        Scanner scanner = new Scanner(System.in);

        while (!correctInput) {
            String input = scanner.next();
            if (input.equals("exit")) {
                return '1';
            }
            if (input.length() == 1) {
                guess = input.charAt(0);
                if (!Character.isDigit(guess)) {
                    correctInput = true;
                }
            }
        }
        return guess;
    }

    private boolean checkGuess(char[] answer, char[] answerUser, char guess) {
        boolean found = false;
        for (int i = 0; i < answer.length; i++) {
            if (guess == answer[i]) {
                found = true;
                answerUser[i] = guess;
            }
        }
        return found;
    }

    private void displayCurrentProgress(char[] answerUser) {
        StringBuilder progress = new StringBuilder("The word: ");
        for (char c : answerUser) {
            progress.append(c);
        }
        LOGGER.trace(progress.toString());
    }
}
