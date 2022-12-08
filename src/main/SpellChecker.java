package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpellChecker {

    private Dictionary dictionary;
    private char[] alphabets = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private String filepath = "wordlist.10000.txt";

    SpellChecker() throws IOException {
        dictionary = new Dictionary();
        dictionary.build(filepath);
    }

    void run() {
        Scanner scan = new Scanner(System.in);
        String input;

        System.out.println("-----------------------------------------------------");
        System.out.println("            Welcome to Spell Checker        ");
        System.out.println("-----------------------------------------------------");

        while(true) {
            System.out.println("\n --- Enter a word:  ");
            input = scan.nextLine();

            if(input.equals("")) {
                break;
            }
            if(dictionary.contains(input)) {
                System.out.println("\n" + input + " is spelled correctly");
            } else {
                System.out.println("is not spelled correctly, ");
            }
        }
    }


//    1. append & prepend char - if user misses a letter either in the front, back of the word or both.

    public ArrayList<String> charAppendPrepend(String input) {
        ArrayList<String> returnWords = new ArrayList<>();

        for(char c : alphabets) {
            String atFront = c + input;
            String atBack = input + c;

            if(dictionary.contains(atFront)) {
                returnWords.add(atFront);
            }
            if(dictionary.contains(atBack)) {
                returnWords.add(atBack);
            }
        }
        return returnWords;
    }

}
