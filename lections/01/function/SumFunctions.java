package tinkoff.function;

public class SumFunctions {

    public static void main(String[] args) {
        int res1 = sum(1);
        int res2 = sum(1, 2);
        int res3 = sum(1, 2, 3);
        int res4 = sum(1, 2, 3, 4);
    }

    public static int sum(int a, int b) {
        return a + b;
    }

    public static int sum(Integer a, int b) {
        return a + b;
    }

    public static int sum(int a, int... more) { // На самом деле создается массив
        int res = a;
        for (int b: more) {
            a += b;
        }
        return res;
    }
}
