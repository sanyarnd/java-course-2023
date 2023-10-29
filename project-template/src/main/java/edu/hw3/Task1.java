package edu.hw3;

public class Task1 {
    private static final int lowerBoundForUpperCase = 65;
    private static final int upperBoundForUpperCase = 90;
    private static final int lowerBoundForLowerCase = 97;
    private static final int upperBoundForLowerCase = 122;

    private Task1() {

    }

    public static StringBuilder textEncryption(String text) {
        StringBuilder resultString = new StringBuilder();
        for (char c : text.toCharArray()) {
            char newChar = c;
            if ((c >= lowerBoundForUpperCase) && (c <= upperBoundForUpperCase)) {
                newChar = changingTheLetter(c, lowerBoundForUpperCase, upperBoundForUpperCase);
            }
            if ((c >= lowerBoundForLowerCase) && (c <= upperBoundForLowerCase)) {
                newChar = changingTheLetter(c, lowerBoundForLowerCase, upperBoundForLowerCase);
            }
            resultString.append(newChar);
        }
        return resultString;
    }

    private static char changingTheLetter(char letter, int lowerBound, int upperBound) {
        int distanceToTheUpperBound = upperBound - letter;
        int distanceToTheLowerBound = letter - lowerBound;
        int result = distanceToTheUpperBound - distanceToTheLowerBound;
        return  (char) (letter + result);
    }
}
