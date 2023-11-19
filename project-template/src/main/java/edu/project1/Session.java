package edu.project1;

public class Session {
    private final String answer;
    private final char[] userAnswer;
    private final int maxAttempts;
    private int attempts;

    public Session(String answer, int maxAttempts) {
        this.answer = answer;
        this.userAnswer = new char[answer.length()];
        this.maxAttempts = maxAttempts;
        this.attempts = 0;
    }

    public GuessResult guess(char guess) {
        boolean successfulGuess = false;
        for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) == guess) {
                userAnswer[i] = guess;
                successfulGuess = true;
            }
        }

        if (successfulGuess) {
            if (String.valueOf(userAnswer).equals(answer)) {
                return new Win(userAnswer, attempts, maxAttempts, "Поздравляю! Ты отгадал слово!");
            } else {
                return new SuccessfulGuess(userAnswer, attempts, maxAttempts, "Так держать, продолжай!");
            }
        } else {
            attempts++;
            if (attempts == maxAttempts) {
                return new Defeat(
                    userAnswer,
                    attempts,
                    maxAttempts,
                    "Попытки закончились, игра закончена! Это было слово: " + answer
                );
            } else {
                return new FailedGuess(userAnswer, attempts, maxAttempts, "Этой буквы нет в слове");
            }
        }
    }

    public int attempts() {
        return attempts;
    }

    public int maxAttempts() {
        return maxAttempts;
    }

    public GuessResult guessResult() {
        return new SuccessfulGuess(userAnswer, attempts, maxAttempts, "");
    }
}
