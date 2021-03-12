package ua.com.foxminded.collectionframework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class CharCounter {

    private static final Map<String, String> CACHE = new HashMap<>();

    public static void main(String[] args) {
        CharCounter example = new CharCounter();
        System.out.println(example.countUniqueCharacters("hello world!"));
    }


    public String countUniqueCharacters(String phrase) {

        checkForExceptions(phrase);

        if (CACHE.containsKey(phrase)) {
            return CACHE.get(phrase);
        }

        Map<Character, Integer> counted = count(phrase);
        String result = combineString(counted, phrase);

        CACHE.put(phrase, result);
        return result;
    }

    private Map count(String phrase) {

        ArrayList<Character> allCharacters = new ArrayList<>();
        char[] splittingIntoCharacters = phrase.toCharArray();
        for (int i = 0; i < splittingIntoCharacters.length; i++) {
            allCharacters.add(splittingIntoCharacters[i]);
        }

        Map<Character, Integer> counted = new LinkedHashMap<>();
        allCharacters.forEach(symbol ->
                counted.merge(symbol, 1, (oldVal, newVal) -> oldVal + newVal)
        );
        return counted;
    }

    private String combineString(Map<Character, Integer> countedUniqueCharacters, String phrase) {

        String result = phrase + "\n";
        for (Entry entry : countedUniqueCharacters.entrySet()) {
            result += "\"" + entry.getKey() + "\"" + " - " + entry.getValue() + "\n";
        }
        result = result.replaceAll("[\n]+$", "");
        return result;

    }

    private void checkForExceptions(String phrase) {
        if (phrase == null || phrase.isEmpty()) {
            throw new IllegalArgumentException("Empty input");
        }
        if (phrase.trim().isEmpty()) {
            throw new IllegalArgumentException("Only spaces cannot be used");
        }
    }
}