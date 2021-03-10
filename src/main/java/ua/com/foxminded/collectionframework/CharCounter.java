package ua.com.foxminded.collectionframework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CharCounter {
    Map<String, String> collectionCharCounter = new HashMap<>();

    private void addToTheMapCollection(String phrase, String uniqueCharactersInPhrase) {
        ScannerTextFromConsole textForCharCounter = new ScannerTextFromConsole();
        collectionCharCounter.put(phrase, uniqueCharactersInPhrase);
    }


    public String countUniqueCharacters(String phraseToCountUniqueCharacters) {

        checkForExceptions(phraseToCountUniqueCharacters);

        if (collectionCharCounter.containsKey(phraseToCountUniqueCharacters)) {
            return collectionCharCounter.get(phraseToCountUniqueCharacters);
        } else {
            char[] arrayOfAllCharactersInString = phraseToCountUniqueCharacters.toCharArray();
            ArrayList<Character> uniqueCharacters = getArrayOfOnlyUniqueCharacters(phraseToCountUniqueCharacters);
            int numberOfReiteration = 0;
            String numberOfUniqueCharactersInString = phraseToCountUniqueCharacters + "\n";
            int i = 0;
            while (i < uniqueCharacters.size()) {
                for (int j = 0; j < arrayOfAllCharactersInString.length; j++) {
                    if (uniqueCharacters.get(i) == arrayOfAllCharactersInString[j]) {
                        numberOfReiteration++;
                    }
                }
                if (i == uniqueCharacters.size() - 1) {
                    numberOfUniqueCharactersInString += "\"" + uniqueCharacters.get(i) + "\"" + " - " + numberOfReiteration;
                    break;
                }
                numberOfUniqueCharactersInString += "\"" + uniqueCharacters.get(i) + "\"" + " - " + numberOfReiteration + "\n";
                numberOfReiteration = 0;
                i++;
            }
            addToTheMapCollection(phraseToCountUniqueCharacters, numberOfUniqueCharactersInString);
            return numberOfUniqueCharactersInString;
        }
    }

    private ArrayList getArrayOfOnlyUniqueCharacters(String phrase) {
        ArrayList<Character> uniqueCharacters = new ArrayList<>();
        char[] splittingStringIntoCharacters = phrase.toCharArray();

        for (int i = 0; i < splittingStringIntoCharacters.length; i++) {
            uniqueCharacters.add(splittingStringIntoCharacters[i]);
        }

        for (int j = 0; j < uniqueCharacters.size() - 1; j++) {
            int i = j + 1;
            while (i < uniqueCharacters.size()) {
                if (uniqueCharacters.get(j) == uniqueCharacters.get(i)) {
                    uniqueCharacters.remove(i);
                } else {
                    i++;
                }
            }
        }
        return uniqueCharacters;
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