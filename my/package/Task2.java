package edu.hw1;
import java.util.Scanner;

public class Task2 {
    public static int countDigits(int a) {
        if (a == 0) {return 1;}
        int b = 0;
        int temp = a;
      while (temp != 0)
      {
b++;
temp = temp/10;
      }
        return b;
    }
    public static void main (String[] args)
    {
        System.out.println("Введите целое число: ");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        scanner.close();
        System.out.println(countDigits(x));
    }
}
