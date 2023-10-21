package edu.hw1;

import java.util.ArrayList;
import java.util.List;

public class Rotator {
    public static int rotateRight(int a, int shift){
        List<Integer> digits = new ArrayList<>(
            Integer.
                toBinaryString(a).
                chars().
                boxed().
                map(Character::getNumericValue).
                toList()
        );
        int result = 0;
        int cur_power = digits.size() - (shift % digits.size());
        for(int i = 0; i < digits.size(); i+= 1){
            cur_power -=  1;
            if (cur_power < 0)
                cur_power = digits.size() - 1;

            if (digits.get(i) == 1)
                result += Math.pow(2,cur_power);
        }
        return result;
    }

    public static int rotateLeft(int a, int shift){
        return rotateRight(a, Integer.toBinaryString(a).length() - (shift % Integer.toBinaryString(a).length()));
    }
}
