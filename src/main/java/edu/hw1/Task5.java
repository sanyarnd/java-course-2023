package edu.hw1;

public final class Task5 {
    private Task5() {
    }

    public static String fixString(String input) {
        char[] characters = input.toCharArray();
        for (int i = 0; i < characters.length - 1; i += 2) {
            char temp = characters[i];
            characters[i] = characters[i + 1];
            characters[i + 1] = temp;
        }
        return new String(characters);
    }
}
