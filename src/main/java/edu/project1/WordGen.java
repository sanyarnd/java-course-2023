package edu.project1;

import java.util.Random;

public class WordGen {
    private WordGen() {
    }

    private static final String[] WORDS = new String[]
        {"башня", "вишня", "сапог", "замок", "перец", "арбуз", "топор", "стена"};

    public static String wordGeneration() {
        Random random = new Random();
        int x = random.nextInt(WORDS.length);
        return WORDS[x];
    }
}
