package edu.project1;

import org.jetbrains.annotations.NotNull;

sealed interface GuessResult permits Defeat, FailedGuess, SuccessfulGuess, Win {
    char[] state();

    @NotNull String message();
}
