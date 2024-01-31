package tinkoff2.oop.classes.statics;

public class Main {
    public static void main(String[] args) {
        Math.Factorial fact = Math.getFactorial(6);
        System.out.printf("Факториал числа %d равен %d \n", fact.getKey(), fact.getResult());
    }
}
