package edu.hw1;

public class Task4 {
    public static String fixString(String str) {
        StringBuilder result = new StringBuilder();
        char buffer = str.charAt(0);

        for (int i = 1; i < str.length(); i++) {
            if (i % 2 == 0) {
                result.append(buffer);
                buffer = str.charAt(i);
            } else {
                result.append(str.charAt(i));
            }
        }
        result.append(buffer);

        return result.toString();
    }
}
