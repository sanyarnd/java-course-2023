package edu.hw1;

public class task2 {
    public static int countDigits(int number) {
        int count = 0;
        if(number == 0 ){
            count++;
            return count;
        } else {
            while (number != 0) {
                number = number / 10;
                count++;
            }
        }
        return count;
    }
}
