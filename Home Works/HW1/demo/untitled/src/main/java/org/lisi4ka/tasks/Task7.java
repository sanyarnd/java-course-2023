package org.lisi4ka.tasks;


public class Task7 {
    public static String task7left(String inputs){
        String[] input = inputs.trim().replace(" ", "").split(",");
        String[] prom = Integer.toBinaryString(Integer.parseInt(input[0])).split("");
        StringBuilder res = new StringBuilder();
        for (int i = Integer.parseInt(input[1]); i < prom.length; i++){
            res.append(prom[i]);
        }
        for (int i = 0; i < Integer.parseInt(input[1]); i++){
            res.append(prom[i]);
        }
        return res.toString();
    }
    public static String task7right(String inputs){
        String[] input = inputs.trim().replace(" ", "").split(",");
        String[] prom = Integer.toBinaryString(Integer.parseInt(input[0])).split("");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < Integer.parseInt(input[1]); i++){
            res.append(prom[prom.length - i - 1]);
        }
        for (int i = 0; i < prom.length - Integer.parseInt(input[1]); i++){
            res.append(prom[i]);
        }
        return res.toString();
    }

}
