package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/explore/interview/card/google/60/linked-list-5/3066/
public class CopyListWithRandomPointer {

    @Test
    public void copyNext() {
        Node b = new Node(2, null, null);
        b.random = b;
        Node a = new Node(1, b, b);
        Node c = copyRandomList(a);

        while (a != null) {
            assertEquals(a.val, c.val);
            //assertEquals(a.random.val, c.random.val);
            a = a.next;
            c = c.next;
        }


    }

    @Test
    public void copyRandomness() {
        Node b = new Node(2, null, null);
        b.random = b;
        Node a = new Node(1, b, b);
        Node c = copyRandomList(a);
        for (int i = 0; a != null && i < 5; i++) {
            assertEquals(a.val, c.val);
            a = a.random;
            c = c.random;
        }

    }

    public Node copyRandomList(Node head) {
        Node current = head;
        Node copyHead = null;
        Node copyPrevious = null;
        Map<Node, Node> map = new HashMap<>();

        while (current != null) {
            Node copyCurrent = new Node();
            map.put(current, copyCurrent);

            if (copyHead == null) {
                copyHead = copyCurrent;
            }

            copyCurrent.val = current.val;

            if (copyPrevious != null) {
                copyPrevious.next = copyCurrent;
            }

            copyPrevious = copyCurrent;
            current = current.next;
        }

        map.forEach(
                (original, copy) -> {
                    Node copyRandom = map.get(original.random);
                    copy.random = copyRandom;
                }
        );
        return copyHead;
    }


    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }
}
