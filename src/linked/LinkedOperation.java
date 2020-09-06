package linked;

/**
 * 链表相关操作
 */
public class LinkedOperation {

    /**
     * 链表反转
     * @param head 原始链表
     * @return 反转后的链表
     */
    public Node reverse(Node head) {
        if (head == null) return null;

        Node cur = head;
        Node inverseNode = null;
        Node next;
        while (cur != null) {
            next = cur.next;
            cur.next = inverseNode;
            inverseNode = cur;
            cur = next;
        }
        return inverseNode;
    }

    /**
     * 环形链表检测
     * @param head head
     * @return true or false
     */
    public boolean isCircle(Node head) {
        Node first = head;
        Node second = head;
        while (second != null && second.next != null) {
            first = first.next;
            second = second.next.next;
            if (first == second) return true;
        }

        return false;
    }

    /**
     * 有序链表合并
     */
    public Node mergeSortLinked(Node first, Node second) {
        if (first == null) {
            return second;
        } else if (second == null) {
            return first;
        } else if (first.val <= second.val) {
            first.next = mergeSortLinked(first.next, second);
            return first;
        } else {
            second.next = mergeSortLinked(first, second.next);
            return second;
        }
    }

    /**
     * 有序链表的合并
     */
    public Node mergeSortLinked2(Node first, Node second) {
        Node head = new Node(-1);
        Node cur = head;
        while (first != null && second != null) {
            if (first.val <= second.val) {
                cur.next = first;
                first = first.next;
            } else {
                //second.val < first.val
                cur.next = second;
                second = second.next;
            }
            cur = cur.next;
        }
        if (first == null) {
            cur.next = second;
        } else {
            cur.next = first;
        }
        return head.next;
    }

    /**
     * 取链表的中间节点
     */
    public Node middleNode(Node node) {
        Node first = node;
        Node second = node;
        while (second != null && second.next != null) {
            first = first.next;
            second = second.next.next;
        }
        return first;
    }

    private static class Node {
        int val;
        Node next;

        public Node() {}
        public Node(int val) {
            this.val = val;
        }
    }

}
