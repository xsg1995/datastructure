package linked;

/**
 * 基于链表判断回文字符串
 * Created by xsg on 2019/5/7.
 */
public class PalindromeBaseLinked {

    public static boolean isPalindrome(Node head) {
        if(head == null) {
            return false;
        }
        //一个节点
        if(head.next == null) {
            return true;
        }

        Node backNode = head;
        Node midNode = head;

        while (backNode.next != null && backNode.next.next != null) {
            midNode = midNode.next;
            backNode = backNode.next.next;
        }

        Node rightNode = null;
        Node leftNode = null;
        if(backNode.next == null) {
            //奇数个节点
            rightNode = midNode.next;
            leftNode = inverseLinkList(head, midNode).next;
        } else {
            //偶数节点
            rightNode = midNode.next;
            leftNode = inverseLinkList(head, midNode);
        }


        while (rightNode != null && leftNode != null) {
            if(rightNode.data != leftNode.data) {
                return false;
            }
            rightNode = rightNode.next;
            leftNode = leftNode.next;
        }

        if(rightNode != null || leftNode != null) return false;

        return true;
    }

    private static Node inverseLinkList(Node head, Node midNode) {

        Node currentNode = head;
        Node nextNode = null;
        Node inverseNode = null;

        while (currentNode != midNode) {
            nextNode = currentNode.next;
            currentNode.next = inverseNode;
            inverseNode = currentNode;
            currentNode = nextNode;
        }

        currentNode.next = inverseNode;

        return currentNode;
    }

    private static class Node {
        int data;
        Node next;
    }

}
