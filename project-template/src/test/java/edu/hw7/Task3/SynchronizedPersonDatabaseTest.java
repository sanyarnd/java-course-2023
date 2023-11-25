package edu.hw7.Task3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SynchronizedPersonDatabaseTest {
    PersonDatabase db;
    Person person;

    @BeforeEach
    public void setUp() {
        db = new SynchronizedPersonDatabase();
        person = new Person(1, "testName", "testAddress", "testPhone");
    }

    @Test
    public void testAddFind() {
        db.add(person);
        List<Person> byName = db.findByName(person.name());
        List<Person> byAddress = db.findByAddress(person.address());
        List<Person> byPhone = db.findByPhone(person.phoneNumber());

        assertEquals(person, byName.get(0));
        assertEquals(person, byAddress.get(0));
        assertEquals(person, byPhone.get(0));
    }

    @Test
    public void testDelete() {
        db.add(person);
        db.delete(person.id());
        List<Person> byName = db.findByName(person.name());
        List<Person> byAddress = db.findByAddress(person.address());
        List<Person> byPhone = db.findByPhone(person.phoneNumber());

        assertTrue(byName.isEmpty());
        assertTrue(byAddress.isEmpty());
        assertTrue(byPhone.isEmpty());
    }
}
