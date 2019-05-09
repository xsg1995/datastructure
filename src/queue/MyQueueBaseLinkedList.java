package queue;

/**
 * Created by xsg on 2019/5/9.
 */
public class MyQueueBaseLinkedList<T> {
    //指向队头
    private Node<T> head;
    //指向队尾
    private Node<T> tail;

    /**
     * 入队
     * @return
     */
    public boolean enqueue(T e) {
        Node<T> newNode = new Node<>(e, null);
        if(this.head == null) {
            this.head = newNode;
        }

        if(this.tail == null) {
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }

        return true;
    }

    /**
     * 出队
     * @return
     */
    public T dequeue() {
        if(this.head == null) return null;

        T ret = this.head.getData();
        this.head = this.head.getNext();
        if(this.head == null) {
            this.tail = null;
        }
        return ret;
    }


    private void printAll() {
        Node<T> node = this.head;

        while (node != null) {
            System.out.print(node.getData() + " ");
            node = node.getNext();
        }

        System.out.println();
    }

    public static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        MyQueueBaseLinkedList<Integer> queue = new MyQueueBaseLinkedList<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.printAll();

        System.out.println(queue.dequeue());
        queue.printAll();
        queue.enqueue(4);
        queue.printAll();
    }

}
