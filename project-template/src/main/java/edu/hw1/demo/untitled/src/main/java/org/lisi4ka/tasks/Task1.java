package org.lisi4ka.tasks;

public class Task1 {
    public static Integer task1(String inputs) {
        String[] input = inputs.split(":");
        int minutes = Integer.parseInt(input[0]) * 60;
        int seconds = Integer.parseInt(input[1]);
        if (seconds >= 0 & seconds <=60 & minutes >= 0){
            return minutes + seconds;
        }
        return -1;
    }
}
