package edu.hw1;

public class CountDigits {
    public static int getCountDigits(int value){
        if(value == 0) return 1;

        var result = 0;

        while(value != 0){
            value /= 10;
            result++;
        }
        return  result;
    }
}
