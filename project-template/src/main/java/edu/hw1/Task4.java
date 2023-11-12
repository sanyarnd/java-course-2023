package edu.hw1;

public class Task4 {
    public static char[] fixString(char[] str) {
        if (str.length % 2 == 0) {
            for (int i = 0; i < str.length; i += 2) {
                char tmp = str[i];
                str[i] = str[i + 1];
                str[i + 1] = tmp;
            }
        } else {
            for (int i = 0; i < str.length - 1; i += 2) {
                char tmp = str[i];
                str[i] = str[i + 1];
                str[i + 1] = tmp;
            }
        }
        return str;
    }
}
