package edu.hw2.task4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class Task4 {
    private Task4() {
    }

    public static List<CallingInfo> callingInfo() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

        return Arrays.stream(stackTrace)
            .map(element -> new CallingInfo(element.getClassName(), element.getMethodName()))
            .collect(Collectors.toList());
    }
}
