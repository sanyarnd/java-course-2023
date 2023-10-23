package tinkoff2.oop.basic.abstracts.person;

public abstract class Person {
    protected int age;
    protected String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public abstract void sayHello();

    public void becomeOlder(String name) {
        this.age++;
    }

    public void setName(String name) {
        this.name = name;
    }
}
