package edu.hw1;

import java.util.Arrays;

public class Task1 {
    public static int minutesToSeconds(String videoLength) {
        try {
            int[] minutesAndSeconds = Arrays.stream(videoLength.split(":")).mapToInt(Integer::parseInt).toArray();

            if (minutesAndSeconds[1] > 59)
                return -1;

            return minutesAndSeconds[0] * 60 + minutesAndSeconds[1];
        }
        catch (Exception ex){
            return -1;
        }
    }
}
