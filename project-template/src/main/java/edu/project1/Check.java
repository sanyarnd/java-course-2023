package edu.project1;

public class Check {
    public static boolean checkSim(char x){
        return x >= 'а' && x <= 'я';
    }

    public static boolean checkMenu(String s){
        return s.equals("меню") || s.equals("закончить") || s.equals("начало") || s.equals("правила");
    }

    public static boolean checkWord(String s) {
        boolean ans = false;
        int n = s.length();
        for (int i = 0; i < n; ++i) ans = s.charAt(i) < 'а' || s.charAt(i) > 'я';
        return !ans && n == 5;
    }
}
