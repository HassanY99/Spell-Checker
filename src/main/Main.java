package main;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        SpellChecker spellChecker = new SpellChecker();
//        spellChecker.checksWord();

//        spellChecker.checksSentence();

        spellChecker.checksWordsInFile();

    }
}
