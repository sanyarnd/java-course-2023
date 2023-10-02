package tinkoff.primitives;

public class TypeFunctions {
    public static void main(String[] args) {
        Integer num1 = 130;
        Integer num2 = 130;
        Integer num3 = 9;

        double d = num1.doubleValue();
        short s = num1.shortValue();

        System.out.println(num1.equals(num3));
        System.out.println(num1.equals(num2));

        System.out.println();

        System.out.println(num1 == num3);
        System.out.println(num1 == num2);
    }
}
