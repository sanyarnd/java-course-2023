package edu.hw1;

public final class Task2 {
    private Task2() {

    }

    private static final int BASE = 10;

    public static int countDigits(int num) {
        int number = num;
        if (number == 0) {
            return 1; // если число равно 0, то у него 1 цифра
        }

        int count = 0;
        while (number != 0) {
            number = number / BASE; // делаем число меньше на один разряд
            count++; // увеличиваем счетчик цифр
        }

        return count;
    }
}
