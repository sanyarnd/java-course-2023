package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;
import static edu.hw1.Task4.fixString;

public class Task6 {
    private static final Logger LOGGER = LogManager.getLogger();

    public static int countK(int number, int... c) {
        int cnt = 0;
        if (c.length == 1) {
            cnt = c[0];
        }
        if (number == 6174) {
            return cnt;
        } else if (number <= 1000 || number >= 9999) {
            return -1;
        } else {
            int[] nums = new int[4];
            for (int i = 0; i < 4; i++) {
                nums[i] = number % 10;
                number /= 10;
            }
            Arrays.sort(nums);
//            LOGGER.info(c[1]);

//            System.out.println(nums[0]);
            int max_num = 0;
            int min_num = 0;
            for (int i = 0; i < 4; i++) {
                min_num += nums[i] * Math.pow(10, i);
                max_num += nums[3 - i] * Math.pow(10, i);
            }
            if (max_num - min_num != 0) {
                return countK(Math.abs(max_num - min_num), cnt + 1);
            } else {
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        LOGGER.info(countK(3524));
    }
}
