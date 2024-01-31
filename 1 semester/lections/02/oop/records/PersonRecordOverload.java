package tinkoff2.oop.records;

public record PersonRecordOverload(String name, int age) {
    public PersonRecordOverload(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public PersonRecordOverload(String name) {
        this(name, 10);
    }

    public String name() {
        return "Mr/Ms " + name;
    }
}
