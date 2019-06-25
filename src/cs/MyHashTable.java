package cs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyHashTable {

    @Test
    public void canUseMyHashMap() {
        long s = System.nanoTime();
        MyHashTable map = new MyHashTable();
        map.put("abc", "abc");
        map.put("acb", "acb");
        map.put("cab", "cab");
        map.put("abcd", "abcd");
        map.put("abce", "abce");

        assertEquals("abc", map.get("abc"));
        assertEquals("acb", map.get("acb"));
        assertEquals("cab", map.get("cab"));
        assertEquals("abcd", map.get("abcd"));
        assertEquals("abce", map.get("abce"));

        System.out.println("Time in ns: " + (System.nanoTime() - s));
    }

    private int length = 128;
    private LinkedListNode[] hashTable = new LinkedListNode[length];

    public void put(String key, String value) {
        int hash = hash(key);
        int index = hash % length;
        LinkedListNode node = hashTable[index];
        LinkedListNode newNode = new LinkedListNode(key, value);
        if (node == null) {
            hashTable[index] = newNode;
        } else {
            while (node.next != null) {
                node = node.next;
            }
            node.next = newNode;
        }
    }

    public String get(String key) {
        int hash = hash(key);
        int index = hash % length;
        LinkedListNode node = hashTable[index];
        while (node != null) {
            if (key.equals(node.key)) return node.value;
            node = node.next;
        }
        return null;
    }

    private int hash(String key) {
        int mul = 2;
        int sum = 0;
        for (char c : key.toCharArray()) {
            sum += c * mul++;
        }
        return sum;
    }

    class LinkedListNode {
        private String key;
        private String value;
        private LinkedListNode next;

        public LinkedListNode(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
}
