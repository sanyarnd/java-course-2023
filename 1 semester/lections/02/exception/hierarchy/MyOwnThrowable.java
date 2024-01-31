package tinkoff2.exception.hierarchy;

public class MyOwnThrowable extends Throwable {
    private int code;
    private String errorMessage;

    public MyOwnThrowable(int code, String message) {
        super("Exception: " + message + ". Code: " + code);
    }
}
