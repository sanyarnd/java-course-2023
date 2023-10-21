package edu.project1;

import java.util.Scanner;
import java.util.logging.Logger;

class ConsoleHangman {
    private final Dictionary dictionary;
    private final int maxAttempts;
    private static final Logger LOGGER = Logger.getLogger(ConsoleHangman.class.getName());

    ConsoleHangman(Dictionary dictionary, int maxAttempts) {
        this.dictionary = dictionary;
        this.maxAttempts = maxAttempts;
    }

    public void run() {
        String wordToGuess = dictionary.randomWord().toLowerCase();
        Session session = new Session(wordToGuess, maxAttempts);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            LOGGER.info("Guess a letter:");
            char guess;
            try {
                String string = scanner.nextLine().toLowerCase(); // more than one letter check
                if (string.length() != 1) {
                    throw new RuntimeException();
                }
                guess = string.charAt(0);
            } catch (RuntimeException e) {
                LOGGER.info("Invalid input. Try again.");
                continue;
            }

            GuessResult result = tryGuess(session, guess);
            printState(result);

            if (result instanceof Defeat || result instanceof Win) { // if we lose - break out of the loop
                break;
            }
        }
    }

    public GuessResult tryGuess(Session session, char guess) {
        if (guess == 'q') {
            return session.giveUp();
        }
        return session.guess(guess); // here is our guess attempt
    }

    private void printState(GuessResult guessResult) {
        LOGGER.info(guessResult.message());
        if (guessResult instanceof Win || guessResult instanceof Defeat) {
            return;
        }
        LOGGER.info("The word: " + new String(guessResult.state()));
    }

}
