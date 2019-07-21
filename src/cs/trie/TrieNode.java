package cs.trie;

import java.util.HashMap;
import java.util.Map;


class TrieNode {

    Map<Character, TrieNode> children;
    boolean endOfWord;

    TrieNode(){
        children = new HashMap();
        endOfWord = false;
    }

}
