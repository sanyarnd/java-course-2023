package edu.hw1;

import java.util.Objects;

public final class VideoLength {
    public static int getSeconds(String time) {
        Objects.requireNonNull(time);
        String[] str_time = time.split(":");

        if (str_time.length != 2) return -1;
        int min, sec;

        try {
            min = Integer.parseInt(str_time[0]);
            if(min < 0)
                return -1;

            sec = Integer.parseInt(str_time[1]);
            if (sec >= 60 || sec < 0)
                return -1;
        }
        catch (Exception e){
            return -1;
        }

        return min * 60 + sec;
    };
}
