package tinkoff2.exception.hierarchy;

public class MyOwnException extends Exception {
    private int code;
    private String errorMessage;

    public MyOwnException(int code, String message) {
        super("Exception: " + message + ". Code: " + code);
    }
}
