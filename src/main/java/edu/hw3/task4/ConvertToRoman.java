package edu.hw3.task4;

public class ConvertToRoman {
    private ConvertToRoman() {
    }

    private static final int[] CONST = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000, 3999};

    public static String convertToRoman(Integer number) {
        int input = number;
        int pos = CONST.length - 1;
        if (input < CONST[0] || input > CONST[pos]) {
            return "Invalid Roman Number Value";
        }
        pos--;
        StringBuilder s = new StringBuilder();
        while (input >= CONST[pos]) {
            s.append("M");
            input -= CONST[pos];
        }
        pos--;
        while (input >= CONST[pos]) {
            s.append("CM");
            input -= CONST[pos];
        }
        pos--;
        while (input >= CONST[pos]) {
            s.append("D");
            input -= CONST[pos];
        }
        pos--;
        while (input >= CONST[pos]) {
            s.append("CD");
            input -= CONST[pos];
        }
        pos--;
        while (input >= CONST[pos]) {
            s.append("C");
            input -= CONST[pos];
        }
        pos--;
        while (input >= CONST[pos]) {
            s.append("XC");
            input -= CONST[pos];
        }
        pos--;
        while (input >= CONST[pos]) {
            s.append("L");
            input -= CONST[pos];
        }
        pos--;
        while (input >= CONST[pos]) {
            s.append("XL");
            input -= CONST[pos];
        }
        pos--;
        while (input >= CONST[pos]) {
            s.append("X");
            input -= CONST[pos];
        }
        pos--;
        while (input >= CONST[pos]) {
            s.append("IX");
            input -= CONST[pos];
        }
        pos--;
        while (input >= CONST[pos]) {
            s.append("V");
            input -= CONST[pos];
        }
        pos--;
        while (input >= CONST[pos]) {
            s.append("IV");
            input -= CONST[pos];
        }
        pos--;
        while (input >= CONST[pos]) {
            s.append("I");
            input -= CONST[pos];
        }
        return s.toString();
    }
}
