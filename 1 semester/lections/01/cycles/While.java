package tinkoff.cycles;

public class While {
    public static void main(String[] args) {
/*
        while (Любое условие) {

        }
 */

        int a = 100;
        int n = 1;
        while (n < a) {
            n *= 2;
        }

        System.out.println(n);

        do {
            n *= 2;
        } while (n < a);

        System.out.println(n);
    }
}
