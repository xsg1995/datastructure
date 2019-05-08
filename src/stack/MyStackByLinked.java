package stack;

/**
 * Created by xsg on 2019/5/8.
 */
public class MyStackByLinked<T> {

    private Node<T> head;

    /**
     * 将e元素入栈
     * @param e
     * @return
     */
    public void push(T e) {
        Node newNode = new Node<>(e, null);
        if(this.head == null) {
            this.head = newNode;
        } else {
            newNode.next = this.head;
            this.head = newNode;
        }
    }

    /**
     * 出栈，并删除元素
     * @return
     */
    public T pop() {
        if(this.head == null) return null;

        T data = this.head.getData();
        this.head = this.head.next;

        return data;
    }

    public void printAll() {
        Node node = this.head;

        while (node != null) {
            System.out.print(node.getData() + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static class Node<T> {
        private T data;
        private Node next;

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
        MyStackByLinked<Integer> stack = new MyStackByLinked();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        stack.printAll();

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.printAll();
    }
}
