package tinkoff2.exception.hierarchy;

import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) throws MyOwnException, MyOwnThrowable {
        testMyException();
        testMyThrowable();
    }

    public static void testMyException() throws MyOwnException {
        throw new MyOwnException(404, "Не правильный url");
    }

    public static void testMyThrowable() throws MyOwnThrowable {
        throw new MyOwnThrowable(404, "Не правильный url (Throwable)");
    }
}
