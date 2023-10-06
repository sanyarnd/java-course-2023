package edu.hw1;

@SuppressWarnings("HideUtilityClassConstructor")

public class Task2 {

    @SuppressWarnings("MagicNumber")
    public static int countDigits(int n) {
        if (n == 0) {
            return 0;
        }
        int secN = Math.abs(n);
        int cnt = 0;
        int tenNum = 10;
        while (secN > 0) {
            cnt += 1;
            secN /= tenNum;
        }
        return cnt;
    }

}
