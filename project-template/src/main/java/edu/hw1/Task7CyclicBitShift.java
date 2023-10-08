package edu.hw1;

import static java.lang.Math.pow;

final class Task7CyclicBitShift {
    private Task7CyclicBitShift() {
    }

    public static int getHighBit(int value) {
        int pos = 0;
        while ((int) pow(2, pos) <= value) {
            pos++;
        }
        return pos - 1;
    }

    public static int rotateLeft(int originalValue, int originalShift) {
        int value = originalValue;
        int shift = originalShift;

        if (value < 1 || shift < 0) {
            return -1;
        }
        if (value == 1) {
            return 1;
        }

        int numberHighBit = getHighBit(value);
        int valueHighBit = (int) pow(2, numberHighBit);

        int ones = (valueHighBit << 1) - 1;

        if (shift == 0 || value - ones == 0) {
            return value;
        }

        if (shift >= (numberHighBit + 1)) {
            shift %= (numberHighBit + 1);
        }

        valueHighBit <<= 1;

        for (int i = 0; i < shift; i++) {
            value <<= 1;

            if ((value & valueHighBit) == valueHighBit) {
                value &= ones;
                value += 1;
            }
        }

        return value;
    }

    public static int rotateRight(int originalValue, int originalShift) {
        int value = originalValue;
        int shift = originalShift;

        if (value < 1 || shift < 0) {
            return -1;
        }
        if (value == 1) {
            return 1;
        }

        int numberHighBit = getHighBit(value);
        int valueHighBit = (int) pow(2, numberHighBit);

        int ones = (valueHighBit << 1) - 1;

        if (shift == 0 || value - ones == 0) {
            return value;
        }

        if (shift >= (numberHighBit + 1)) {
            shift %= (numberHighBit + 1);
        }

        for (int i = 0; i < shift; i++) {
            if ((value & 1) == 1) {
                value >>= 1;
                value += valueHighBit;
            } else {
                value >>= 1;
            }
        }

        return value;
    }
}
