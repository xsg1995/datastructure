package linked;

/**
 * Created by xsg on 2019/5/7.
 */
public class PalindromeBaseLinked {

    public static boolean isPalindrome(SingleLinkedList singleLinkedList) {
        SingleLinkedList.Node head = singleLinkedList.getHead();
        if(head == null) {
            return false;
        }
        if(head.getNext() == null) {
            return true;
        }

        SingleLinkedList.Node backNode = head;
        SingleLinkedList.Node midNode = head;

        while (backNode.getNext() != null && backNode.getNext().getNext() != null) {
            midNode = midNode.getNext();
            backNode = backNode.getNext().getNext();
        }

        SingleLinkedList.Node rightNode = null;
        SingleLinkedList.Node leftNode = null;
        if(backNode.getNext() == null) {
            rightNode = midNode.getNext();
            leftNode = inverseLinkList(head, midNode).getNext();
        } else {
            rightNode = midNode.getNext();
            leftNode = inverseLinkList(head, midNode);
        }


        while (rightNode != null && leftNode != null) {
            if(!rightNode.getData().equals(leftNode.getData())) {
                return false;
            }
            rightNode = rightNode.getNext();
            leftNode = leftNode.getNext();
        }

        if(rightNode != null || leftNode != null) {
            return false;
        }

        return true;
    }

    private static SingleLinkedList.Node inverseLinkList(SingleLinkedList.Node head, SingleLinkedList.Node midNode) {

        SingleLinkedList.Node currentNode = head;
        SingleLinkedList.Node nextNode = null;
        SingleLinkedList.Node inverseNode = null;

        while (currentNode != midNode) {
            nextNode = currentNode.getNext();
            currentNode.setNext(inverseNode);
            inverseNode = currentNode;
            currentNode = nextNode;
        }

        currentNode.setNext(inverseNode);

        return currentNode;
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
        linkedList.insertToHead(1);
        linkedList.insertToHead(2);
        linkedList.insertToHead(3);
        linkedList.insertToHead(3);
        linkedList.insertToHead(2);
        linkedList.insertToHead(1);

        System.out.println(PalindromeBaseLinked.isPalindrome(linkedList));
    }
}
