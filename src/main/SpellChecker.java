package main;

import java.io.IOException;
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
}
