package leetcode;


import org.junit.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class LRUCache146 {
    private int capacity;
    private int size;
    private Map<Integer, Node> cache;
    //private MyHashMap mycache;

    public LRUCache146(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        //mycache = new MyHashMap(capacity);
        size = 0;
    }

    public int get(int key) {
        Node node = cache.get(key);
        //Node node = mycache.get(key);
        if (node == null) return -1;
        node.timeStamp = System.nanoTime();
        cache.put(key, node);
        //mycache.put(key, node);
        return node.val;
    }

    public void put(int key, int value) {
        if (size == capacity && cache.get(key) == null) {
            //if (size == capacity && mycache.get(key) == null) {
            Node lru = cache.values().stream().min(Comparator.comparingLong(x -> x.timeStamp)).get();
            cache.remove(lru.key);
            //mycache.remove(mycache.lruKey());
            size--;
        }
        if (cache.get(key) == null) size++;
        //if (mycache.get(key) == null) size++;
        Node n = new Node(key, value, System.nanoTime());
        cache.put(key, n);
        //mycache.put(key, n);
    }

    class Node {
        int key;
        int val;
        long timeStamp;
        Node next;

        Node(int key, int val, long timeStamp) {
            this.key = key;
            this.val = val;
            this.timeStamp = timeStamp;
        }
    }

    class MyHashMap {
        Node[] map;
        KeyTimestamp[] lru;
        int capacity = 0;

        MyHashMap(int capacity) {
            this.map = new Node[capacity];
            this.lru = new KeyTimestamp[capacity];
            this.capacity = capacity;
        }

        void put(int key, Node n) {
            int k = hash(key);
            Node node = map[k];
            if (node != null) {
                while (node.next != null) {
                    //override
                    if (node.key == key) {
                        node.val = n.val;
                        node.timeStamp = n.timeStamp;
                        return;
                    }
                    node = node.next;
                }
                node.next = n;
            } else {
                map[k] = n;
            }
        }

        Node get(int key) {
            int k = hash(key);
            Node n = map[k];
            while (n != null) {
                if (n.key == key) {
                    return n;
                }
                n = n.next;
            }
            return null;
        }

        int lruKey() {
            long lru = Long.MAX_VALUE;
            int key = -1;
            for (int i = 0; i < capacity; i++) {
                Node n = map[i];
                while (n != null) {
                    if (n.timeStamp < lru) {
                        lru = n.timeStamp;
                        key = n.key;
                    }
                    n = n.next;
                }
            }
            return key;
        }

        void remove(int key) {
            int k = hash(key);
            Node current = map[k];
            Node previous = null;
            while (current != null) {
                if (current.key == key) {
                    if (previous == null) {
                        map[k] = current.next;
                    } else {
                        previous.next = current.next;
                    }
                    return;
                }
                previous = current;
                current = current.next;
            }
            return;
        }

        private int hash(int key) {
            return key % capacity;
        }

        class KeyTimestamp {
            int key;
            long timestamp;
        }
    }
}
