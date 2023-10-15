package edu.hw1;

public class Task7 {
    public static String toBinaryString(int n) {
        return String.format("%32s", Integer.toBinaryString(n)).replaceAll(" ", "0");
    }
    private Task7() {
    }

    public static int rotateLeft(int n, int k) {
        int mask = (1 << 5) - 1;
        int leftPart = (n << k) & mask;
        int rightPart = (n >> (5 - k)) & mask;
        return leftPart | rightPart;
    }

    public static int rotateRight(int n, int k) {
        int mask = (1 << 5) - 1;
        int leftPart = (n << (5 - k)) & mask;
        int rightPart = (n >> k) & mask;
        return leftPart | rightPart;
    }

}
