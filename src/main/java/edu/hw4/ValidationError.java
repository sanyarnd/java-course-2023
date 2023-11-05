package edu.hw4;

public class ValidationError {
    String field;
    String message;

    public ValidationError(String f, String m){
        this.field = f;
        this.message = m;
    }

    public String getField(){return field;}

    @Override
    public String toString() {
        return "Invalid field '" + field + "' (" + message + ")";
    }
}
