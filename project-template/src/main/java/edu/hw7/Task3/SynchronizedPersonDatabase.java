package edu.hw7.Task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class SynchronizedPersonDatabase implements PersonDatabase {
    private final Map<Integer, Person> personsById = new HashMap<>();
    private final Map<String, List<Person>> personsByName = new HashMap<>();
    private final Map<String, List<Person>> personsByAddress = new HashMap<>();
    private final Map<String, List<Person>> personsByPhone = new HashMap<>();

    @Override
    public synchronized boolean add(Person person) {
        if (personsById.containsKey(person.id())) {
            return false;
        }

        personsById.put(person.id(), person);
        personsByName.computeIfAbsent(person.name(), k -> new ArrayList<>()).add(person);
        personsByAddress.computeIfAbsent(person.address(), k -> new ArrayList<>()).add(person);
        personsByPhone.computeIfAbsent(person.phoneNumber(), k -> new ArrayList<>()).add(person);

        return true;
    }

    @Override
    public synchronized void delete(int id) {
        Optional.ofNullable(personsById.remove(id))
            .ifPresent(person -> {
                personsByName.get(person.name()).remove(person);
                personsByAddress.get(person.address()).remove(person);
                personsByPhone.get(person.phoneNumber()).remove(person);
            });
    }

    @Override
    public List<Person> findByName(String name) {
        return personsByName.getOrDefault(name, new ArrayList<>());
    }

    @Override
    public List<Person> findByAddress(String address) {
        return personsByAddress.getOrDefault(address, new ArrayList<>());
    }

    @Override
    public List<Person> findByPhone(String phone) {
        return personsByPhone.getOrDefault(phone, new ArrayList<>());
    }
}
