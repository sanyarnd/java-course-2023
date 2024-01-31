package tinkoff2.oop.basic.basic.person;

public class Person {
    private int age;
    private String name;

    public Person() {
        this(0, null);
    }

    public Person(String name) {
        this(0, name);
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public void sayHello() {
        System.out.println("Привет, меня зовут " + name);
    }

    public void becomeOlder() {
        this.age++;
    }

    public void setName(String name) {
        this.name = name;
    }
}
