package tinkoff2.oop.basic.abstracts.person;

public class Main {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        Student student = new Student();
        Person student2 = new Student();

        teacher.sayHello();
        student.sayHello();
        student2.sayHello();
    }
}
