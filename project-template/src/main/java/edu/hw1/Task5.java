package edu.hw1;

public class Task5 {
    private Task5() {
    }

//    public static void main(String[] args) {}

    public static boolean isPalindromeDescendant(int number) {
        String numStr = String.valueOf(number);

        if (checkPalindrome(numStr)) {
            return true;
        }

        // непонятно, какой должна быть пара для числа с нечетным кол-ом цифр
        while (numStr.length() % 2 == 0) {
            numStr = getDescendantNumStr(numStr);
            if (numStr.length() > 1 && checkPalindrome(numStr)) {
                return true;
            }
        }

        return false;
    }

    public static String getDescendantNumStr(String numStr) {
        StringBuilder descendantNumStr = new StringBuilder();

        for (int i = 0; i < numStr.length() - 1; i += 2) {
            int digit1 = Character.getNumericValue(numStr.charAt(i));
            int digit2 = Character.getNumericValue(numStr.charAt(i + 1));
            int sum = digit1 + digit2;
            descendantNumStr.append(sum);
        }

        return descendantNumStr.toString();
    }

    public static boolean checkPalindrome(String numStr) {
        return numStr.equals(new StringBuilder(numStr).reverse().toString());
    }
}
