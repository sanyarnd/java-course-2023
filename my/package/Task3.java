package edu.hw1;
import java.util.Scanner;
public class Task3 {
    public static boolean isNestable(int[] a1, int[] a2) {
        int min1 = a1[0];
        int min2 = a2[0];
        int max1 = a1[0];
        int max2 = a2[0];
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] == -1) {break;}
            else{
                if (a1[i] < min1) {
                    min1 = a1[i];
                }
                if (a1[i] > max1) {
                    max1 = a1[i];
                }
            }
        }
        for (int j = 0; j < a2.length; j++) {
            if (a2[j] == -1) {break;}
            else
            {
                if (a2[j] < min2) {
                    min2 = a2[j];
                }
                if (a2[j] > max2) {
                    max2 = a2[j];
                }
            }
        }
        return (min1 > min2) && (max1 < max2);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите массив 1. Введите -1, чтобы завершить ввод.");
        int[] a1 = new int[1600];
        int elem1 = 0;
        int i1 = 0;
        while ((elem1 = scanner.nextInt()) != -1) {
            a1[i1] = elem1;
            i1++;
        }
        int[] na1 = new int[i1];
        System.arraycopy(a1, 0, na1, 0, i1);
        System.out.println("Введите массив 2. Введите -1, чтобы завершить ввод.");
        int[] a2 = new int[1600];
        int elem2 = 0;
        int j1 = 0;
        while ((elem2 = scanner.nextInt()) != -1) {
            a2[j1] = elem2;
            j1++;
        }
        int[] na2 = new int[j1];
        System.arraycopy(a2, 0, na2, 0, j1);
        System.out.println(isNestable(na1, na2));
    }
}
