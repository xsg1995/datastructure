package stack;

/**
 * 链表实现栈
 * Created by xsg on 2019/5/8.
 */
public class MyStackByLinked<T> {

    private Node<T> node;

    /**
     * 将e元素入栈
     * @param e 入栈元素
     */
    public void push(T e) {
        Node<T> newNode = new Node<>(e, null);
        if(this.node == null) {
            this.node = newNode;
        } else {
            newNode.next = this.node;
            this.node = newNode;
        }
    }

    /**
     * 出栈，并删除元素
     * @return 出栈
     */
    public T pop() {
        if(this.node == null) return null;

        T data = this.node.data;
        this.node = this.node.next;

        return data;
    }

    public static class Node<T> {
        public T data;
        public Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

}
