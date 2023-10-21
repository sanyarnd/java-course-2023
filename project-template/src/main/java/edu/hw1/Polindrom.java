package edu.hw1;

public class Polindrom {
    private static int getSumTwoCharacter(String a){
        return  Character.getNumericValue(a.charAt(0)) +
            Character.getNumericValue(a.charAt(1));
    }
    public static boolean isPolindromeDescendant(int number){
        String represent_number = String.valueOf(number);

        if (represent_number.equals(new StringBuilder(represent_number).reverse().toString()))
            return true;

        if (represent_number.length() == 2  &&
            getSumTwoCharacter(represent_number) < 10)
            return false;

        StringBuilder descedent = new StringBuilder();
        for(int i = 1; i < represent_number.length() ; i += 2){

            String sub_result =Integer.toString(
                getSumTwoCharacter(represent_number.substring(i-1, i+1))
            );

            for (int j =0; j < sub_result.length(); j += 1)
                descedent.append(sub_result.charAt(j));
        }
        return isPolindromeDescendant(Integer.parseInt(descedent.toString()));
    }
}
