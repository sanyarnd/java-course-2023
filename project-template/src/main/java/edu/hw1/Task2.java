public class Task2 {
    public static Long countDigits(Integer number){
        if(number.equals(0)){
            return 1;
        }

        Long digit_couner = 0l;

        while(!number.equals(0)){
            number /= 10;
            digit_couner++;
        }
        return digit_couner;
    }

}
