package edu.hw3.task1;

public class Atbash {
    private Atbash() {
    }

    public static String atbash(String s) {
        StringBuilder strBuild = new StringBuilder(s);
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            char nowChar = strBuild.charAt(i);
            if (nowChar >= 'a' && nowChar <= 'z') {
                strBuild.setCharAt(i, (char) ('z' - (nowChar - 'a')));
            } else if (nowChar >= 'A' && nowChar <= 'Z') {
                strBuild.setCharAt(i, (char) ('Z' - (nowChar - 'A')));
            }
        }
        return strBuild.toString();
    }
}
