package homework3;

import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static List<String> clusterize(String input) {
        List<String> clusters = new ArrayList<>();
        int openCount = 0;
        int closeCount = 0;
        int clusterStart = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                openCount++;
            } else if (input.charAt(i) == ')') {
                closeCount++;
            }

            if (openCount == closeCount) {
                clusters.add(input.substring(clusterStart, i + 1));
                clusterStart = i + 1;
            }
        }

        return clusters;
    }
}
