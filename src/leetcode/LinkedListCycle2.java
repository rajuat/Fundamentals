package leetcode;

import org.junit.Test;

public class LinkedListCycle2 {

    @Test
    public void canDetectCycle(){
        ListNode a = new ListNode(-1);
        ListNode b = new ListNode(-7);
        ListNode c = new ListNode(7);
        ListNode d = new ListNode(-4);
        ListNode e = new ListNode(19);
        ListNode f = new ListNode(6);
        ListNode g = new ListNode(-9);
        ListNode h = new ListNode(-5);
        ListNode i = new ListNode(-2);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = h;
        h.next = i;
        i.next = h;

        ListNode listNode = detectCycle(a);

    }


    public ListNode detectCycle(ListNode head) {
        ListNode slowRunner = head;
        ListNode fastRunner = head;
        while (slowRunner != null && slowRunner.next != null
                && fastRunner != null && fastRunner.next != null) {
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;
            if (slowRunner == fastRunner) {
                while (slowRunner != head) {
                    slowRunner = slowRunner.next;
                    head = head.next;
                }
                return head;
            }
        }
        return null;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}