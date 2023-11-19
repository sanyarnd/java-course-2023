package edu.hw5.task6;

import java.util.regex.Pattern;

public class SubsequenceValidator {
    public static boolean isSubsequence(String sub, String str) {
        String regex = ".*" + sub + ".*";
        return Pattern.matches(regex, str);
    }
}
