package edu.project1;

sealed interface GuessResult permits SuccessfulGuess, FailedGuess, Win, Defeat {
    char[] state();

    int attempt();

    int maxAttempts();

    String message();
}

record FailedGuess(char[] state, int attempt, int maxAttempts, String message) implements GuessResult {
}

record Win(char[] state, int attempt, int maxAttempts, String message) implements GuessResult {
}

record Defeat(char[] state, int attempt, int maxAttempts, String message) implements GuessResult {
}

record SuccessfulGuess(char[] state, int attempt, int maxAttempts, String message) implements GuessResult {
}
