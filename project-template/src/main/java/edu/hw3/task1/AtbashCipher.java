package edu.hw3.task1;

public class AtbashCipher {
    public static String encrypt(String text) {
        StringBuilder result = new StringBuilder();

        result = reverseLetter(text, result);

        return result.toString();
    }

    public static StringBuilder reverseLetter(String text, StringBuilder result){
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char encryptedChar;
                if (Character.isUpperCase(c)) {
                    encryptedChar = (char) ('Z' - (c - 'A'));
                } else {
                    encryptedChar = (char) ('z' - (c - 'a'));
                }
                result.append(encryptedChar);
            } else {
                result.append(c);
            }
        }

        return result;
    }
}
