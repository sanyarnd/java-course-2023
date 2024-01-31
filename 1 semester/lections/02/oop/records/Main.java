package tinkoff2.oop.records;

public class Main {
    public static void main(String[] args) {
        PersonClass person1 = new PersonClass("Mike", 10);
        PersonRecord person2 = new PersonRecord("Mike", 10);
        PersonRecordOverload person3 = new PersonRecordOverload("Mike");
        System.out.println(person1);
        System.out.println(person2);


        System.out.println(person2.name());
        System.out.println(person3.name());
    }
}
