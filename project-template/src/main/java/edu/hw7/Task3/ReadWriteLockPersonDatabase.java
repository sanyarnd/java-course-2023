package edu.hw7.Task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockPersonDatabase implements PersonDatabase {
    private final Map<Integer, Person> personsById = new HashMap<>();
    private final Map<String, List<Person>> personsByName = new HashMap<>();
    private final Map<String, List<Person>> personsByAddress = new HashMap<>();
    private final Map<String, List<Person>> personsByPhone = new HashMap<>();
    private final ReadWriteLock lockRW = new ReentrantReadWriteLock();

    @Override
    public boolean add(Person person) {
        if (personsById.containsKey(person.id())) {
            return false;
        }

        lockRW.writeLock().lock();
        try {
            personsById.put(person.id(), person);
            personsByName.computeIfAbsent(person.name(), k -> new ArrayList<>()).add(person);
            personsByAddress.computeIfAbsent(person.address(), k -> new ArrayList<>()).add(person);
            personsByPhone.computeIfAbsent(person.phoneNumber(), k -> new ArrayList<>()).add(person);
            return true;
        } finally {
            lockRW.writeLock().unlock();
        }
    }

    @Override
    public void delete(int id) {
        lockRW.writeLock().lock();
        try {
            Optional.ofNullable(personsById.remove(id))
                .ifPresent(person -> {
                    personsByName.get(person.name()).remove(person);
                    personsByAddress.get(person.address()).remove(person);
                    personsByPhone.get(person.phoneNumber()).remove(person);
                });
        } finally {
            lockRW.writeLock().unlock();
        }
    }

    @Override
    public List<Person> findByName(String name) {
        lockRW.readLock().lock();
        try {
            return personsByName.getOrDefault(name, new ArrayList<>());
        } finally {
            lockRW.readLock().unlock();
        }
    }

    @Override
    public List<Person> findByAddress(String address) {
        lockRW.readLock().lock();
        try {
            return personsByAddress.getOrDefault(address, new ArrayList<>());
        } finally {
            lockRW.readLock().unlock();
        }
    }

    @Override
    public List<Person> findByPhone(String phone) {
        lockRW.readLock().lock();
        try {
            return personsByPhone.getOrDefault(phone, new ArrayList<>());
        } finally {
            lockRW.readLock().unlock();
        }
    }
}
