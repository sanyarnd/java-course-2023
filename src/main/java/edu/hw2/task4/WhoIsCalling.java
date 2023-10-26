package edu.hw2.task4;

public class WhoIsCalling {
    private final static int CALLING_METHOD = 3;

    private WhoIsCalling() {
    }

    static CallingInfo callingInfo() {
        Throwable t = new Throwable();
        StackTraceElement[] stackTrace = t.getStackTrace();

        if (stackTrace.length > CALLING_METHOD) {
            String className = stackTrace[CALLING_METHOD].getClassName();
            String methodName = stackTrace[CALLING_METHOD].getMethodName();
            return new CallingInfo(className, methodName);
        } else {
            return new CallingInfo("UnknownClass", "unknownMethod");
        }
    }
}
