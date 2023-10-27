package edu.hw1;

public class Task7 {
    public static int rotateLeft(int n, int shift) {
        String bits = Integer.toBinaryString(n);
        String toShift = bits.substring(shift) + bits.substring(0, shift);

        return Integer.parseInt(toShift, 2);
    }

    public static int rotateRight(int n, int shift) {
        String bits = Integer.toBinaryString(n);
        String toShift = bits.substring(bits.length() - shift) + bits.substring(0, bits.length() - shift);

        return Integer.parseInt(toShift, 2);
    }
}
