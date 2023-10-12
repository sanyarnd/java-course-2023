package edu.hw2;

//import java.util.logging.Logger;

public final class Task4 {
    private Task4() {
    }

//    private static final Logger LOGGER = Logger.getLogger(Task4.class.getName());
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

//    public static void main(String[] args) {
//        CallingInfo callingInfo = callingInfo();
//        if (callingInfo != null) {
//            LOGGER.info("ClassName: " + callingInfo.className());
//            LOGGER.info("MethodName: " + callingInfo.methodName());
//        } else {
//            LOGGER.info("Не удалось получить информацию о вызывающем методе\n");
//        }
//    }

    public record CallingInfo(String className, String methodName) {
    }
}
