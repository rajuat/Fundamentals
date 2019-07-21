package cs.trie;

import queuearray.QueueArray;

import java.util.*;

public class Trie {

    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void add(String word) {
        TrieNode runner = root;
        for (Character c : word.toCharArray()) {
            TrieNode node = runner.children.get(c);
            if (node == null) {
                node = new TrieNode();
                runner.children.put(c, node);
            }
            runner = node;
        }
        runner.endOfWord = true;
    }

    //incomplete
    public List<String> suggest(String word) {

        TrieNode runner = root;
        for (Character c : word.toCharArray()) {
            TrieNode node = runner.children.get(c);
            if (node == null) {
                return new ArrayList();
            } else {
                runner = node;
            }
        }
        List<StringBuilder> result = new ArrayList<>();
        int size = runner.children.size();
        Queue<StringBuilder> queue = new PriorityQueue<>();
        for (int i = 0; i < size; i++) {
            StringBuilder sb = new StringBuilder(word);
            result.add(sb);
            queue.add(sb);
        }
        while(!queue.isEmpty()){
            StringBuilder sb = queue.poll();
        }
        return null;
    }


    public boolean contains(String word, boolean exact) {
        TrieNode runner = root;
        for (Character c : word.toCharArray()) {
            TrieNode node = runner.children.get(c);
            if (node == null) {
                return false;
            } else {
                runner = node;
            }
        }
        return exact ? runner.endOfWord : true;
    }

    public void delete(String word) {
        delete(root, word, 0);
    }

    private boolean delete(TrieNode runner, String word, int index) {
        //Needs only logical deletion
        if (index == word.length()) {
            if (!runner.endOfWord) {
                return false;
            }
            runner.endOfWord = true;
            return runner.children.size() == 0;
        }
        char c = word.charAt(index);
        TrieNode node = runner.children.get(c);
        //character to be deleted doesn't exist in the trie
        if (node == null) {
            return false;
        }
        boolean shouldBeDeleted = delete(node, word, index + 1);
        //Needs physical deletion as it is independent
        if (shouldBeDeleted) {
            runner.children.remove(node);
            return runner.children.size() == 0;
        }
        return false;
    }


}
