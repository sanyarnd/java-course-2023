package tinkoff2.nio;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

public class Serialization {

    static class DemoClass implements Serializable {
        private int number;
        private String name;

        public DemoClass(int number, String name) {
            this.number = number;
            this.name = name;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }


        @Override
        public String toString() {
            return "DemoClass{" +
                    "number=" + number +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        var demoObject = new DemoClass(1, "test");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try (var oos = new ObjectOutputStream(byteArrayOutputStream)) {
            oos.writeObject(demoObject);
        }
        byteArrayOutputStream.close();
        System.out.println(Arrays.toString(byteArrayOutputStream.toByteArray()));

        deser(byteArrayOutputStream.toByteArray());
    }

    private static void deser(byte[] toByteArray) throws IOException, ClassNotFoundException {
        try(var ois = new ObjectInputStream(new ByteArrayInputStream(toByteArray))) {
            var obj = (DemoClass)ois.readObject();
            System.out.println(obj);
        }
    }
}
