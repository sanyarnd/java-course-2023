package tinkoff.memory;

import java.util.LinkedList;
import java.util.List;

public class HeapStackError {
    private static final List<Object[]> arrays = new LinkedList<>();

    public static void main(String[] args) {

//        outOfMemory();
//        stackOverFlow();
    }

    public static void stackOverFlow() {
        stackOverFlow();
    }

    public static void outOfMemory() {
        for (; ; ) {
            arrays.add(new Object[10000]);
        }
    }
}
