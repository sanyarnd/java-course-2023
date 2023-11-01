package homework3;

public class Task1 {
    public static String encrypt(String input) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char originalChar = input.charAt(i);
            char encryptedChar;

            if (Character.isLetter(originalChar)) {
                char baseChar = Character.isUpperCase(originalChar) ? 'A' : 'a';
                encryptedChar = (char) (baseChar + ('Z' - originalChar + baseChar));
            } else {
                encryptedChar = originalChar;
            }

            result.append(encryptedChar);
        }

        return result.toString();
    }
}
