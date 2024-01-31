package tinkoff2.oop.basic.interfaces.person;

public class Main {
    public static void main(String[] args) {
        Person teacher = new Teacher();
        Person student = new Student();

        teacher.sayHello();
        student.sayHello();
    }
}
