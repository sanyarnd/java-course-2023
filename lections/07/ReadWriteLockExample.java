package org.example.lecture;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

public class ReadWriteLockExample {

    private static final class InMemoryCache {

        private final ReadWriteLock lock = new ReentrantReadWriteLock(true);
        private final Map<String, String> storage = new HashMap<>();

        public void put(String key, String value) {
            lock.writeLock().lock();
            try {
                storage.put(key, value);
            } finally {
                lock.writeLock().unlock();
            }
        }

        public String get(String key) {
            lock.readLock().lock();
            try {
                return storage.get(key);
            } finally {
                lock.readLock().unlock();
            }
        }

    }

    public static void main(String[] args) {

    }

}
