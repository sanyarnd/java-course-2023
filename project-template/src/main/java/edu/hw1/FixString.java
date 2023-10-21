package edu.hw1;

public class FixString {
    public static String incorrectString(String input){
        if (input.length() <= 1)
            return input;

        var s = new StringBuilder();

        for(int i = 0; i < input.length(); i += 2){
            if (i +1 < input.length())
                s.append(input.charAt(i + 1));
            s.append(input.charAt(i));
        }

        return s.toString();
    }
}
