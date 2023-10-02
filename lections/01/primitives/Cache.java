package tinkoff.primitives;

public class Cache {
    public static void main(String[] args) {
        Long l11 = 111L;
        Long l12 = 111L;

        Long l21 = 222L;
        Long l22 = 222L;

        Long l31 = Long.valueOf(111);
        Long l32 = Long.valueOf(111);

        System.out.println(l11 == l12);
        System.out.println(l21 == l22);
        System.out.println(l31 == l32);
    }
}
