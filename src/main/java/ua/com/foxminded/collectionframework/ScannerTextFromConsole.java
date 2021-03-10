package ua.com.foxminded.collectionframework;

import java.util.Scanner;

public class ScannerTextFromConsole {
    public String scannerText() {
        System.out.println("Please enter a phrase");
        Scanner inputPhrase = new Scanner(System.in);
        String textFromConsole = inputPhrase.nextLine();
        return textFromConsole;
    }
}