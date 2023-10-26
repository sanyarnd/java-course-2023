package edu.project1;

public class SampleTest {
    public static void main(String[] args) {
        WordProvider wordProvider = new DictionaryWordProvider();
        HangmanGame game = new HangmanGame(wordProvider);
        game.run();
    }
}
