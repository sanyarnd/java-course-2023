package edu.project1;

import org.jetbrains.annotations.NotNull;

record FailedGuess(char[] state, int attempt, int maxAttempts, @NotNull String message) implements GuessResult {
}
