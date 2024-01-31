package org.example.kv_server;

import java.util.HashMap;
import java.util.Map;

public class KvStorage {

    private final Map<String, String> map = new HashMap<>();

    public void put(String key, String value) {
        System.out.println("Putting key = %s, value = %s".formatted(key, value));
        map.put(key, value);
    }

    public String get(String key) {
        return map.get(key);
    }

    public void print() {
        System.out.println(map);
    }

}
