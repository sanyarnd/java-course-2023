package org.lisi4ka.tasks;

import java.util.Collections;
import java.util.LinkedList;

public class Task6 {
    public static Integer task6(String inputs){
        int input = Integer.parseInt(inputs);
        if (!(input > 1000 & input < 9999) || input == 1111 || input == 2222 || input == 3333 || input == 4444 || input == 5555 || input == 6666 || input == 7777 || input == 8888){
            throw new NumberFormatException();
        }
        int count = 0;
        while (input != 6174) {
            String[] prom = inputs.split("");
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < inputs.length(); i++) {
                list.add(Integer.parseInt(prom[i]));
            }
            Collections.sort(list);
            int down = make(list);
            list.sort(Collections.reverseOrder());
            int up = make(list);
            input = down - up;
            inputs = String.valueOf(input);
            if (input < 1000){
                inputs = 0 + inputs;
            }
            count++;
        }
        return count;
    }
    private static int make(LinkedList<Integer> input){
        int res = 0;
        for (int i = 0; i < input.size(); i++){
            res = res + ((int) Math.pow(10, i)) * input.get(i);
        }
        return res;
    }
}
