package queue;

/**
 * Created by xsg on 2019/5/9.
 */
public class MyArrayQueue<T> {
    //存放数据的数组
    private T[] data;
    //数组的容量
    private int capacity;
    //队列头索引
    private int head;
    //队列尾索引
    private int tail;

    public MyArrayQueue() {
        this(10);
    }

    public MyArrayQueue(int capacity) {
        this.capacity = capacity;
        this.head = 0;
        this.tail = 0;
        this.data = (T[]) new Object[capacity];
    }

    /**
     * 入队
     * @param e
     * @return
     */
    public boolean enqueue(T e) {
        //队列已满
        if(this.tail == this.capacity) return false;

        this.data[this.tail++] = e;
        return true;
    }

    /**
     * 出队
     * @return
     */
    public T dequeue() {
        if(this.head == this.tail) return null;

        return this.data[this.head ++];
    }

    public void printAll() {
        for(int i = this.head; i < this.tail; i++) {
            System.out.print(this.data[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyArrayQueue<Integer> queue = new MyArrayQueue<>();
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
