package edu.hw1;

public class Task4 {
    private Task4() {

    }

    public static String fixString(String stringToFix) {
        char[] c = stringToFix.toCharArray();
        for (int i = 0; i < c.length - 1; i += 2) {
            char temp = c[i];
            c[i] = c[i + 1];
            c[i + 1] = temp;
        }
        return String.valueOf(c);
    }

}
