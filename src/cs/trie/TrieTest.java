package cs.trie;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TrieTest {
    @Test
    public void addWords(){
        Trie trie = new Trie();
        trie.add("abc");
        trie.add("abcd");
        trie.add("def");

        assertTrue(trie.contains("ab", false));
        assertFalse(trie.contains("ab", true));
        assertFalse(trie.contains("af", false));
    }
}
