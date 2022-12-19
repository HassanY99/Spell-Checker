package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SpellChecker {

    private Dictionary dictionary;
    private char[] alphabets = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private String filepath = "engmix.txt";

    SpellChecker() throws IOException {
        dictionary = new Dictionary();
        dictionary.build(filepath);
    }

    void checksWord() {
        Scanner scan = new Scanner(System.in);
        String input;

        System.out.println("-----------------------------------------------------");
        System.out.println("            Welcome to Spell Checker        ");
        System.out.println("-----------------------------------------------------");

        while(true) {
            System.out.print("\n---Enter a word: ");
            input = scan.nextLine();

            if (input.equals("")) {
                break;
            }
            if (dictionary.contains(input)) {
                System.out.println("\n" + "'" + input + "'" + " is spelled correctly");
            } else {
                System.out.println("'" + input + "'" + " is not spelled correctly.");
                System.out.println(printSuggestions(input));
            }
        }
    }

    void checksSentence() {
        Scanner scan = new Scanner(System.in);
        String input;

        System.out.println("-----------------------------------------------------");
        System.out.println("            Welcome to Spell Checker        ");
        System.out.println("-----------------------------------------------------");

        int count = 1;
        while(true) {
            System.out.print("\n---Enter a Sentence: ");
            input = scan.next();
            count++;

            if (input.length() == count) {
                break;
            }
            if (dictionary.contains(input)) {
                System.out.println("\n" + "'" + input + "'" + " is spelled correctly");
            } else {
                System.out.println("'" + input + "'" + " is not spelled correctly.");
                System.out.println(printSuggestions(input));
            }
        }
    }

    void checksWordsInFile() throws IOException {

        String filepath = "text.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath));

        try {
            String input;
            input = bufferedReader.readLine();
            Scanner scan = new Scanner(input);


            System.out.println("-----------------------------------------------------");
            System.out.println("            Welcome to Spell Checker        ");
            System.out.println("-----------------------------------------------------");

            System.out.print("\n---Enter a Sentence: ");

            while (scan.hasNext()) {

                input = scan.next();

                if (!dictionary.contains(input)) {
                    System.out.println("\n__________________________________________________");
                    System.out.println("'" + input + "'" + " is not spelled correctly.");
                    System.out.println(printSuggestions(input));
                    System.out.println("_________________________________");
                }
            }
        } catch (IOException ioException) {

            ioException.printStackTrace();
        }
    }

    public String printSuggestions(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<String> suggestions = suggestedWords(input);

        if(suggestions.size() == 0) {
            return "My program seems to think it's not a word.";
        }
        stringBuilder.append("----- Did you mean: -----\n");
        for(String s : suggestions) {
            stringBuilder.append("\n -> " + s);
        }
        System.out.println("_________________________________");
        return stringBuilder.toString();
    }
    public ArrayList<String> suggestedWords(String input) {
        ArrayList<String> allPossibleWords = new ArrayList<>();

        allPossibleWords.addAll(charAppendPrepend(input));
        allPossibleWords.addAll(charMissingInBetween(input));
        allPossibleWords.addAll(removesExtraLetter(input));
        allPossibleWords.addAll(swapAdjChar(input));

        return allPossibleWords;
    }

//    1. append & prepend char - if user misses a letter either in the front or back of the word.

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

//    2. add missing letter in between - if user misses a letter in between the word excluding the first and last letter
    public ArrayList<String> charMissingInBetween(String input) {
        ArrayList<String> returnWords = new ArrayList<>();

        int length = input.length();

        for(int i = 1; i < length; i++) {
            for(char c : alphabets) {
                String word = input.substring(0, i);
                word = word.concat(c + input.substring(i));

                if(dictionary.contains(word)) {
                    returnWords.add(word);
                }
            }
        }
        return returnWords;
    }

//    3. remove extra letter in the word - if users accidentally adds an extra letter at the front, end or in between the word.
    public ArrayList<String> removesExtraLetter(String input) {
        ArrayList<String> returnWords = new ArrayList<>();

        int length = input.length() - 1;

        if(dictionary.contains(input.substring(1)) && !returnWords.contains(input.substring(1))) {       //  removes extra letter from the front
            if(input.substring(1).length() > 2 ) {
                returnWords.add(input.substring(1));
            }
        }

        for(int i = 1; i < length; i++) {               //  removes extra letter from the middle

                String word = input.substring(0, i);
                word = word.concat(input.substring(i + 1));

                if(dictionary.contains(word) && !returnWords.contains(word)) {
                    returnWords.add(word);
                }
        }

        if(dictionary.contains(input.substring(0, length)) && !returnWords.contains(input.substring(1))) {       //  removes extra letter from the end
            if(input.substring(0, length).length() > 2) {
                returnWords.add(input.substring(0, length));
            }
        }
        return returnWords;
    }

//    4. Swap adjacent characters - example heard -- haerd -> If user accidentally swaps letter in the word
    public ArrayList<String> swapAdjChar(String input) {
        ArrayList<String> returnWords = new ArrayList<>();

        int length = input.length() - 1;

        for(int i = 0; i < length; i++) {
            String word = input.substring(0, i);
            word = word + input.charAt(i + 1);
            word = word + input.charAt(i);
            word = word + input.substring(i + 2);

            if(dictionary.contains(word)) {
                returnWords.add(word);
            }
        }
        return returnWords;
    }

}
