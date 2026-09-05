import java.util.*;

public class Main {

    static void printFilteredWordFrequency(String feedback) {

        // Convert to lowercase
        String cleaned = feedback.toLowerCase();

        // Remove punctuation
        cleaned = cleaned.replace(".", "");
        cleaned = cleaned.replace(",", "");

        // Split into words
        String[] words = cleaned.split("\\s+");

        // Stop words
        Set<String> stopWords = new HashSet<>();

        stopWords.add("the");
        stopWords.add("was");
        stopWords.add("and");
        stopWords.add("a");
        stopWords.add("is");
        stopWords.add("of");
        stopWords.add("in");

        // Frequency map
        HashMap<String, Integer> frequency = new HashMap<>();

        for (String word : words) {

            if (stopWords.contains(word)) {
                continue;
            }

            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }

        // Convert map entries to list
        List<Map.Entry<String, Integer>> entries =
                new ArrayList<>(frequency.entrySet());

        // Sort by count descending
        entries.sort((a, b) -> b.getValue() - a.getValue());

        // Print result
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String feedback = sc.nextLine();

        printFilteredWordFrequency(feedback);

        sc.close();
    }
}
