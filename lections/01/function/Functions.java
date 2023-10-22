package tinkoff.function;

public class Functions {

    public static void main(String[] args) {
        printSum(1, 2);
    }

    public static void printSum(int a, int b) {
        System.out.println(a + b);
    }

    public static int binPow(int n, int pow) {
        if (pow == 0) {
            return 1;
        }
        if (pow % 2 == 0) {
            int res = binPow(n, pow / 2);
            return res * res;
        } else {
            return n * binPow(n, pow - 1);
        }
    }
}
