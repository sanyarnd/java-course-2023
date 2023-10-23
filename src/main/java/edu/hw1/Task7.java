package edu.hw1;

public class Task7 {
    private Task7() {
    }

    public static int rotateLeft(int n, int shift) {
        String s = Integer.toBinaryString(n);
        int len = s.length();
        int newShift = shift % len;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < len; ++i) {
            ans.append(s.charAt((i + newShift) % len));
        }
        return Integer.parseInt(ans.toString(), 2);
    }

    public static int rotateRight(int n, int shift) {
        String s = Integer.toBinaryString(n);
        int len = s.length();
        int newShift = shift % len;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < len; ++i) {
            if (i - newShift < 0) {
                ans.append(s.charAt(len + (i - newShift)));
            } else {
                ans.append(s.charAt(i - newShift));
            }
        }
        return Integer.parseInt(ans.toString(), 2);
    }
}
