package homework3;

public class Task4 {
    public static String convertToRoman(int num) {
        if (num <= 0 || num > 3999) {
            return "Invalid input";
        }

        String[] romanSymbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] arabicValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder result = new StringBuilder();

        int i = 0;
        while (num > 0) {
            if (num >= arabicValues[i]) {
                result.append(romanSymbols[i]);
                num -= arabicValues[i];
            } else {
                i++;
            }
        }

        return result.toString();
    }
}
