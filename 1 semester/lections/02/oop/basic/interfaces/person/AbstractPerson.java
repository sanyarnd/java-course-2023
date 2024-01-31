package tinkoff2.oop.basic.interfaces.person;

public abstract class AbstractPerson implements Person {
    protected int age;
    protected String name;

    public AbstractPerson(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public void becomeOlder(String name) {
        this.age++;
    }

    public void setName(String name) {
        this.name = name;
    }
}
