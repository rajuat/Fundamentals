package cs;

import org.junit.Test;

public class ReverseLinkedList {
    @Test
    public void reverse() {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        /*ListNode r = reverse(a);
        while (r != null){
            System.out.println(r.value);
            r = r.next;
        }*/
        System.out.println("----");
        ListNode aa = reverseList(a);
        while (a != null) {
            System.out.println(a.value);
            a = a.next;
        }
    }


    ListNode reverseList(ReverseLinkedList.ListNode head) {
        ReverseLinkedList.ListNode current = head;
        ReverseLinkedList.ListNode previous = null;
        ReverseLinkedList.ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }


    public class ListNode {
        int value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }

    ListNode reverseLists(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    ListNode reverse(ListNode head) {
        ListNode previous = head;
        ListNode current = previous.next;
        while (current != null) {
            ListNode temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }

        return previous;
    }


}
