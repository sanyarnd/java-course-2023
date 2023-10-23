package tinkoff2.oop.polymorphism;

import java.time.DayOfWeek;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        Student student = new Student();
        Person person = new Person(19, "Sasha");

        List<Person> personList = new LinkedList<>();
        personList.add(teacher);
        personList.add(student);
        personList.add(person);

        for(Person p : personList) {
            p.sayHello();
        }
    }
}
