package edu.hw1;

public final class Task7 {
    private Task7() {
    }

    private static final int BITS = 32;

    private static int numberOfBits(int n) {
        return (int) (Math.log(n) / Math.log(2)) + 1;
    }

    public static int rotateRight(int number, int sh) { // циклический сдвиг числа вправо
        int shift = sh;
        int numBits = numberOfBits(number);
        shift %= BITS;
        return (number >>> shift) | (number << (numBits - shift)) & ((1 << numBits) - 1);
    }

    public static int rotateLeft(int number, int sh) { // циклический сдвиг числа влево
        int shift = sh;
        int numBits = numberOfBits(number);
        shift %= BITS; // убедимся, что сдвиг находится в пределах 32 бит
        return (number << shift & ((1 << numBits) - 1)) | (number >> (numBits - shift));
    }

}

