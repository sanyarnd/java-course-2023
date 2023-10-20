import java.util.Arrays;
import java.util.Collections;
public class Task2 {
    public static Boolean isNestable(Integer[] first_array, Integer[] second_array) {
        Arrays.sort(first_array);
        Arrays.sort(second_array);

        if ((first_array.length).equals(0)){
            return true;
        }
        if((second_array.length).equals(0)){
            return false;
        }

        Integer first_min = first_array[0];
        Integer first_max = second_array[0];

        Integer second_min = first_array[first_array.length - 1];
        Integer second_max = second_array[second_array.length - 1];

        return (first_min < second_min && second_max > first_max) ? true : false;
    }
}
