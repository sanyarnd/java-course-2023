package tinkoff2.oop.basic.interfaces.person;

public class Teacher extends AbstractPerson {
    private int age;
    private String name;

    public Teacher() {
        super(30, "Tamara Nikolaevna");
    }

    public Teacher(int age, String name) {
        super(age, name);
    }

    public void sayHello() {
        System.out.println("Привет, меня зовут " + name + ". Я работаю в школе");
    }

    public void callParents() {
        System.out.println("Родителей в школу");
    }
}
