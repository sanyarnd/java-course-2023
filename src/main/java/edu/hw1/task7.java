package edu.hw1;

public class task7 {
    public static int rotateLeft(int n, int shift) {
        String s = Integer.toBinaryString(n);
        int len = s.length();
        shift %= len;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < len; ++i) {
            ans.append(s.charAt((i + shift) % len));
        }
        return Integer.parseInt(ans.toString(), 2);
    }

    public static int rotateRight(int n, int shift) {
        String s = Integer.toBinaryString(n);
        int len = s.length();
        shift %= len;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < len; ++i) {
            if (i - shift < 0) {
                ans.append(s.charAt(len + (i - shift)));
            } else {
                ans.append(s.charAt(i - shift));
            }
        }
        return Integer.parseInt(ans.toString(), 2);
    }
}
