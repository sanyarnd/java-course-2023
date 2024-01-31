package org.example.lecture;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

    private static final class InMemoryCache {

        private final Lock lock = new ReentrantLock(true);
        private final Map<String, String> storage = new HashMap<>();

        public void put(String key, String value) {
            lock.lock();
            try {
                storage.put(key, value);
            } finally {
                lock.unlock();
            }
        }

        public String get(String key) {
            lock.lock();
            try {
                return storage.get(key);
            } finally {
                lock.unlock();
            }
        }

    }

    public static void main(String[] args) {

    }

}
