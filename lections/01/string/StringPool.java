package tinkoff.string;

public class StringPool {
    public static void main(String[] args) {
        String a = "str";
        String b = "str";
        String c = new String("str");
        String d = new String("str").intern();

        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(b == c);
        System.out.println(a == d);

        System.out.println();

        String ab1 = "strstr";
        String ab2 = "str" + "str";
        String ab3 = a + b;
        System.out.println(ab1 == ab2);
        System.out.println(ab1 == ab3);
    }
}
