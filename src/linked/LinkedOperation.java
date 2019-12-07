package linked;

import java.util.HashMap;
import java.util.Map;

public class LinkedOperation {

    /**
     * 链表反转
     * @param origLinked
     * @return
     */
    public static void reverse(SingleLinkedList origLinked) {

        if(origLinked != null) {
            SingleLinkedList.Node currentNode = origLinked.getHead();
            SingleLinkedList.Node inverseNode = null;
            SingleLinkedList.Node nextNode;
            while (currentNode.getNext() != null) {
                nextNode = currentNode.getNext();
                currentNode.setNext(inverseNode);
                inverseNode = currentNode;
                currentNode = nextNode;
            }
            currentNode.setNext(inverseNode);
            origLinked.setHead(currentNode);
        }
    }

    /**
     * 环检测
     * @param origLinked
     * @return
     */
    public static boolean isCircle(SingleLinkedList origLinked) {
        if(origLinked != null) {
            Map<SingleLinkedList.Node, Boolean> nodesMap = new HashMap<>();
            SingleLinkedList.Node currentNode = origLinked.getHead();
            while (currentNode != null) {
                if(nodesMap.get(currentNode) != null && nodesMap.get(currentNode)) {
                    return true;
                } else {
                    nodesMap.put(currentNode, Boolean.TRUE);
                }
                currentNode = currentNode.getNext();
            }
        }

        return false;
    }

    /**
     * 有序链表合并
     * @param firstLinked
     * @param secondLinked
     * @return
     */
    public static SingleLinkedList<String> mergeSortLinked(SingleLinkedList<String> firstLinked, SingleLinkedList<String> secondLinked) {
        SingleLinkedList<String> targetLinked = new SingleLinkedList();
        if(firstLinked == null && secondLinked == null) {
            return targetLinked;
        }

        SingleLinkedList.Node<String> firstCurrentNode = firstLinked != null ? firstLinked.getHead() : null;
        SingleLinkedList.Node<String> secondCurrentNode = secondLinked != null ? secondLinked.getHead() : null;

        while (firstCurrentNode != null && secondCurrentNode != null) {
            if(firstCurrentNode.getData().compareTo(secondCurrentNode.getData()) <= 0) {
                targetLinked.insertTail(firstCurrentNode.getData());
                firstCurrentNode = firstCurrentNode.getNext();
            } else {
                targetLinked.insertTail(secondCurrentNode.getData());
                secondCurrentNode = secondCurrentNode.getNext();
            }
        }

        SingleLinkedList.Node<String> currentNode = firstCurrentNode;
        if(secondCurrentNode != null) {
            currentNode = secondCurrentNode;
        }

        for(; currentNode != null; currentNode = currentNode.getNext()) {
            targetLinked.insertTail(currentNode.getData());
        }

        return targetLinked;
    }

    /**
     * 取链表的中间节点
     * @param singleLinkedList
     * @return
     */
    public static SingleLinkedList.Node middleNode(SingleLinkedList singleLinkedList) {
        if(singleLinkedList == null) {
            return null;
        }
        SingleLinkedList.Node firstNode = singleLinkedList.getHead();
        SingleLinkedList.Node secondNode = singleLinkedList.getHead();
        while (firstNode != null && (secondNode != null && secondNode.getNext() != null)) {
            firstNode = firstNode.getNext();
            secondNode = secondNode.getNext().getNext();
        }
        return firstNode;
    }

    public static void main(String[] args) {
//        SingleLinkedList<String> origLinked = new SingleLinkedList<>();
        //链表倒置
//        origLinked.insertTail("a");
//        origLinked.insertTail("b");
//        origLinked.insertTail("c");
//        origLinked.insertTail("d");
//        origLinked.insertTail("e");
//
//        origLinked.printAll();
//        reverse(origLinked);
//        origLinked.printAll();

        //环链表检测
//        SingleLinkedList.Node<String> nodec = new SingleLinkedList.Node<>("c", null);
//        SingleLinkedList.Node<String> nodeb = new SingleLinkedList.Node<>("b", nodec);
//        SingleLinkedList.Node<String> nodea = new SingleLinkedList.Node<>("a", nodeb);
//        nodec.setNext(nodea);
//
//        origLinked.setHead(nodea);
//        System.out.println(isCircle(origLinked));

        //有序链表合并
//        SingleLinkedList<String> firstLinked = new SingleLinkedList<>();
//        firstLinked.insertTail("a");
//        firstLinked.insertTail("c");
//        firstLinked.insertTail("e");
//        firstLinked.insertTail("g");
//        firstLinked.insertTail("i");
//
//        SingleLinkedList<String> secondLinked = new SingleLinkedList<>();
//        secondLinked.insertTail("b");
//        secondLinked.insertTail("d");
//        secondLinked.insertTail("f");
//        secondLinked.insertTail("h");
//        secondLinked.insertTail("j");
//
//        SingleLinkedList<String> mergeSortLinked = mergeSortLinked(firstLinked, secondLinked);
//        mergeSortLinked.printAll();

        //取链表中间节点
        SingleLinkedList<String> singleLinkedList = new SingleLinkedList<>();

        singleLinkedList.insertTail("a");
        singleLinkedList.insertTail("b");
        singleLinkedList.insertTail("c");
        singleLinkedList.insertTail("d");
        singleLinkedList.insertTail("e");
        singleLinkedList.insertTail("f");

        System.out.println(middleNode(singleLinkedList).getData());
    }
}
