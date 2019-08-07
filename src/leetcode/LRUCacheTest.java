package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LRUCacheTest {
    @Test
    public void canBB() {
        LRUCache146 cache = new LRUCache146(2 /* capacity */);
        cache.put(1, 1);
        cache.put(2, 2);
        assertEquals(1, cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        assertEquals(-1, cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        assertEquals(-1, cache.get(1));       // returns -1 (not found)
        assertEquals(3, cache.get(3));       // returns 3
        assertEquals(4, cache.get(4));       // returns 4
    }

    @Test
    public void can11() {
        LRUCache146 cache = new LRUCache146(2 /* capacity */);
        assertEquals(-1, cache.get(1));
        cache.put(2, 6);
        assertEquals(-1, cache.get(1));
        cache.put(1, 5);
        cache.put(1, 2);
        assertEquals(2, cache.get(1));
        assertEquals(6, cache.get(2));
    }

    @Test
    public void can111() {
        LRUCache146 cache = new LRUCache146(2 /* capacity */);
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        assertEquals(-1, cache.get(1));
        assertEquals(3, cache.get(2));
    }

}
