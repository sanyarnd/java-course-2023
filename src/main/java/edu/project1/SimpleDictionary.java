package edu.project1;

import java.util.Random;
import org.jetbrains.annotations.NotNull;


class SimpleDictionary implements Dictionary {
    private final String[] words;

    SimpleDictionary(String[] words) {
        this.words = words;
    }

    @Override
    public @NotNull String randomWord() {
        Random random = new Random();
        int index = random.nextInt(words.length);
        return words[index];
    }
}
