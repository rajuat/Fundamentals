package leetcode.google;
//not completed
public class MergeKSortedList23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) return null;
        if (lists.length == 1) return lists[0];

        ListNode result = lists[0];
        for (int i = 1; i < lists.length; i++) {
            result = merge(result, lists[i]);
        }
        return result;
    }

    private ListNode merge(ListNode d, ListNode s) {
        ListNode head = d;
        ListNode dPrevious = null;

        while (d != null && s != null) {
            if (d.val <= s.val) {
                //forward d
                d = d.next;
            } else {
                //if first elem of s is smaller, create a node before d
                if (dPrevious == null) {
                    dPrevious = s;
                    dPrevious.next = d;
                    d = dPrevious;
                    s = s.next;
                } else {
                    dPrevious.next = s;
                    ListNode temp = s.next;
                    s.next = d;
                    s = temp;
                }
            }
        }
        if (s != null){
            dPrevious.next = s;
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
