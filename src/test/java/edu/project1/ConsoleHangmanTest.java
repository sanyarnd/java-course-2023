package edu.project1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThat;

class ConsoleHangmanTest {
    private ConsoleHangman consoleHangman;

    @BeforeEach
    void setUp() {
        String[] words = {"test", "hello", "world"};
        Dictionary dictionary = new SimpleDictionary(words);
        int maxAttempts = 5;
        consoleHangman = new ConsoleHangman(dictionary, maxAttempts);
    }

    @ParameterizedTest
    @ValueSource(strings = {"t", "e", "s", "t"}) // test with various valid guesses
    void testCorrectGuess(String guess) {
        GuessResult result = consoleHangman.tryGuess(new Session("test", 5), guess.charAt(0));
        assertThat(result).isInstanceOf(SuccessfulGuess.class);
    }

    @Test
    void testIncorrectGuess() {
        GuessResult result = consoleHangman.tryGuess(new Session("test", 5), 'z');
        assertThat(result).isInstanceOf(FailedGuess.class);
    }

    @Test
    void testGiveUp() {
        GuessResult result = consoleHangman.tryGuess(new Session("test", 5), 'q');
        assertThat(result).isInstanceOf(Defeat.class);
    }

    @Test
    void testWinningGame() {
        Session session = new Session("hello", 5);
        GuessResult result = consoleHangman.tryGuess(session, 'h');
        assertThat(result).isInstanceOf(SuccessfulGuess.class);
        result = consoleHangman.tryGuess(session, 'e');
        assertThat(result).isInstanceOf(SuccessfulGuess.class);
        result = consoleHangman.tryGuess(session, 'l');
        assertThat(result).isInstanceOf(SuccessfulGuess.class);
        result = consoleHangman.tryGuess(session, 'o');

        assertThat(result).isInstanceOf(Win.class);
    }

    @Test
    void testLosingGame() {
        Session session = new Session("hello", 5);
        GuessResult result = null;
        for (int i = 0; i < 5; ++i) {
            result = consoleHangman.tryGuess(session, 'f');
        }
        assertThat(result).isInstanceOf(Defeat.class);
    }
}
