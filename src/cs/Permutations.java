package cs;

import org.junit.Test;

import java.util.*;

public class Permutations {

    @Test
    public void test1() {
        computeRecursive("abcd", "");
    }

    void computeRecursive(String str, String ans) {
        if (str.length() == 0) {
            System.out.print(ans + " ");
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            String ros = str.substring(0, i) + str.substring(i + 1);
            computeRecursive(ros, ans + c);
        }
    }



    void reverseList(ReverseLinkedList.ListNode head){
        if (head == null) return;
        ReverseLinkedList.ListNode current = head;
        ReverseLinkedList.ListNode previous = null;
        ReverseLinkedList.ListNode next = current.next;
        while (next != null) {
            current.next = previous;
            previous = current;
            current = next;
            next = next.next;
        }
        head = current;
    }

}
