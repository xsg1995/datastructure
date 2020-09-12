package queue;

/**
 * 基于链表实现队列
 * Created by xsg on 2019/5/9.
 */
public class MyQueueBaseLinkedList<T> {
    //指向队头
    private Node<T> head;
    //指向队尾
    private Node<T> tail;

    /**
     * 入队
     *
     * @param e 入队元素
     */
    public void enqueue(T e) {
        Node<T> newNode = new Node<>(e, null);
        if (this.head == null) {
            this.head = newNode;
        }

        if (this.tail != null) {
            this.tail.next = newNode;
        }
        this.tail = newNode;

    }

    /**
     * 出队
     *
     * @return 如果队列为空，返回false
     */
    public T dequeue() {
        if (this.head == null) return null;

        T ret = this.head.data;
        this.head = this.head.next;
        if (this.head == null) {
            this.tail = null;
        }
        return ret;
    }


    /**
     * 单链表
     *
     * @param <T>
     */
    public static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

    }

}
