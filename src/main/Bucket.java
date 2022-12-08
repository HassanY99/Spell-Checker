package main;

public class Bucket {

    private class Node {

        public String word;
        public Node next;

        public Node(String word, Node next) {
            this.word = word;
            this.next = next;
        }
    }

    private Node first;

//    Method to put the words in the dictionary
    public void put(String key) {
        for(Node curr = first; curr != null; curr = curr.next) {
            if(key.equals(curr.word)) {     // If word is a duplicate, already exists in the dictionary: return
                return;
            }
        }
        first = new Node(key, first);       // Add that word in the dictionary
    }

//    Method to get the words from the dictionary
    public boolean get(String key) {        // Returns true, if key/word found in the dictionary
        Node next = first;

        while(next != null) {
            if(next.word.equals(key)) {
                return true;
            }
            next = next.next;
        }
        return false;
    }
}
