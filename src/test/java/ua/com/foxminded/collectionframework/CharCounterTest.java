package ua.com.foxminded.collectionframework;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;


class CharCounterTest {
    CharCounter startValuesForCharCounterTest;

    @BeforeEach
    void newObjectForCharCounterTest() {
        startValuesForCharCounterTest = new CharCounter();
    }

    @Test
    @DisplayName("example from task (hello world!)")
    void countUniqueCharactersShouldReturnCountUniqueCharactersWhenInputPhraseFromExampleInTask5() {
        assertEquals("hello world!\n\"h\" - 1\n\"e\" - 1\n\"l\" - 3\n\"o\" - 2\n\" \" - 1\n\"w\" - 1\n\"r\" - 1\n\"d\" - 1\n\"!\" - 1", startValuesForCharCounterTest.countUniqueCharacters("hello world!"));
    }

    @Test
    @DisplayName("one space")
    void countUniqueCharactersShouldReturnExceptionWhenInputOneSpace() {
        assertThrows(IllegalArgumentException.class, () -> startValuesForCharCounterTest.countUniqueCharacters(" "));
    }

    @Test
    @DisplayName("only spaces")
    void countUniqueCharactersShouldReturnExceptionWhenInputOnlySpaces() {
        assertThrows(IllegalArgumentException.class, () -> startValuesForCharCounterTest.countUniqueCharacters("    "));
    }

    @Test
    @DisplayName("empty value")
    void countUniqueCharactersShouldReturnExceptionWhenInputEmptyValue() {
        assertThrows(IllegalArgumentException.class, () -> startValuesForCharCounterTest.countUniqueCharacters(""));
    }

    @Test
    @DisplayName("used null")
    void countUniqueCharactersShouldReturnExceptionWhenUsedNull() {
        assertThrows(IllegalArgumentException.class, () -> startValuesForCharCounterTest.countUniqueCharacters(null));
    }

    @Test
    @DisplayName("one letter")
    void countUniqueCharactersShouldReturnResultCountUniqueCharactersWhenInputOneLetter (){
        assertEquals("b\n\"b\" - 1", startValuesForCharCounterTest.countUniqueCharacters("b"));
    }

    @Test
    @DisplayName("several identical letters")
    void countUniqueCharactersShouldReturnResultCountUniqueCharactersWhenInputSeveralIdenticalLetters (){
        assertEquals("bbbbbbb\n\"b\" - 7", startValuesForCharCounterTest.countUniqueCharacters("bbbbbbb"));
    }

    @Test
    @DisplayName("word of only lowercase letters with repeating letters")
    void countUniqueCharactersShouldReturnResultCountUniqueCharactersWhenInputWordOfOnlyLowercaseLettersWithRepeatingLetters (){
        assertEquals("qweasdqwe\n\"q\" - 2\n\"w\" - 2\n\"e\" - 2\n\"a\" - 1\n\"s\" - 1\n\"d\" - 1", startValuesForCharCounterTest.countUniqueCharacters("qweasdqwe"));
    }

    @Test
    @DisplayName("word of only large letters with repeating letters")
    void countUniqueCharactersShouldReturnResultCountUniqueCharactersWhenInputWordOfOnlyLargeLettersWithRepeatingLetters (){
        assertEquals("QWEASDQWE\n\"Q\" - 2\n\"W\" - 2\n\"E\" - 2\n\"A\" - 1\n\"S\" - 1\n\"D\" - 1", startValuesForCharCounterTest.countUniqueCharacters("QWEASDQWE"));
    }


    @Test
    @DisplayName("Word in different case with repeating letters")
    public void countUniqueCharactersShouldReturnResultCountUniqueCharactersWhenInputWordInDifferentCaseWithRepeatingLetters(){
        assertEquals( "QEasdQWassA\n\"Q\" - 2\n\"E\" - 1\n\"a\" - 2\n\"s\" - 3\n\"d\" - 1\n\"W\" - 1\n\"A\" - 1", startValuesForCharCounterTest.countUniqueCharacters("QEasdQWassA"));
    }

    @Test
    @DisplayName("1 letter in different case")
    public void countUniqueCharactersShouldReturnResultCountUniqueCharactersWhenInput1LetterInDifferentCase(){
        assertEquals( "qqqqQQQQqQQ\n\"q\" - 5\n\"Q\" - 6", startValuesForCharCounterTest.countUniqueCharacters("qqqqQQQQqQQ"));
    }

    @Test
    @DisplayName("only symbols with repeating, without letters")
    public void countUniqueCharactersShouldReturnResultCountUniqueCharactersWhenInputOnlySymbolsWithRepeating(){
        assertEquals( "№;%:#$%*&^%%^&?\n\"№\" - 1\n\";\" - 1\n\"%\" - 4\n\":\" - 1\n\"#\" - 1\n\"$\" - 1\n\"*\" - 1\n\"&\" - 2\n\"^\" - 2\n\"?\" - 1", startValuesForCharCounterTest.countUniqueCharacters("№;%:#$%*&^%%^&?"));
    }

    @Test
    @DisplayName("symbols and letters with repeating")
    public void countUniqueCharactersShouldReturnResultCountUniqueCharactersWhenInputSymbolsAndLettersWithRepeating(){
        assertEquals( "@#$%bhsdaass#$%\n\"@\" - 1\n\"#\" - 2\n\"$\" - 2\n\"%\" - 2\n\"b\" - 1\n\"h\" - 1\n\"s\" - 3\n\"d\" - 1\n\"a\" - 2", startValuesForCharCounterTest.countUniqueCharacters("@#$%bhsdaass#$%"));
    }

    @Test
    @DisplayName("only numbers with repeating")
    public void countUniqueCharactersShouldReturnResultCountUniqueCharactersWhenInputOnlyNumbersWithRepeating(){
        assertEquals( "123123\n\"1\" - 2\n\"2\" - 2\n\"3\" - 2", startValuesForCharCounterTest.countUniqueCharacters("123123"));
    }
}