package edu.project1;

import java.util.Scanner;

public class ConsoleHangman {
    private final Dictionary dictionary;
    private final Session session;

    public ConsoleHangman(Dictionary dictionary, Session session) {
        this.dictionary = dictionary;
        this.session = session;
    }

    public void run() {
        System.out.println("Игра - Виселица!");
        System.out.println("Чтобы сдаться, введите <стоп>");

        while (session.attempts() < session.maxAttempts()) {
            printState(session.guessResult());

            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите букву: ");
            String input = scanner.nextLine();

            if (input.equals("стоп")) {
                System.out.println("Игра закончена досрочно");
                break;
            }

            if (input.length() != 1) {
                System.out.println("Вводите только буквы");
                continue;
            }

            GuessResult result = tryGuess(session, input.charAt(0));
            if (result instanceof Win || result instanceof Defeat) {
                printState(result);
                break;
            }
        }
    }

    private GuessResult tryGuess(Session session, char guess) {
        return session.guess(guess);
    }

    private void printState(GuessResult guess) {
        System.out.println("Попыток осталось: " + (session.maxAttempts() - session.attempts()));
        System.out.println(guess.state());
        System.out.println(guess.message());
    }

    public static void main(String[] args) {
        Dictionary dictionary = new EnglishDictionary();
        Session session = new Session(dictionary.randomWord(), 6);
        ConsoleHangman game = new ConsoleHangman(dictionary, session);
        game.run();
    }
}
