package tinkoff2.oop.classes.inner;

public class Main {
    public static void main(String[] args) {
        Person tom = new Person("Tom", "qwerty");
        tom.displayPerson();
        tom.getAccount().displayAccount();
    }
}
