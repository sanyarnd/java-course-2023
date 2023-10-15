package org.lisi4ka.tasks;

import java.util.Objects;

public class Task5 {
    public static Boolean task5(String inputs){
        String[] input = inputs.split("");
        while (input.length > 1){
            if (isPalindrome(input)){
                return true;
            }
            input = newPalindrome(input);
        }
        return false;
    }
    private static boolean isPalindrome(String[] input){
        for (int i = 0; i*2 < input.length; i++){
            if (!Objects.equals(input[i], input[input.length - i - 1])){
                return false;
            }
        }
        return true;
    }
    private static String[] newPalindrome(String[] input){
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < input.length; i+= 2){
            try {
                res.append(Integer.parseInt(input[i]) + Integer.parseInt(input[i + 1]));
            } catch(ArrayIndexOutOfBoundsException ex){
                res.append(Integer.parseInt(input[i-1]) + Integer.parseInt(input[i]));
            }
        }
        return res.toString().split("");
    }
}
