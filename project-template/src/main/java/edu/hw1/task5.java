package edu.hw1;

public class task5 {
    public static boolean isPalindromeDescendant(int number){
        String numberString = String.valueOf(number);
        while(numberString.length() > 1){
            int left = 0;
            int right = numberString.length() - 1;
            int cnt = 0;

            while (left < right) {
                if (numberString.charAt(left) == numberString.charAt(right)) {
                    cnt++;
                }
                left++;
                right--;
            }

            if(cnt == numberString.length() / 2){
                return true;
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < numberString.length() - 1; i+=2) {
                int digit1 = Character.getNumericValue(numberString.charAt(i));
                int digit2 = Character.getNumericValue(numberString.charAt(i + 1));
                sb.append(digit1 + digit2);
            }

            numberString = sb.toString();
        }
        return false;
    }
}
