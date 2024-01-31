package tinkoff.string;

public class StringBuilderExample {
    public static void main(String[] args) {
        String str = "";

        for (int i = 0; i < 1000; i++) {
            str += i + ", ";
        }

        System.out.println(str);

        // Аналогично

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < 1000; i++) {
            stringBuilder.append(i).append(", ");
        }

        System.out.println(stringBuilder);
    }
}
