package main;

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

//    add
    public void add(String key) {
        bucketArray[hash(key)].put(key);
    }
}
