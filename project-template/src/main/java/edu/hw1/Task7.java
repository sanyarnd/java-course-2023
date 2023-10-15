package edu.hw1;

public class Task7 {
    public static int rotateLeft(int n, int shift) {
        int length = 0;
        n = Integer.parseInt(Integer.toBinaryString(n));
        int temp = n;
        while (temp != 0) {
           temp = temp / 10;
           length = length + 1;
        }
        int[] arr = new int[length];
        temp = n;
        for (int j=length-1;j>=0;j--) {
            arr[j] = temp % 10;
            temp = temp / 10;
        }

        for (int i=0;i<shift;i++) {
            int firstDigit = arr[0];
            for (int j=0;j<length-1;j++) {
                arr[j] = arr[j+1];
            }
            arr[length-1] = firstDigit;
        }

        int result = 0;
        int k = 0;
        for (int i=length-1;i>=0;i--) {
            result = (int) (result + arr[i]*Math.pow(2, k));
            k = k + 1;
        }
        System.out.println(result);
        return result;
    }

    public static int rotateRight(int n, int shift) {
        int length = 0;
        n = Integer.parseInt(Integer.toBinaryString(n));
        int temp = n;
        while (temp != 0) {
            temp = temp / 10;
            length = length + 1;
        }
        int[] arr = new int[length];
        temp = n;
        for (int j=length-1;j>=0;j--) {
            arr[j] = temp % 10;
            temp = temp / 10;
        }

        for (int i=0;i<shift;i++) {
            int lastDigit = arr[length-1];
            for (int j=length-1;j>0;j--) {
                arr[j] = arr[j-1];
            }
            arr[0] = lastDigit;
        }

        int result = 0;
        int k = 0;
        for (int i=length-1;i>=0;i--) {
            result = (int) (result + arr[i]*Math.pow(2, k));
            k = k + 1;
        }
        System.out.println(result);
        return result;
    }
}
