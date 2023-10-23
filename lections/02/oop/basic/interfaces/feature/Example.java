package tinkoff2.oop.basic.interfaces.feature;

public interface Example {

    int VALUE = 4;

    default void repeatPrint(int num) {
        for (int i = 0; i < num; i++) {
            print();
        }
    }

    private void print() {
        System.out.println(VALUE);
    }

    static void doublePrint() {
        System.out.println(VALUE);
        System.out.println(VALUE);
    }
}
