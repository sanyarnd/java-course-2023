package tinkoff2.exception.trycatch;

import tinkoff2.exception.hierarchy.MyOwnException;
import tinkoff2.exception.hierarchy.MyOwnThrowable;


public class TryCatchExample {

    public static void main(String[] args) {
        try {
            testMyException();
        } catch (Exception e) {
            System.out.println("Произошла ошибка");
        } finally {

        }
    }

    public static void testMyException() throws MyOwnException {
        throw new MyOwnException(404, "Не правильный url");
    }
}
