package edu.hw1;

import java.util.BitSet;

public class Task7 {
    static final String negNumExceptMsg = "Given number must be non-negative";

    private Task7() {
    }

//    public static void main(String[] args) {}

    public static int rotateRight(int number, int shift) throws IllegalArgumentException {
        if (number < 0) {
            throw new IllegalArgumentException(negNumExceptMsg);
        }

        if (shift < 0) {
            rotateLeft(number, shift * -1);
        }

        BitSet bitSetInit = BitSet.valueOf(new long[] {number});
        int numbBitLen = bitSetInit.length();
        BitSet bitSetRes = new BitSet(numbBitLen);

        for (int i = 0; i < numbBitLen; ++i) {
            int newBitPos = numbBitLen - (i + shift) % numbBitLen - 1;
            bitSetRes.set(newBitPos, bitSetInit.get(numbBitLen - i - 1));
        }

        return (int) (bitSetRes.length() == 0 ? 0 : bitSetRes.toLongArray()[0]);
    }

    public static int rotateLeft(int number, int shift) throws IllegalArgumentException {
        if (number < 0) {
            throw new IllegalArgumentException(negNumExceptMsg);
        }

        if (shift < 0) {
            rotateRight(number, shift * -1);
        }

        BitSet bitSetInit = BitSet.valueOf(new long[] {number});
        int numbBitLen = bitSetInit.length();
        BitSet bitSetRes = new BitSet(numbBitLen);

        for (int i = 0; i < numbBitLen; ++i) {
            int newBitPos = (i + shift) % numbBitLen;
            bitSetRes.set(newBitPos, bitSetInit.get(i));
        }

        return (int) (bitSetRes.length() == 0 ? 0 : bitSetRes.toLongArray()[0]);
    }
}
