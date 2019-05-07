package linked;

/**
 * Created by xsg on 2019/5/6.
 */
public class SingleLinkedList<T> {

    //链表头结点
    private Node<T> head;

    public Node getHead() {
        return this.head;
    }

    /**
     * 根据值查找节点
     * @param value
     * @return
     */
    public Node findByValue(T value) {
        Node p = this.head;
        while (p != null) {
            if(p.getData().equals(value)) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    /**
     * 根据索引下标查找节点
     * @param index
     * @return
     */
    public Node findByIndex(int index) {
        if(index < 0) {
            return null;
        }
        Node p = this.head;
        int i = 0;
        while (p != null) {
            if(i == index) {
                return p;
            }
            i++;
            p = p.next;
        }
        return null;
    }

    /**
     * 往链表头部插入数据
     * @param value
     */
    public void insertToHead(T value) {
        Node newNode = new Node(value, null);
        this.insertToHead(newNode);
    }

    /**
     * 往链表头部插入节点
     * @param newNode
     */
    private void insertToHead(Node newNode) {
        if(this.head == null) {
            this.head = newNode;
        } else {
            newNode.next = this.head;
            this.head = newNode;
        }
    }

    /**
     * 往链表尾部插入数据
     * @param value
     */
    public void insertTail(T value) {
        Node newNode = new Node(value, null);

        if(this.head == null) {
            this.head = newNode;
        } else {
            Node p = this.head;
            while (p.getNext() != null) {
                p = p.next;
            }
            newNode.next = p.next;
            p.next = newNode;
        }
    }

    /**
     * 在节点p后面插入value
     * @param p
     * @param value
     */
    public void insertAfter(Node p, T value) {
        Node newNode = new Node(value, null);
        insertAfter(p, newNode);
    }

    /**
     * 在节点p后面插入节点newNode
     * @param p
     * @param newNode
     */
    public void insertAfter(Node p, Node newNode) {
        newNode.next = p.next;
        p.next = newNode;
    }

    /**
     * 在节点p前面插入值value
     * @param p
     * @param value
     */
    public void insertBefore(Node p, T value) {
        Node newNode = new Node(value, null);
        this.insertBefore(p, newNode);
    }

    /**
     * 在节点p前面插入解析newNode
     * @param p
     * @param newNode
     */
    public void insertBefore(Node p, Node newNode) {

        if(p == this.head) {
            this.insertToHead(newNode);
            return;
        }

        Node preNode = this.head;

        while (preNode != null && preNode.next == p) {
            preNode = preNode.next;
        }

        if(preNode == null) {
            return;
        }

        newNode.next = p;
        preNode.next = newNode;

    }

    /**
     * 删除节点
     * @param p
     */
    public void deleteByNode(Node p) {
        if(this.head == null || p == null) return;

        if(this.head == p) {
            this.head = this.head.next;
            return;
        }

        Node preNode = this.head.next;

        while (preNode != null && preNode.next != p) {
            preNode = preNode.next;
        }

        if(preNode == null) return;

        preNode.next = preNode.next.next;
    }

    /**
     * 删除指定值的节点
     * @param value
     */
    public void deleteByValue(T value) {
        if(this.head == null) return;

        Node nowNode = this.head;
        Node preNode = null;

        while (nowNode != null && !nowNode.data.equals(value)) {
            preNode = nowNode;
            nowNode = nowNode.next;
        }

        if(nowNode == null)  return;

        if(preNode == null) {
            this.head = this.head.next;
            return;
        }

        preNode.next = preNode.next.next;
    }

    /**
     * 打印数据
     */
    public void printAll() {
        Node p = this.head;
        while (p != null) {
            System.out.print(p.getData() + " ");
            p = p.next;
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
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
        linkedList.insertToHead(5);
        linkedList.insertToHead(4);
        linkedList.insertToHead(3);
        linkedList.insertToHead(2);
        linkedList.insertToHead(1);

        linkedList.insertTail(6);
        linkedList.insertTail(8);

        Node fiveNode = linkedList.findByIndex(5);
        linkedList.insertAfter(fiveNode, 7);
        linkedList.insertAfter(fiveNode, -7);

        Node zeroNode = linkedList.findByIndex(0);
        linkedList.insertBefore(zeroNode, 0);

        linkedList.deleteByValue(-7);

        linkedList.deleteByNode(linkedList.findByValue(2));

        linkedList.printAll();
    }
}
