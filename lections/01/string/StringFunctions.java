package tinkoff.string;

import java.lang.reflect.Array;
import java.util.Arrays;

public class StringFunctions {
    public static void main(String[] args) {
        String str = "aabbbcdddd";

        System.out.println("Длина строки: " + str.length());

        System.out.println("Разделение по 'b': " + Arrays.toString(str.split("b")));

        System.out.println("Индекс 'bc': " + str.indexOf("bc"));

        System.out.println("Индекс 'e': " + str.indexOf("e"));

        System.out.println("Заменили 'b' на 'd': " + str.replace('b', 'd'));

        System.out.println("Массив чаров: " + Arrays.toString(str.toCharArray()));

        System.out.println("Сравнение без регистра: " + str.equalsIgnoreCase("AaBbBcDdDd"));

        System.out.println("Форматирование строк: " + "%s %s".formatted("Hello", "world"));
    }
}
