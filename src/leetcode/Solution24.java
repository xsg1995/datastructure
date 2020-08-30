package leetcode;

/**
 * 两两交换链表中的节点(https://leetcode.com/problems/swap-nodes-in-pairs/)
 * Created by xsg on 2020/7/22.
 */
public class Solution24 {
    /**
     * dummp 为哨兵节点，dummp.next = head
     * first = dummp.next
     * second = dummp.next.next
     * if first != null && second != null
     * first.next = second.next
     * second.next = first
     * current.next = second
     * current = first
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummp = new ListNode(0);
        dummp.next = head;
        ListNode current = dummp;
        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;
            first.next = second.next;
            current.next = second;
            current.next.next = first;
            current = current.next.next;
        }
        return dummp.next;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
