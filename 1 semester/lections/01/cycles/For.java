package tinkoff.cycles;

public class For {
    public static void main(String[] args) {

/*
        for ( Перед циклом ; Условие итерации ; После итерации ) {

        }
*/

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                continue;
            }
            System.out.println(i);
        }

        for (int i = 1; i < 10; i++) {
            if (i % 6 == 0) {
                break;
            }
            System.out.println(i);
        }
    }
}
