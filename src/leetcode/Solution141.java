package leetcode;

/**
 * 环形链表(https://leetcode.com/problems/linked-list-cycle/)
 * Created by xsg on 2020/7/23.
 */
public class Solution141 {
    public boolean hasCycle(ListNode head) {
        ListNode first = head;
        ListNode second = head;
        while (second != null && second.next != null) {
            first = first.next;
            second = second.next.next;
            if (first == second) return true;
        }
        return false;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
