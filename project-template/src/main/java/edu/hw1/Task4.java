package edu.hw1;

public class Task4 {
    public static String fixString(String s) {
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length - 1; i += 2) {
            char temp = c[i];
            c[i] = c[i + 1];
            c[i + 1] = temp;
        }
        StringBuilder result = new StringBuilder();
        for (char value : c) {
            result.append(value);
        }
        System.out.println(result);
        return result.toString();
    }

}
