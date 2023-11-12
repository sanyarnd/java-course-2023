package edu.hw3.task4;

@SuppressWarnings("MagicNumber")
public class RomanNumerals {
    public static String getRomanNumber(int num) {
        var keys = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        var vals = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder newRomanNumber = new StringBuilder();
        int id = 0;

        while (id < keys.length) {
            while (num >= vals[id]) {
                var d = num / vals[id];
                num = num % vals[id];
                for (int i = 0; i < d; i++) {
                    newRomanNumber.append(keys[id]);
                }
            }
            id++;
        }

        return newRomanNumber.toString();
    }
}
