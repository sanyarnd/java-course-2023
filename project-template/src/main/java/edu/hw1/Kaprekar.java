package edu.hw1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Kaprekar {

    public static int countK(int a){
        if (a == 6174)
            return 0;

        List<Integer> digits = new ArrayList<>(
            Integer.
                toString(a).
                chars().
                map(Character::getNumericValue).
                boxed().
                sorted().
                toList()
        );
        Optional<Integer> inc = digits.stream().reduce((r, s) -> 10*r + s);
        Collections.reverse(digits);
        Optional<Integer> dec = digits.stream().reduce((r, s) -> 10*r + s);
        return countK(dec.get() - inc.get()) + 1;
    }
}
