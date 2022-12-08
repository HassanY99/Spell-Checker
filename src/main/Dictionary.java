package main;

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
}
