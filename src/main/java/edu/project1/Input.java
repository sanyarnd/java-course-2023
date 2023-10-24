package edu.project1;

import java.util.Scanner;

public class Input {
    private Input() {
    }

    public static String input() {
        Output.waitWordOrLetter();
        Scanner console = new Scanner(System.in);
        String s = console.nextLine().replaceAll("\\r\\n", "").toLowerCase();
        int n = s.length();
        if (n == 1) {
            char c = s.charAt(0);
            if (Check.checkSim(c)) {
                return s;
            } else {
                Output.incorrectSim();
                input();
            }
        } else {
            if (Check.checkWord(s) || Check.checkMenu(s)) {
                return s;
            } else {
                Output.incorrectWord();
                input();
            }
        }
        return "";
    }

    public static boolean inputNext() {
        Scanner console = new Scanner(System.in);
        return console.nextLine().equals("продолжить");
    }

}
