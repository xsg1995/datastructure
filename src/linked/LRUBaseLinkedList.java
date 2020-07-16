package linked;

import java.util.Scanner;

/**
 * Created by xsg on 2019/5/5.
 */
public class LRUBaseLinkedList<T> {

    //链表的容量
    private int capacity;
    //链表存放数据的大小
    private int size;
    //头结点
    private Node head;

    public LRUBaseLinkedList() {
        //默认容量为10
        this(10);
    }

    public LRUBaseLinkedList(int capacity) {
        this.head = new Node();
        this.capacity = capacity;
        this.size = 0;
    }

    /**
     * 添加一个数据
     * @param e
     */
    public void add(T e) {
        Node preNode = findPreNode(e);

        if(preNode != null) {
            //节点在链表中存在，删除节点，然后在头部插入节点
            removeNextNode(preNode);
            insertNodeBegin(e);
        } else {
            //链表满了，则删除最后一个节点，并在头部添加节点
            if(this.size == this.capacity) {
                removeLastNode();
            }
            insertNodeBegin(e);
        }
    }

    /**
     * 访问数据
     * @param e
     * @return
     */
    public T get(T e) {
        Node preNode = findPreNode(e);

        if(preNode != null) {
            //节点在链表中
            removeNextNode(preNode);
            insertNodeBegin(e);
            return e;
        } else {
            //节点不在链表中
            return null;
        }
    }

    /**
     * 删除最后一个节点
     */
    private void removeLastNode() {
        Node node = this.head;

        //空链表
        if(node.next == null) {
            return;
        }

        while (node.next.next != null) {
            node = node.next;
        }
        node.next = null;
        this.size --;
    }

    /**
     * 在头部插入节点
     * @param e
     */
    private void insertNodeBegin(T e) {
        Node node = this.head;
        Node nextNode = node.next;
        Node newNode = new Node(e, nextNode);
        node.next = newNode;
        this.size ++;
    }

    /**
     * 删除节点的下一个节点
     * @param node
     */
    private void removeNextNode(Node node) {
        if(node != null && node.next != null) {
            node.next = node.next.next;
            this.size --;
        }
    }

    /**
     * 找到要查找元素的前一个节点
     * @param e
     * @return
     */
    private Node findPreNode(T e) {
        Node node = this.head;
        while (node.next != null) {
            if(node.next.data.equals(e)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    /**
     * 打印链表内容
     */
    private void printAll() {
        Node node = this.head;
        while (node.next != null) {
            node = node.next;
            System.out.print(node.getData() + " ");
        }
        System.out.println();
    }

    class Node<T> {
        private T data;
        private Node next;

        public Node() {}

        public Node(T data) {
            this(data, null);
        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
    
    public static void main(String[] args) {
        LRUBaseLinkedList<Integer> lruBaseLinkedList = new LRUBaseLinkedList<>(5);
        Scanner sc = new Scanner(System.in);
        while (true) {
            int input = sc.nextInt();
            lruBaseLinkedList.add(input);
            lruBaseLinkedList.printAll();
        }
    }

}
