package leetcode.google;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/merge-k-sorted-lists/
public class MergeKSortedList23 {

    @Test
    public void merge() {
        assertEquals("-1,5,6,10,11",
                convert(
                        mergeKLists(new ListNode[]{
                                convert(new int[]{}),
                                convert(new int[]{-1, 5, 11}),
                                convert(new int[]{}),
                                convert(new int[]{6, 10})
                        })));
        /*assertEquals("1,1,2,3,4,4,5,6",
                convert(
                        mergeKLists(new ListNode[]{
                                convert(new int[]{1, 4, 5}),
                                convert(new int[]{1, 3, 4}),
                                convert(new int[]{2, 6})
                        })));
        assertEquals("1",
                convert(
                        mergeKLists(new ListNode[]{
                                convert(new int[]{}),
                                convert(new int[]{1})
                        })));
        mergeKLists(new ListNode[]{});*/
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        if (lists.length == 1) return lists[0];

        int mid = lists.length / 2;
        ListNode[] left = new ListNode[mid];
        for (int i = 0; i < mid; i++) {
            left[i] = lists[i];
        }
        ListNode[] right = new ListNode[lists.length - mid];
        for (int j = mid; j < lists.length; j++) {
            right[j - mid] = lists[j];
        }

        ListNode L = mergeKLists(left);
        ListNode R = mergeKLists(right);
        return merge(L, R);

        /*ListNode result = lists[0];
        for (int i = 1; i < lists.length; i++) {
            result = merge(lists[i], result);
        }
        return result;*/
    }

    private ListNode merge(ListNode s, ListNode d) {
        ListNode head = d;
        ListNode dp = null;

        while (d != null && s != null) {
            if (d.val <= s.val) {
                //forward d
                dp = d;
                d = d.next;
            } else {
                if (d == head) {
                    ListNode st = s.next;
                    s.next = d;
                    d = s;
                    head = s;
                    s = st;
                } else {
                    dp.next = s;
                    ListNode st = s.next;
                    s.next = d;
                    s = st;
                    dp = dp.next;
                }
            }
        }
        if (s != null) {
            if (dp != null) dp.next = s;
            else head = s;
        }
        return head;
    }

    private String convert(ListNode n) {
        StringBuilder sb = new StringBuilder();
        while (n != null) {
            sb.append(n.val);
            sb.append(',');
            n = n.next;
        }
        return sb.substring(0, sb.length() - 1);
    }

    private ListNode convert(int[] arr) {
        ListNode root = null;
        for (int i = arr.length - 1; i > -1; i--) {
            ListNode ln = new ListNode(arr[i]);
            ln.next = root;
            root = ln;
        }
        return root;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
