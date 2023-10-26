package edu.project1;

class DictionaryWordProvider implements WordProvider {
    private static final String[] DICTIONARY = {"okay", "hello", "goodbye", "thanks", "nope", "yeah"};

    @Override
    public char[] selectRandomWord() {
        return DICTIONARY[(int) (Math.random() * DICTIONARY.length)].toCharArray();
    }
}
