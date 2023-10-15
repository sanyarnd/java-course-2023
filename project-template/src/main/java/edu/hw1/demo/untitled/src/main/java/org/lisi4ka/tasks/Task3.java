package org.lisi4ka.tasks;

public class Task3 {
    public static Boolean task3(String inputs){
        String[] input = inputs.split(",");
        if (input.length > 2){
            throw new ArrayIndexOutOfBoundsException();
        }
        String[] inMassive = input[0].split(" ");
        String[] outMassive = input[1].split(" ");
        int inMin = Integer.MAX_VALUE;
        int inMax = Integer.MIN_VALUE;
        int outMin = Integer.MAX_VALUE;
        int outMax = Integer.MIN_VALUE;
        for (String s : inMassive) {
            int prom = Integer.parseInt(s);
            if (prom < inMin) {
                inMin = prom;
            }
            if (prom > inMax) {
                inMax = prom;
            }
        }
        for (String s : outMassive) {
            int prom = Integer.parseInt(s);
            if (prom < outMin) {
                outMin = prom;
            }
            if (prom > outMax) {
                outMax = prom;
            }
        }
        return (inMin > outMin) && (outMax > inMax);
    }
}
