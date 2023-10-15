package edu.hw1;

public class Task5 {
    public static boolean isPalindromeDescendant(int number) {
        StringBuilder num = new StringBuilder(Integer.toString(number));
        StringBuilder reverseNumber = new StringBuilder();

        while (num.length() > 1) {
            reverseNumber = new StringBuilder(num);
            if ((num.toString()).equals(reverseNumber.reverse().toString()))
                return true;

            StringBuilder descendant = new StringBuilder();
            for (int i = 0; i < num.length() - 1; i += 2) {
                descendant.append(Character.getNumericValue(num.charAt(i))
                    + Character.getNumericValue(num.charAt(i + 1)));
            }
            if (num.length() % 2 == 1) {
                descendant.append(num.charAt(num.length() - 1));
            }
            num = descendant;
        }
        return false;
    }
}
