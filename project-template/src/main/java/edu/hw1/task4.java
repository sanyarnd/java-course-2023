package edu.hw1;

public class task4 {
    public static String fixString(String s) {
        int n = s.length();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i += 2) {
            if (i + 1 == n) {
                ans.append(s.charAt(i));
                break;
            }
            ans.append(s.charAt(i + 1));
            ans.append(s.charAt(i));
        }
        return ans.toString();
    }
}
