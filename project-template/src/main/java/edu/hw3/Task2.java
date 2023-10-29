package edu.hw3;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Task2 {

    private Task2() {

    }

    public static List<String> clusteringBrackets(String brackets) {
        List<String> arrayOfBrackets = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        StringBuilder string = new StringBuilder("");
        for (char letter: brackets.toCharArray()) {
            if (letter == '(') {
                stack.add(letter);
                string.append(letter);
            }
            if ((letter == ')') && (!stack.isEmpty())) {
                string.append(letter);
                stack.pop();
                if (stack.isEmpty()) {
                    arrayOfBrackets.add(String.valueOf(string));
                    string = new StringBuilder();
                }
            }
        }
        return arrayOfBrackets;

    }
}
