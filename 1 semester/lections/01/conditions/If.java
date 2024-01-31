package tinkoff.conditions;

public class If {
    public static void main(String[] args) {
/*
        if (Любое условие) {

        } else if (Другое условие) {

        } else {

        }
*/

        int a = 3;
        int b = 5;
        int c;
        if (a < b) {
            c = a;
        }  else {
            c = b;
        }

        // Тернарный оператор - expression => можно присвоить результат
        c = (a < b) ? a : b;
    }
}
