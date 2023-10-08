package edu.hw1;

public final class Task8 {
    private Task8() {
    }

    private static final int BITS = 32;

    public static int numberOfBits(int n) {
        return (int) (Math.log(n) / Math.log(2)) + 1;
    }

    public static int rotateRight(int n, int sh) { // циклический сдвиг числа вправо
        int shift = sh;
        int numBits = numberOfBits(n);
        shift %= BITS;
        return (n >>> shift) | (n << (numBits - shift)) & ((1 << numBits) - 1);
    }

    public static int rotateLeft(int n, int sh) { // циклический сдвиг числа влево
        int shift = sh;
        int numBits = numberOfBits(n);
        shift %= BITS; // убедимся, что сдвиг находится в пределах 32 бит
        return (n << shift & ((1 << numBits) - 1)) | (n >> (numBits - shift));
    }

}

