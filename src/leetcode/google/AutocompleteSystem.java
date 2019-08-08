package leetcode.google;

import java.util.*;

public class AutocompleteSystem {
    class TrieNode {
        Map<Character, TrieNode> children;
        Map<String, Integer> counts;

        TrieNode() {
            children = new HashMap<>();
            counts = new HashMap<>();
        }
    }

    TrieNode root = null;
    StringBuilder prefix = new StringBuilder();

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        for (int i = 0; i < sentences.length; i++) {
            add(sentences[i], times[i]);
        }
    }

    public List<String> input(char ch) {
        if (ch == '#') {
            add(prefix.toString(), 1);
            prefix = new StringBuilder();
            return new ArrayList<String>();
        }

        TrieNode runner = root;
        prefix.append(ch);
        for (char cc : prefix.toString().toCharArray()) {
            TrieNode n = runner.children.get(cc);
            if (n == null) {
                return new ArrayList<String>();
            }
            runner = n;
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a, b) -> (a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue()));
        pq.addAll(runner.counts.entrySet());

        List<String> sentences = new ArrayList<>();
        for (int i = 0; i < 3 && !pq.isEmpty(); i++) {
            sentences.add(pq.poll().getKey());
        }
        return sentences;
    }

    void add(String sentence, int count) {
        TrieNode runner = root;
        char[] chars = sentence.toCharArray();
        for (char c : chars) {
            TrieNode n = runner.children.get(c);
            if (n == null) {
                n = new TrieNode();
                runner.children.put(c, n);
            }
            runner = n;
            runner.counts.put(sentence, runner.counts.getOrDefault(sentence, 0) + count);
        }
    }

}


