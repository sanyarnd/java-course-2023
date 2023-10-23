package tinkoff2.exception.trycatch;

import tinkoff2.exception.hierarchy.MyOwnException;

import java.io.FileNotFoundException;
import java.io.IOException;


public class SeveralCatch {


    public static void main(String[] args) {

    }

    public static void severalCatch() {
        try {
            testMyException();
        } catch (FileNotFoundException e) {
            System.out.println("Произошла ошибка FileNotFoundException");
        } catch (IOException e) {
            System.out.println("Произошла ошибка IOException");
        } catch (MyOwnException e) {
            System.out.println("Произошла ошибка MyOwnException");
        } catch (Exception e) {
            System.out.println("Произошла ошибка Exception");
        }
    }

    public static void severalExceptionInBlock() {
        try {
            testMyException();
        } catch (IOException | MyOwnException e) {
            System.out.println("Произошла ошибка FileNotFoundException");
        }
    }

    public static void exceptionsInBlockParentChild() {
//        try {
//            testMyException();
//        } catch (MyOwnException e) {
//            System.out.println("Произошла ошибка MyOwnException");
//        } catch (IOException | FileNotFoundException e) {
//            System.out.println("Произошла ошибка FileNotFoundException");
//        }
    }

    public static void severalCatchParentChild() {
//        try {
//            testMyException();
//        } catch (MyOwnException e) {
//            System.out.println("Произошла ошибка MyOwnException");
//        } catch (IOException e) {
//            System.out.println("Произошла ошибка IOException");
//        } catch (FileNotFoundException e) {
//            System.out.println("Произошла ошибка FileNotFoundException");
//        }
    }

    public static void testMyException() throws MyOwnException, IOException {
        throw new MyOwnException(404, "Не правильный url");
    }
}
