package tinkoff.conditions;

public class Switch {
    public static void main(String[] args) {
        String str = "a";

        int res;

        if (str.equals("a") || str.equals("b")) {
            res = 0;
        } else if (str.equals("ab") || str.equals("bc")) {
            res = 1;
        } else if (str.equals("abc")) {
            res = 2;
        } else {
            res = 100;
        };

        // Равносильно

        switch (str) {
            case "a", "b":
                res = 0;
                break;
            case "ab", "bc":
                res = 1;
                break;
            case "abc":
                res = 2;
                break;
            default:
                res = 100;
        };

        // Равносильно

        res = switch (str) {
            case "a", "b":
                yield 0;
            case "ab", "bc":
                yield 1;
            case "abc":
                yield 2;
            default:
                yield 100;
        };

        // Равносильно

        res = switch (str) {
            case "a", "b" -> 0;
            case "ab", "bc" -> 1;
            case "abc" -> 2;
            default -> 100;
        };
    }
}
