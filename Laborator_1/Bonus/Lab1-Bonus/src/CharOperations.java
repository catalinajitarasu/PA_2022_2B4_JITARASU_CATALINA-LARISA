import java.util.ArrayList;
import java.util.List;

public class CharOperations {
    public static String getLettersFromParams(String[] input) {
        String letters = "";
        for(int index = 2; index < input.length; index ++) {
            letters += input[index];
        }
        System.out.println("The letters are: " + letters);
        return letters;
    }

    public static String randomWord(String letters, int p) {
        StringBuilder stringBuilder = new StringBuilder(p);
        for (int i = 0; i < p; i++) {
            int index = (int)(letters.length() * Math.random());
            stringBuilder.append(letters.charAt(index));
        }
        return stringBuilder.toString();
    }



    public static String createRandomWord(int len,char[] alphabet){
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int k = (int) (Math.random() * alphabet.length);
            word.append(alphabet[k]);
        }//generam pana la dimensiunea data cate o litera randoom din alfabet
        return word.toString();
    }

    public static List<String> randomWords(String letters, int n, int p) {
        List<String> words = new ArrayList<>();
        for(int index = 0; index < n; index ++) {
            words.add(sortString(randomWord(letters, p)));
        }
        return words;
    }

    public static String sortString(String word) {
        return word.chars().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
    }

    public static boolean checkIfTwoWordsAreNeighbors(String first, String second) {
        int commonLetters = 0;
        for(int index = 0; index < first.length(); index ++) {
            if(first.charAt(index) == second.charAt(index)) {
                commonLetters ++;
            }
        }
        if(commonLetters == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static String randomWords(int len, char[] alphabet) {
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int k = (int) (Math.random() * alphabet.length);
            word.append(alphabet[k]);
        }//generam pana la dimensiunea data cate o litera randoom din alfabet
        return word.toString();
    }
}
