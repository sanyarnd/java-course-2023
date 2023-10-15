package org.lisi4ka.tasks;

public class Task4 {
    public static String task4(String inputs){
        String[] input = inputs.split("");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < inputs.length(); i+= 2){
            String first = input[i];
            try {
                String second = input[i + 1];
                res.append(second);
                res.append(first);
            } catch (ArrayIndexOutOfBoundsException ex){
                res.append(first);
            }
        }
        return res.toString();
    }
}
