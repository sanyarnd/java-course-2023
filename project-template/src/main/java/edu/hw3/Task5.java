package edu.hw3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class Task5 {

    private Task5() {

    }

    public static List<Person> parseContacts(List<String> names, String typeOfSort) {
        if (names == null) {
            return new ArrayList<>();
        }

        List<Person> persons = new LinkedList<>();
        for (String name: names) {
            String[] parts = name.split(" ");
            if (parts.length == 1) {
                persons.add(new Person(parts[0], null));
            } else {
                persons.add(new Person(parts[0], parts[1]));
            }
        }

        Collections.sort(persons);
        if (typeOfSort.equals("DESC")) {
            Collections.reverse(persons);
        }
        return persons;
    }

    public static class Person implements Comparable<Person> {
        String name;
        String secondName;

        public Person(String name, String secondName) {
            this.name = name;
            this.secondName = secondName;
        }

        @Override
        public String toString() {
            StringBuilder string = new StringBuilder(this.name);
            if (this.secondName != null) {
                string.append(" ").append(this.secondName);
            }
            return String.valueOf(string);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSecondName() {
            return secondName;
        }

        public void setSecondName(String secondName) {
            this.secondName = secondName;
        }

        @Override
        public int compareTo(Task5.@NotNull Person person) {
            if ((secondName == null) && (person.getSecondName() == null)) {
                return name.compareTo(person.getName());
            }
            if (secondName == null) {
                return name.compareTo(person.getSecondName());
            }
            if (person.secondName == null) {
                return secondName.compareTo(person.getName());
            }
            return secondName.compareTo(person.getSecondName());
        }
    }
}
