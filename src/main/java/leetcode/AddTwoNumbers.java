package leetcode;

import org.junit.Test;

public class AddTwoNumbers {


    @Test
    public void canAdd() {
        ListNode l11 = new ListNode(5);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(3);
        /*l11.next = l12;
        l12.next = l13;
        l13.next = null;*/

        ListNode l21 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(4);
        /*l21.next = l22;
        l22.next = l23;
        l23.next = null;*/

        ListNode l3 = addTwoNumbers(l11, l21);
        while (l3 != null) {
            System.out.println("Value:" + l3.val);
            l3 = l3.next;
        }
    }

    private ListNode head = new ListNode(-1);
    private ListNode running = new ListNode(-1);
    private int carry = 0;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        head.next = running;
        while (l1 != null && l2 != null) {
            createNode(l1.val, l2.val);
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            createNode(l1.val, 0);
            l1 = l1.next;
        }
        while (l2 != null) {
            createNode(0, l2.val);
            l2 = l2.next;
        }
        if (carry == 1) {
            carry = 0;
            createNode(1,0);
        }
        return head.next.next;
    }

    private void createNode(int l1Value, int l2Value) {
        int digitSum = l1Value + l2Value + carry;
        if (digitSum > 9) {
            digitSum %= 10;
            carry = 1;
        } else {
            carry = 0;
        }
        ListNode node = new ListNode(digitSum);
        running.next = node;
        running = node;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
