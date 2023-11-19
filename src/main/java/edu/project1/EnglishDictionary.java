package edu.project1;

class EnglishDictionary implements Dictionary {
    private static final String[] WORDS = {"java", "hello", "hangman", "computer"};

    @Override
    public String randomWord() {
        int index = (int) (Math.random() * WORDS.length);
        return WORDS[index];
    }
}
