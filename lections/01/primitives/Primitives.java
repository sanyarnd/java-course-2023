package tinkoff.primitives;

public class Primitives {
    public static void main(String[] args) {

        byte b = 1;     //  [-128, 128)
        Byte b1 = 1;

        short s = 1;    //  [-2^15, 2^15)
        Short s1 = 1;

        int i = 1;      //  [-2^31, 2^31-1)
        Integer i1 = 1;

        long l = 1L;    //  [-2^63, 2^63-1)
        Long l1 = 1L;


        float f = 1f;       // 32-битный
        Float f1 = 1f;

        double d = 1.0;     // 64-битный
        Double d1 = 1.0;

        boolean bool = true;
        Boolean bool1 = true;

        char c = 'c';       // UTF-16
        Character c1 = 'c';
    }
}
