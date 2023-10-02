package tinkoff.memory;

public class HeapStack {

    public static void main(String[] args) {
        int id = 23;
        String name = "John";
        Person person = null;
        person = buildPerson(id, name);
    }

    private static Person buildPerson(int id, String name) {
        return new Person(id, name);
    }
}
