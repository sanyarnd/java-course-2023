package edu.hw1;

import java.util.ArrayList;
import java.util.Collections;
import static edu.hw1.Task5.delLast;
import static edu.hw1.Task5.getLast;
import static edu.hw1.Task5.movDischarge;

@SuppressWarnings("HideUtilityClassConstructor")
public class Task6 {
    public static int funK(int n) {
        @SuppressWarnings("MagicNumber")
        int thousandNum = 1000;
        if (n > thousandNum && n % thousandNum > 0) {
            return funK(n, 0);
        }
        return -1;
    }

    @SuppressWarnings("MagicNumber")
    public static int funK(int n, int cnt) {
        int secN = n;
        int finalNum = 6174;
        int needLength = 4;

        if (n == finalNum) {
            return cnt;
        }

        ArrayList<Integer> charsForN = new ArrayList<>();
        while (secN > 0) {
            charsForN.add(getLast(secN));
            secN = delLast(secN);
        }
        if (charsForN.size() < needLength) {
            while (charsForN.size() < needLength) {
                charsForN.add(0);
            }
        }
        Collections.sort(charsForN);
        int minNum = 0;
        int maxNum = 0;
        for (int i = 0; i < charsForN.size(); i++) {
            minNum = movDischarge(minNum) + charsForN.get(i);
            maxNum = movDischarge(maxNum) + charsForN.get(charsForN.size() - i - 1);
        }
        return funK(maxNum - minNum, cnt + 1);

    }
}
