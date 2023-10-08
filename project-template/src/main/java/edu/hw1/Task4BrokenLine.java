package edu.hw1;

final class Task4BrokenLine {
    private Task4BrokenLine() {
    }

    public static String getFixedLine(String line) {
        if (line.isEmpty()) {
            return "";
        } else if (line.length() == 1) {
            return line;
        }

        int lineLength = line.length();
        char[] result = line.toCharArray();

        for (int i = 0; i < lineLength - 1; i += 2) {
            char temp = result[i];
            result[i] = result[i + 1];
            result[i + 1] = temp;
        }
        return new String(result);
    }
}
