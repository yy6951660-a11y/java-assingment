import java.util.*;

public class Main {

    // 1. ATM PIN Length Validator
    static void checkPinLength(String pin) {
        if (pin.length() != 4) {
            System.out.println("Invalid PIN — must be exactly 4 digits.");
        } else {
            System.out.println("PIN length OK.");
        }
    }

    // 2. Word Reversal Encoder
    static String reverseEachWord(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            StringBuilder reversed = new StringBuilder(words[i]);
            reversed.reverse();

            result.append(reversed);

            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    // 3. Product Inventory CSV Parser
    static void parseInventoryRecord(String csvLine) {
        String[] fields = csvLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        System.out.println(
            "Product: " + fields[0] +
            " | SKU: " + fields[1] +
            " | Qty: " + fields[2]
        );
    }

    // 4. Library ISBN Normalizer
    static String normalizeCode(String raw) {
        String code = raw.trim();

        if (code.length() < 3) {
            return code;
        }

        String publisher = code.substring(0, 3).toUpperCase();
        String remaining = code.substring(3);

        return publisher + remaining;
    }

    // 4. Library ISBN Validator & Formatter
    static String validateAndFormat(String code) {

        // Check length
        if (code.length() != 13) {
            return "Invalid: wrong length";
        }

        // Check first 3 characters are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        // Check remaining 10 characters are digits
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: body must contain only digits";
            }
        }

        String publisher = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);

        StringBuilder result = new StringBuilder();

        result.append("[")
              .append(publisher)
              .append("] YEAR: ")
              .append(year)
              .append(" | CATALOG: ")
              .append(catalog);

        return result.toString();
    }

    // 5. Stop-Word-Filtered Word Frequency Report
    static void printFilteredWordFrequency(String feedback) {

        String[] stopWords = {
            "the", "was", "and", "a", "is", "of", "in"
        };

        // Normalize text
        String cleaned = feedback
                .toLowerCase()
                .replace(".", "")
                .replace(",", "");

        // Split using whitespace
        String[] words = cleaned.split("\\s+");

        // Count words
        HashMap<String, Integer> frequency = new HashMap<>();

        for (String word : words) {

            boolean isStopWord = false;

            for (String stop : stopWords) {
                if (word.equals(stop)) {
                    isStopWord = true;
                    break;
                }
            }

            if (!isStopWord) {
                frequency.put(
                    word,
                    frequency.getOrDefault(word, 0) + 1
                );
            }
        }

        // Convert map entries to list
        List<Map.Entry<String, Integer>> entries =
                new ArrayList<>(frequency.entrySet());

        // Sort by count descending
        entries.sort(
            (a, b) -> b.getValue().compareTo(a.getValue())
        );

        // Print result
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(
                entry.getKey() + ": " + entry.getValue()
            );
        }
    }

    public static void main(String[] args) {

        // -----------------------------
        // Problem 1
        // -----------------------------
        System.out.println("1. ATM PIN Length Validator");

        checkPinLength("482");
        checkPinLength("4820");

        // -----------------------------
        // Problem 2
        // -----------------------------
        System.out.println("\n2. Word Reversal Encoder");

        String sentence = "hello club";
        System.out.println(reverseEachWord(sentence));

        // -----------------------------
        // Problem 3
        // -----------------------------
        System.out.println("\n3. Product Inventory CSV Parser");

        parseInventoryRecord("Wireless Mouse,WM-2201,150");
        parseInventoryRecord("Wireless Mouse,150");

        // -----------------------------
        // Problem 4
        // -----------------------------
        System.out.println("\n4. Library ISBN Normalizer & Validator");

        String rawCode = " pen2026004251 ";

        String normalizedCode = normalizeCode(rawCode);

        System.out.println(
            validateAndFormat(normalizedCode)
        );

        String invalidCode = normalizeCode("12N2026004251");

        System.out.println(
            validateAndFormat(invalidCode)
        );

        // -----------------------------
        // Problem 5
        // -----------------------------
        System.out.println("\n5. Stop-Word-Filtered Word Frequency");

        String feedback =
            "The mentor was great, the session was great and clear.";

        printFilteredWordFrequency(feedback);
    }
}
