package edu.hw1;

import org.jetbrains.annotations.NotNull;

@SuppressWarnings("HideUtilityClassConstructor")

class Task1 {
    static int minutesToSeconds(@NotNull String s) {
        int ans = -1;
        int secs = 0;
        boolean flag = false;
        int mins = 0;
        @SuppressWarnings("MagicNumber")
        int tenMulti = 10;
        @SuppressWarnings("MagicNumber")
        int sixtyNum = 60;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ':') {
                flag = true;
                continue;
            }
            if (s.charAt(i) == '-') {
                return -1;
            }
            if (!flag) {
                mins = mins * tenMulti + (s.charAt(i) - '0');
            } else {
                secs = secs * tenMulti + (s.charAt(i) - '0');
            }

        }
        ans = mins * sixtyNum + secs;
        if (secs > sixtyNum || !flag) {
            return -1;
        }

        return ans;
    }

}
