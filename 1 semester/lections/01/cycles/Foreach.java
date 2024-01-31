package tinkoff.cycles;

public class Foreach {
    public static void main(String[] args) {
/*
        for(тип имя : итерируемая сущность) {

        }
 */
        int[] v = new int[6];
        for(int el : v) {
            System.out.print(el + ", ");
        }

        System.out.println();
        System.out.println();


        int[][] m = new int[][] {
                {1, 2},
                {3, 4, 5, 6},
                {7, 8, 9}
        };

        for(int[] vTemp : m) {
            for(int el : vTemp) {
                System.out.print(el + ", ");
            }
            System.out.println();
        }
    }
}
