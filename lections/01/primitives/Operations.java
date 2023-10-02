package tinkoff.primitives;

public class Operations {
    public static void main(String[] args) {
        int num1 = 13; // = 1101
        int num2 = 9;  // = 1001

        System.out.println(num1 + num2);
        System.out.println(num1 - num2);
        System.out.println(num1 * num2);
        System.out.println(num1 / num2);
        System.out.println(num1 % num2);

        System.out.println();

        System.out.println(num1 & num2);
        System.out.println(num1 | num2);
        System.out.println(num1 ^ num2);
        System.out.println(~num1);

        System.out.println();

        System.out.println(num1 == num2);
        System.out.println(num1 < num2);
        System.out.println(num1 > num2);
        System.out.println(num1 <= num2);
        System.out.println(num1 >= num2);
        System.out.println(num1 != num2);
    }
}
