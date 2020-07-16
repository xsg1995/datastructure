package algorithm;

import linked.SingleLinkedList;

/**
 * K个一组翻转链表
 * Created by xsg on 2020/1/12.
 */
public class ReverseLinkedList<reverse> {
    public static void main(String[] args) {
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
        linkedList.insertTail(1);
        linkedList.insertTail(2);
        linkedList.insertTail(3);
        linkedList.insertTail(4);
        linkedList.insertTail(5);
        linkedList.insertTail(6);
        linkedList.insertTail(7);
        linkedList.insertTail(8);

        linkedList.printAll();

        int k = 7;
        reverse(linkedList, k);
        System.out.println("--------------------------");
        linkedList.printAll();
    }

    public static void reverse(SingleLinkedList linkedList, int k) {
        SingleLinkedList.Node head = linkedList.getHead();
        SingleLinkedList.Node prev = null;
        SingleLinkedList.Node curr = head;
        SingleLinkedList.Node next = null;

        while (curr != null && k > 0) {
            next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;

            k--;
        }
        head.setNext(curr);
        linkedList.setHead(prev);
    }
}
