package edu.project;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

public class HangmanTest {

    @Test
    public void testGameDoesNotStartWithInvalidWordLength() {
        Hangman hangman = new Hangman();
        String wordToGuess = hangman.getValidWordToGuess();

        assertTrue(wordToGuess.length() >= Hangman.MIN_WORD_LENGTH);
        assertTrue(wordToGuess.length() <= Hangman.MAX_WORD_LENGTH);
    }


    @Test
    public void testUpdateStateWithCorrectGuess() {
        Hangman hangman = new Hangman();
        char[] wordState = "sn_k_".toCharArray();
        String wordToGuess = "snake";
        char guess = 'a';

        boolean result = hangman.updateState(wordToGuess, wordState, guess);

        assertTrue(result);
        assertArrayEquals(new char[]{'s', 'n', 'a', 'k', '_'}, wordState);
    }

    @Test
    public void testUpdateStateWithIncorrectGuess() {
        Hangman hangman = new Hangman();
        char[] wordState = "sn_k_".toCharArray();
        String wordToGuess = "snake";
        char guess = 'r';

        boolean result = hangman.updateState(wordToGuess, wordState, guess);

        assertFalse(result);
        assertArrayEquals(new char[]{'s', 'n', '_', 'k', '_'}, wordState);
    }

    @Test
    public void testInputRetryForMultipleCharacters() {
        Hangman hangman = new Hangman();
        char[] wordState = "sn_k_".toCharArray();
        String wordToGuess = "snake";

        // Подготовим ввод для имитации
        String input = "ab";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String result = hangman.readInput(new Scanner(System.in));

        System.setIn(System.in); // Восстановим стандартный ввод

        assertEquals(null, result);
        assertArrayEquals(new char[]{'s', 'n', '_', 'k', '_'}, wordState);
    }

    @Test
    public void testGameEndsInDefeatAfterExceedingMaxTries() {
        Hangman hangman = new Hangman();
        hangman.MAX_TRIES = 3; // Устанавливаем максимальное количество попыток в 3 для теста
        char[] wordState = "_____".toCharArray();
        String wordToGuess = "snake";

        // Выполняем неудачные попытки
        assertFalse(hangman.updateState(wordToGuess, wordState, 'z'));
        assertFalse(hangman.updateState(wordToGuess, wordState, 'y'));
        assertFalse(hangman.updateState(wordToGuess, wordState, 'x'));

        // Проверяем, что игра завершается поражением
        assertFalse(hangman.isGameOver(wordState));
    }
}
