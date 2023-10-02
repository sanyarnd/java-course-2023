package tinkoff.finalvarstatic;

import java.util.LinkedList;
import java.util.List;

public class Static {
    public static void main(String[] args) {
        Example example1 = new Example();
        Example example2 = new Example();
        example1.x = 2;
        example2.x = 3;

        System.out.println(example1.x);
        System.out.println(example2.x);

        System.out.println();

        example1.common = 2;
        example2.common = 3;

        System.out.println(example1.common);
    }
}
