package leetcode;

/**
 * 合并两个有序链表(https://leetcode-cn.com/problems/merge-two-sorted-lists/)
 * Created by xsg on 2020/8/3.
 */
public class Solution21 {

    /**
     * 使用递归实现
     * 如果 l1 == null ，则返回有序链表 l2
     * 如果 l2 == null ，则返回有序链表 l1
     * 如果 l1.val < l2.val，则 l1 当前节点较小，则取 l1.next 与 l2 的较小者为下一个值，返回l1
     * 如果 l1.val >= l2.val，则 l2.val 当前节点较小，则取 l1 与 l2.next 的较小者为下一个值，返回 l2
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }

    /**
     * 创建一个哨兵节点 head
     * 遍历 l1 与 l2，取 l1 与 l2 中的较小节点，拼接到 head 的后面
     * 最后返回 head.next
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) cur.next = l1;
        if (l2 != null) cur.next = l2;

        return head.next;
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
