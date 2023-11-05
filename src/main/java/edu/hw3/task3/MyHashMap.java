package edu.hw3.task3;

import java.util.HashMap;

public class MyHashMap<K, V> extends HashMap<K, V> {
    public String toString() {
        var i = this.keySet();
        StringBuilder ans = new StringBuilder();
        ans.append('{');
        for (var j : i) {
            if (ans.length() == 1) {
                ans.append(j).append(": ").append(this.get(j));
            } else {
                ans.append(", ").append(j).append(": ").append(this.get(j));
            }
        }
        ans.append('}');
        return ans.toString();
    }
}
