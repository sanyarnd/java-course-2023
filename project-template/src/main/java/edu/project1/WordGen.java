package edu.project1;

import java.util.Random;

public class WordGen {
    private static final String[] words = new String[]
        {"башня", "вишня", "сапог", "замок", "перец", "арбуз", "топор", "стена"};
    public static String wordGeneration(){
        Random random = new Random();
        int x = random.nextInt(words.length);
        return words[x];
    }
}
