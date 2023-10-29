package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task5Test {

    @Test
    @DisplayName("4 names, type = ASC")
    void test1() {
        // given
        List<String> names = List.of("John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes");
        String typeOfSort = "ASC";
        List<Task5.Person> persons = List.of(
            new Task5.Person("Thomas", "Aquinas"),
            new Task5.Person("Rene", "Descartes"),
            new Task5.Person("David", "Hume"),
            new Task5.Person("John", "Locke")
        );
        // when
        List<Task5.Person> result = Task5.parseContacts(names, typeOfSort);

        // then
        assertEquals(result.toString(), persons.toString());
    }

    @Test
    @DisplayName("3 names, type = DESC")
    void test2() {
        // given
        List<String> names = List.of("Paul Erdos", "Leonhard Euler", "Carl Gauss");
        String typeOfSort = "DESC";
        List<Task5.Person> persons = List.of(
            new Task5.Person("Carl", "Gauss"),
            new Task5.Person("Leonhard", "Euler"),
            new Task5.Person("Paul", "Erdos")
        );
        // when
        List<Task5.Person> result = Task5.parseContacts(names, typeOfSort);

        // then
        assertEquals(result.toString(), persons.toString());
    }

    @Test
    @DisplayName("[], DESK")
    void test3() {
        // given
        List<String> names = new ArrayList<>();
        String typeOfSort = "DESK";
        // when
        List<Task5.Person> result = Task5.parseContacts(names, typeOfSort);

        // then
        assertEquals(result.toString(), new ArrayList<Task5.Person>().toString());
    }

    @Test
    @DisplayName("null, DESK")
    void test4() {
        // given
        String typeOfSort = "DESK";
        // when
        List<Task5.Person> result = Task5.parseContacts(null, typeOfSort);

        // then
        assertEquals(result.toString(), new ArrayList<Task5.Person>().toString());
    }

    @Test
    @DisplayName("without secondnames, ASC")
    void test5() {
        // given
        List<String> names = List.of("John Locke", "Thomas", "David Hume", "Rene");
        String typeOfSort = "ASC";
        List<Task5.Person> persons = List.of(
            new Task5.Person("David", "Hume"),
            new Task5.Person("John", "Locke"),
            new Task5.Person("Rene", null),
            new Task5.Person("Thomas", null)
        );
        // when
        List<Task5.Person> result = Task5.parseContacts(names, typeOfSort);

        // then
        assertEquals(result.toString(), persons.toString());
    }
}
