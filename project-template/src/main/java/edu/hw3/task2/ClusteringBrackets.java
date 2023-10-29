package edu.hw3.task2;

import java.util.ArrayList;
import java.util.List;

public class ClusteringBrackets {
    public static List<String> clusterize(String input) {
        List<String> clusters = new ArrayList<>();
        int count = 0;
        StringBuilder cluster = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
            }

            cluster.append(c);

            if (count == 0) {
                clusters.add(cluster.toString());
                cluster = new StringBuilder();
            }
        }

        return clusters;
    }
}
