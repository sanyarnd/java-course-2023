package tinkoff2.oop.polymorphism;

public class Teacher extends Person {

    public Teacher() {
        super(30, "Tamara Nikolaevna");
    }

    public Teacher(int age, String name) {
        super(age, name);
    }

//    public int sayHello() {
//        return 4;
//    }

    public void callParents() {
        System.out.println("Родителей в школу");
    }
}
