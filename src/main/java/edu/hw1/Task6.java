package edu.hw1;

import java.util.Arrays;

public class Task6 {
    private Task6() {
    }

    public static int k(int x) {
        var d = (Integer.toString(x)).toCharArray();
        Arrays.sort(d);
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        for (char i : d) {
            s1.append(i);
        }
        for (int i = s1.length() - 1; i > -1; --i) {
            s2.append(s1.charAt(i));
        }
        return Integer.parseInt(s2.toString()) - Integer.parseInt(s1.toString());
    }

    final static int MAGICNUM = 6174;

    public static int countK(int x) {
        if (x == MAGICNUM) {
            return 0;
        }
        return countK(k(x)) + 1;
    }
}
