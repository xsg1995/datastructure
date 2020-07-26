package leetcode;

/**
 * K 个一组翻转链表(https://leetcode.com/problems/reverse-nodes-in-k-group/)
 * Created by xsg on 2020/7/26.
 */
public class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode begin = dummyNode;
        int i = 0;
        while (head != null) {
            i++;
            if (i % k == 0) {
                begin = reverseNode(begin, head.next);
                head = begin.next;
            } else {
                head = head.next;
            }
        }
        return dummyNode.next;
    }

    public ListNode reverseNode(ListNode begin, ListNode end) {
        ListNode curr = begin.next;
        ListNode prev = null;
        ListNode next = null;
        ListNode first = curr;
        while (curr != end) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        begin.next = prev;
        first.next = end;
        return first;
    }

    public class ListNode {
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
