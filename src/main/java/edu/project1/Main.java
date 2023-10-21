package edu.project1;

public final class Main {

    private Main() {
    }

    private static final int MAX_ATTEMPTS = 5;

    public static void main(String[] args) { // q - end of the game
        String[] words = {"hangman", "programming", "java", "computer", "code"};
        Dictionary dictionary = new SimpleDictionary(words);
        ConsoleHangman hangman = new ConsoleHangman(dictionary, MAX_ATTEMPTS);
        hangman.run();
    }
}

