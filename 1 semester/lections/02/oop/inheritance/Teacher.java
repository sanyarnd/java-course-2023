package tinkoff2.oop.inheritance;

public class Teacher extends Person {

    public Teacher() {
        super(30, "Tamara Nikolaevna");
    }

    public Teacher(int age, String name) {
        super(age, name);
    }

    public void callParents() {
        System.out.println("Родителей в школу");
    }
}
