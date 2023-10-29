package edu.hw3;

public class Task4 {
    private static final String[] keys = new String[] {"M", "CM", "D", "CD", "C", "XC",
        "L", "XL", "X", "IX", "V", "IV", "I" };
    private static final int[] values = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

    private Task4() {

    }

    public static StringBuilder convertToRoman(int number) {
        if (number <= 0) {
            return new StringBuilder("-1");
        }
        StringBuilder result = new StringBuilder();
        int index = 0;

        while (index < keys.length) {
            while (number >= values[index]) {
                var divider = number / values[index];
                number = number % values[index];
                result.append(keys[index].repeat(divider));
            }
            index = index + 1;
        }
        return result;
    }
}
