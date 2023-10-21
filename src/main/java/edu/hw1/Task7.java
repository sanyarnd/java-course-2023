package edu.hw1;

public class Task7 {
    public static int rotateLeft(int n, int shift) {
        int log2 = (int) (Math.log(n) / Math.log(2));
        shift = shift % log2;
        int mask = (int) Math.pow(2, log2 + 1) - 1;

        int part1 = (n << shift) & mask;
        int part2 = (n >>> (((int) (Math.log(n) / Math.log(2)) - shift + 1)));

        return part1 | part2;
    }

    public static int rotateRight(int n, int shift) {
        int log2 = (int) (Math.log(n) / Math.log(2));
        shift = shift % log2;
        int mask = (int) Math.pow(2, log2 + 1) - 1;

        int part1 = n >> shift;
        int part2 = (n << (((int) (Math.log(n) / Math.log(2)) - shift + 1))) & mask;

        return part1 | part2;
    }
}
