package edu.hw1;

import java.util.logging.Logger;

@SuppressWarnings({"uncommentedmain", "checkstyle:magicnumber"})
public final class Task8 {
    private Task8() {
    }

    private static final Logger LOGGER = Logger.getLogger(Task8.class.getName());

    public static int numberOfBits(int n) {
        return (int) (Math.log(n) / Math.log(2)) + 1;
    }

    public static int rotateRight(int n, int sh) {
        int shift = sh;
        int numBits = numberOfBits(n);
        shift %= 32;
        return (n >>> shift) | (n << (numBits - shift)) & ((1 << numBits) - 1);
    }

    public static int rotateLeft(int n, int sh) {
        int shift = sh;
        int numBits = numberOfBits(n);
        shift %= 32; // убедимся, что сдвиг находится в пределах 32 бит
        return (n << shift & ((1 << numBits) - 1)) | (n >> (numBits - shift));
    }

    public static void main(String[] args) {
        LOGGER.info(String.valueOf(rotateRight(8, 1)));  // 4

    }
}

