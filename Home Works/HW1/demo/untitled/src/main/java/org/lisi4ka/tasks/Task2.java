package org.lisi4ka.tasks;


public class Task2 {
    public static Integer task2(String inputs) {
        long input = Math.abs(Long.parseLong(inputs.replaceFirst("\\.", "")));
        int res = 0;
        if (input == 0) {
            return 1;
        }
        while (input != 0) {
            input = input / 10;
            res++;
        }
        return res;
    }
}
