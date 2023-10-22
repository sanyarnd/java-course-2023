package edu.hw2.Task2_4;

public class Task2_4 {

    private Task2_4() {
    }

    public static CallingInfo callingInfo() {
        StackTraceElement[] stack = Thread.currentThread().getStackTrace();
        if (stack.length > 2) {
            String className = stack[2].getClassName();
            String methodName = stack[2].getMethodName();
            return new CallingInfo(className, methodName);
        } else {
            return new CallingInfo(Task2_4.class.getName(), "callingInfo");
        }
    }
}
