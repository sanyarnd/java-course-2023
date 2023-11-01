package homework3;

import java.util.TreeMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class Task7Test {
    @Test
    public void testTreeMapWithNullKey() {
        TreeMap<String, String> treeMap = new TreeMap<>(new Task7());

        treeMap.put("A", "Value A");
        treeMap.put(null, "Value Null");
        treeMap.put("B", "Value B");

        assertTrue(treeMap.containsKey("A"));
        assertTrue(treeMap.containsKey(null));
        assertTrue(treeMap.containsKey("B"));

        assertEquals("Value A", treeMap.get("A"));
        assertEquals("Value Null", treeMap.get(null));
        assertEquals("Value B", treeMap.get("B"));

        assertFalse(treeMap.containsKey("C"));
        assertNull(treeMap.get("C"));
    }

}
