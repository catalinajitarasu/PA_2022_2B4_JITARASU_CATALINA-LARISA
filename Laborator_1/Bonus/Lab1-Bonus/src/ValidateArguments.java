import java.util.HashSet;
import java.util.Set;

public class ValidateArguments {
    private static boolean validateInteger(String input) {
        try {
            Integer.parseInt(input);
            System.out.println(input + " is a valid integer");
            return true;
        }
        catch (NumberFormatException e) {

            System.out.println(input + " is not a valid integer");
        }
        return false;
    }

    private static boolean validNumberOfArguments(String[] input) {
        return input.length > 3;
    }

    public static boolean theRestOfCharactersAreLetters(String[] args) {
        for(int i = 2; i < args.length; i++) {
            if(!args[i].matches("[a-zA-Z]")) {
                return false;
            }
        }
        return true;
    }

    public static String concatenateLettersFromInput(String[] args) {
        String letters = "";
        for(int i = 2; i < args.length; i++) {
            letters += args[i];
        }
        return letters;
    }

    public static boolean isUnique(String input) {
        // Create a Set to insert characters
        Set<Character> set = new HashSet<>();

        // get all characters form String
        char[] characters = input.toCharArray();

        for (Character c : characters) {
            if (!set.add(c)) {
                return false;
            }
        }
        return true;
    }

    public static boolean theCharactersAreUnique(String input) {
        return isUnique(input);
    }
    public static boolean validateArgumentsList(String[] input) {
        return validateInteger(input[0]) &&
                validateInteger(input[1]) &&
                !validateInteger(input[2]) &&
                validNumberOfArguments(input) &&
                theRestOfCharactersAreLetters(input) &&
                theCharactersAreUnique(concatenateLettersFromInput(input));
    }
}
