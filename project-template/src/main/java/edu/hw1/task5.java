package edu.hw1;

public class task5 {
    public static boolean isPalindrome(String x) {
        int n = x.length();
        StringBuilder s = new StringBuilder();
        for (int i = n - 1; i > -1; --i) {
            s.append(x.charAt(i));
        }
        return x.contentEquals((s));
    }

    public static String newPalindrome(String x) {
        int n = x.length();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n - 1; i += 2) {
            ans.append(Integer.toString(Integer.parseInt(String.valueOf(x.charAt(i)))
                + Integer.parseInt(String.valueOf(x.charAt(i + 1)))));
        }
        if (n % 2 == 1) {
            ans.append(x.charAt(n - 1));
        }
        return ans.toString();
    }

    public static boolean isPalindromeDescendant(long num) {
        String x = Long.toString(num);
        while (!isPalindrome(x)) {
            x = newPalindrome(x);
            if (x.length() == 1) {
                return false;
            }
        }
        return true;
    }
}
