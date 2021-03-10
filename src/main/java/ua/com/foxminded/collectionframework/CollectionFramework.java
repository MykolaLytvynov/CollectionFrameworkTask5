package ua.com.foxminded.collectionframework;


public class CollectionFramework {
    public static void main(String[] args) {

        CharCounter exampleForCharCounter = new CharCounter();
        ScannerTextFromConsole consoleInput = new ScannerTextFromConsole();

        System.out.println(exampleForCharCounter.countUniqueCharacters(consoleInput.scannerText()));
        System.out.println(exampleForCharCounter.countUniqueCharacters(consoleInput.scannerText()));
        System.out.println(exampleForCharCounter.countUniqueCharacters(consoleInput.scannerText()));
    }
}