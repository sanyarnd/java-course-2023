package edu.hw3.task2;

import java.util.ArrayList;

public class Clusterize {
    private Clusterize() {
    }

    public static ArrayList<String> clusterize(String s) {
        ArrayList<String> ans = new ArrayList<>();
        int n = s.length();
        if (!checkPSP(s)) {
            ans.add("ERROR");
            return ans;
        }
        StringBuilder strNow = new StringBuilder();
        int bal = 0;
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '(') {
                bal++;
            } else {
                bal--;
            }
            strNow.append(s.charAt(i));
            if (bal == 0) {
                ans.add(strNow.toString());
                strNow = new StringBuilder();
            }
        }
        return ans;
    }

    private static boolean checkPSP(String s) {
        int n = s.length();
        int bal = 0;
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '(') {
                bal++;
            } else {
                bal--;
            }
            if (bal < 0) {
                break;
            }
        }
        return bal == 0;
    }
}
