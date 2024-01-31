package tinkoff2.oop.records;

public class PersonClass {
    private final String name;
    private final int age;

    PersonClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    String name() { return name; }
    int age() { return age; }

    public String toString() {
        return "PersonClass[name=%s, age=%d]".formatted(name, age);
    }
}
