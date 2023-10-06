package edu.hw1;

import java.util.ArrayList;
import java.util.Collections;

@SuppressWarnings("HideUtilityClassConstructor")
public class Task7 {
    static public int rotateRight(int n, int shift) {
        if (shift < 0) {
            return -1;
        }
        int len = 0;
        int buf = n;
        ArrayList<Integer> binaryView = new ArrayList<>();
        while (buf > 0) {
            len += 1;
            binaryView.add(buf % 2);
            buf /= 2;
        }
        Collections.reverse(binaryView);
        int cycleMove = shift % len;
        buf = 0;
        int degreeTwo = len - 1;
        for (int i = len - cycleMove; i < len; i++) {
            buf = buf + binaryView.get(i) * ((int) Math.pow(2, degreeTwo));
            degreeTwo -= 1;
        }
        for (int i = 0; i < len; i++) {
            buf = buf + binaryView.get(i) * ((int) Math.pow(2, degreeTwo));
            degreeTwo -= 1;
        }
        return buf;
    }

    static public int rotateLeft(int n, int shift) {
        int len = 0;
        int buf = n;
        ArrayList<Integer> binaryView = new ArrayList<>();
        while (buf > 0) {
            len += 1;
            binaryView.add(buf % 2);
            buf /= 2;
        }
        binaryView.reversed();
        int cycleMove = shift % len;
        buf = 0;
        for (int i = 0; i < binaryView.size(); i++) {
            buf = buf + binaryView.get((2 * len - cycleMove + i) % len) * ((int) Math.pow(2, i));
        }
        return buf;
    }
}
