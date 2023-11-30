package edu.hw4;

public class ValidationError {
    private final ErrorType type;
    private final String errorMessage;

    public enum ErrorType {
        NEGATIVE_AGE,
        NEGATIVE_HEIGHT,
        NEGATIVE_WEIGHT,
        INVALID_NAME
    }

    public ValidationError(ErrorType type, String errorMessage) {
        this.type = type;
        this.errorMessage = errorMessage;
    }

    public String getTypeString() {
        return type.toString();
    }

    public ErrorType getType() {
        return type;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
