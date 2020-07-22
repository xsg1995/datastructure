package leetcode;

/**
 * 反转链表(https://leetcode-cn.com/problems/reverse-linked-list/)
 * Created by xsg on 2020/7/22.
 */
public class Solution206 {

    public ListNode reverseList(ListNode head) {
        ListNode reverse = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = reverse;
            reverse = head;
            head = next;
        }
        return reverse;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode node = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
