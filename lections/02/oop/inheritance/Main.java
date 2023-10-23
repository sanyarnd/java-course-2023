package tinkoff2.oop.inheritance;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        Student student = new Student();

        teacher.sayHello();
        student.sayHello();
        Object obj = new Object();
    }
}
