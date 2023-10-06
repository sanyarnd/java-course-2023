package edu.hw1;

import org.jetbrains.annotations.NotNull;

@SuppressWarnings("HideUtilityClassConstructor")
public class Task4 {
    public static @NotNull String fixString(@NotNull String s) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length() - (s.length() % 2); i += 2) {
            res.append(s.charAt(i + 1));
            res.append(s.charAt(i));
        }
        if (s.length() % 2 == 1) {
            res.append(s.charAt(s.length() - 1));
        }
        return res.toString();
    }
}
