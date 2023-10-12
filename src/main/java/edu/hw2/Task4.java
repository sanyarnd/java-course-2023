package edu.hw2;

public final class Task4 {
    private Task4() {
    }

    private static final int THREE = 3;

    public static CallingInfo callingInfo() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length >= THREE) {
            StackTraceElement caller = stackTrace[2];
            String className = caller.getClassName();
            String methodName = caller.getMethodName();
            return new CallingInfo(className, methodName);
        } else {
            return null;
        }
    }

    public record CallingInfo(String className, String methodName) {
    }
}
