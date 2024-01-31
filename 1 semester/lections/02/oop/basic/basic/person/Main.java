package tinkoff2.oop.basic.basic.person;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Character[] a = new Character[] {1, 2, 3, 4};
        Arrays.sort(a, Comparator.reverseOrder());
    }
}
