package edu.hw5.task7;

import java.util.regex.Pattern;

public class SubsequenceValidatorForNumber {
    public static boolean containsAtLeastThreeCharsWithThirdZero(String str) {
        String regex = "^(0|1){2}0(0|1)*$";
        return Pattern.matches(regex, str);
    }

    public static boolean startsAndEndsWithSameChar(String str) {
        String regex = "^(0|1).*\\1$|^0$|^1$";
        return Pattern.matches(regex, str);
    }

    public static boolean lengthBetweenOneAndTree(String str) {
        String regex = "^(0|1){1,3}$";
        return Pattern.matches(regex, str);
    }
}
