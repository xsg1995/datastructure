package linked;

/**
 * 链表实现LRU缓存淘汰算法
 * 靠经头节点的是最近访问的节点
 * Created by xsg on 2019/5/5.
 */
public class LRUBaseLinkedList<T> {

    //链表的容量
    private int capacity;
    //链表存放数据的大小
    private int size;
    //头结点
    private Node<T> head;

    public LRUBaseLinkedList() {
        //默认容量为10
        this(10);
    }

    public LRUBaseLinkedList(int capacity) {
        this.head = new Node<T>();
        this.capacity = capacity;
        this.size = 0;
    }

    /**
     * 添加一个数据
     * @param e 添加的数据
     */
    public void add(T e) {
        Node<T> preNode = findPreNode(e);

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
     * @param e 访问的节点
     * @return 节点信息
     */
    public T get(T e) {
        Node<T> preNode = findPreNode(e);

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
        Node<T> node = this.head;

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
     * @param e 要插入的节点
     */
    private void insertNodeBegin(T e) {
        Node<T> nextNode = this.head.next;
        this.head.next = new Node<T>(e, nextNode);
        this.size ++;
    }

    /**
     * 删除节点的下一个节点
     * @param node 要删除的节点
     */
    private void removeNextNode(Node<T> node) {
        if(node != null && node.next != null) {
            node.next = node.next.next;
            this.size --;
        }
    }

    /**
     * 找到要查找元素的前一个节点
     * @param e 要查找的节点
     * @return 查找的节点的前一个节点
     */
    private Node<T> findPreNode(T e) {
        Node<T> node = this.head;
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
        Node<T> node = this.head;
        while (node.next != null) {
            node = node.next;
            System.out.print(node.data + " ");
        }
        System.out.println();
    }

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node() {}

        public Node(T data) {
            this(data, null);
        }

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

}
