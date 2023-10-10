package edu.project1;

class Session { // Session class for attempts counting and returning Guess Result
    private final String answer;
    private final char[] userAnswer;
    private final int maxAttempts;
    private int currentAttempts;

    Session(String answer, int maxAttempts) {
        this.answer = answer;
        this.maxAttempts = maxAttempts;
        this.userAnswer = new char[answer.length()];
        this.currentAttempts = 0;
        for (int i = 0; i < answer.length(); i++) {
            userAnswer[i] = '*';
        }
    }

    public GuessResult guess(char guess) {
        currentAttempts++;
        boolean correctGuess = false;
        for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) == guess) {
                userAnswer[i] = guess;
                correctGuess = true;
            }
        }
        if (correctGuess) {
            if (String.valueOf(userAnswer).equals(answer)) {
                return new Win(userAnswer, currentAttempts, maxAttempts, "You won!");
            }
            return new SuccessfulGuess(userAnswer, currentAttempts, maxAttempts, "Hit!");
        } else {
            if (currentAttempts >= maxAttempts) {
                return new Defeat(userAnswer, currentAttempts, maxAttempts, "You lost!");
            }
            return new FailedGuess(
                userAnswer,
                currentAttempts,
                maxAttempts,
                "Missed, mistake " + currentAttempts + " out of " + maxAttempts + "."
            );
        }
    }

    public GuessResult giveUp() {
        return new Defeat(answer.toCharArray(), currentAttempts, maxAttempts, "You gave up! The word was: " + answer);
    }
}
