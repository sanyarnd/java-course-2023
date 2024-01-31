package tinkoff.finalvarstatic;

import java.util.LinkedList;
import java.util.List;

public class Final {
    public static void main(String[] args) {
        final int a = 1;
/*
        a = 2; Для примитивов значение
 */


        final int[] ints = new int[3];
        ints[0] = 1;
        ints[1] = 2;
        ints[2] = 3;
/*
        ints = new int[5]; Нельзя менять ссылку
 */


        final List<Integer> ints2 = new LinkedList<>();
        ints2.add(1);
        ints2.add(2);
        ints2.add(3);
/*
        ints = new LinkedList<>(); Нельзя менять ссылку
 */
    }
}
