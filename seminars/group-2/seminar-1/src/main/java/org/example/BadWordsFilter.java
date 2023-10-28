package org.example;

public class BadWordsFilter implements MessageFilter {

    private static final boolean MESSAGE_BAD_WORDS_FILTER_ENABLE = true;

    @Override
    public boolean filter(Message message) {
        if (!MESSAGE_BAD_WORDS_FILTER_ENABLE) {
            return true;
        }
        String[] badWords = new String[] {"бомба, расизм, убийство"};
        String[] allWords = message.getBody().split(" ");
        for (var word : allWords) {
            for (var badWord : badWords) {
                if (word.contains(badWord)) {
                    return false;
                }
            }
        }
        return true;
    }
}
