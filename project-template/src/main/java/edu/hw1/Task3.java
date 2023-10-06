package edu.hw1;

import org.jetbrains.annotations.NotNull;

@SuppressWarnings("HideUtilityClassConstructor")
public class Task3 {
    public static boolean isNestable(int @NotNull [] fstMas, int[] secMas) {
        boolean ans = true;

        int minFst = 0;
        int maxFst = 0;
        int minSec = 0;
        int maxSec = 0;

        for (int i = 0; i < fstMas.length; i++) {
            if (i == 0) {
                minFst = fstMas[i];
                maxFst = fstMas[i];
            } else {
                minFst = Math.min(minFst, fstMas[i]);
                maxFst = Math.max(maxFst, fstMas[i]);
            }

        }
        for (int i = 0; i < secMas.length; i++) {
            if (i == 0) {
                minSec = secMas[i];
                maxSec = secMas[i];
            } else {
                minSec = Math.min(minSec, secMas[i]);
                maxSec = Math.max(maxSec, secMas[i]);
            }
        }

        return (minFst > minSec && maxFst < maxSec);
    }
}
