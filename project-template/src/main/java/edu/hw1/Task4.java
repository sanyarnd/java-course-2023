public class Task4{
    public static String fixString (String string_to_fix){
        char[] charArray = string_to_fix.toCharArray();

        for(Integer i = 0; i < string_to_fix.length()-1; i+=2) {
            char temporary_value = charArray[i];
            charArray[i] = charArray[i+1];
            charArray[i+1] = temporary_value;
        }

        String fixed_string = new String (charArray);
        return fixed_string;
    }
}
