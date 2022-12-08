package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

public class Dictionary {

    private int num = 1319; // Prime Number
    private Bucket[] bucketArray;

    private Dictionary() {

        bucketArray = new Bucket[num];

        for(int i = 0; i < num; i++) {
            bucketArray[i] = new Bucket();
        }
    }

//    Hash
    private int hash(String key) {
        return (key.hashCode() & 0x7fffffff) % num;
    }

//    add - call hash() to decide which bucket to put it in and then add the word.
    public void add(String key) {
        bucketArray[hash(key)].put(key);
    }

//    contains - call hash() to find what bucket it's in, get it from that bucket.
    public boolean contains(String input) {
        input = input.toLowerCase();
        return bucketArray[hash(input)].get(input);
    }
    int count;
//    build - reads the text from the file and keeps adding words using add()
    public void build(String filepath) throws IOException {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath));
            String word;

            while((word = bufferedReader.readLine()) != null) {
                add(word);
                System.out.println("word count: " + count++);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }
}
