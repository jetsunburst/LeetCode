import java.util.*;

public class SemordnilapPairs {

    public static ArrayList<ArrayList<String>> findSemordnilapPairs(String[] words) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        for (String word : words) {
            String reversedWord = new StringBuilder(word).reverse().toString();

            if (wordSet.contains(reversedWord) && !word.equals(reversedWord)) {
                result.add(new ArrayList<>(Arrays.asList(word, reversedWord)));

                // Remove both to prevent duplicate pairing
                wordSet.remove(word);
                wordSet.remove(reversedWord);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[] words = {"diaper", "abc", "test", "cba", "repaid"};
        ArrayList<ArrayList<String>> pairs = findSemordnilapPairs(words);

        System.out.println("Semordnilap Pairs:");
        for (ArrayList<String> pair : pairs) {
            System.out.println(pair);
        }
    }
}
