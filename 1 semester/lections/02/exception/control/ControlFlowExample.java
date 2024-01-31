package tinkoff2.exception.control;

import javax.naming.NameNotFoundException;
import java.util.UUID;

public class ControlFlowExample {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1e7; i++) {
            findUserNameLengthNoEx(null);
        }
        System.out.println("Duration : " + (System.currentTimeMillis() - start));

        long start2 = System.currentTimeMillis();
        for (int i = 0; i < 1e7; i++) {
            findUserNameLength(null);
        }
        System.out.println("Duration with exception : " + (System.currentTimeMillis() - start2));
    }


    public static int findUserNameLength(UUID id) {
        try {
            String nameLength = findUserName(id);
            return nameLength.length();
        } catch (NameNotFoundException e) {
            return -1;
        }
    }

    private static String findUserName(UUID id) throws NameNotFoundException {
        // Сходили в базу
        String name = null;
        // Не нашли имя по id

        if (name == null) {
            throw new NameNotFoundException("Такого человека нет");
        }
        return name;
    }

    public static int findUserNameLengthNoEx(UUID id) {
        String nameLength = findUserNoEx(id);
        if (nameLength == null) {
            return -1;
        }
        return nameLength.length();
    }

    private static String findUserNoEx(UUID id) {
        // Сходили в базу
        String name = null;
        // Не нашли имя по id

        return name;
    }
}
