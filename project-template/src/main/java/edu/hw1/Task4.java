package edu.hw1;

public class Task4 {
    private Task4() {
    }
    public static String fixString(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length - 1; i += 2) {
            char temp = chars[i];
            chars[i] = chars[i + 1];
            chars[i + 1] = temp;
        }
        return new String(chars);
    }
}

