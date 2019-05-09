package queue;

/**
 * Created by xsg on 2019/5/9.
 */
public class MyCircularQueue<T> {
    //存放数据的数组
    private T[] data;
    //数组的容量
    private int capacity;
    //队列头索引
    private int head;
    //队列尾索引
    private int tail;

    public MyCircularQueue() {
        this(10);
    }

    public MyCircularQueue(int capacity) {
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
        if((this.tail + 1) % this.capacity == this.head) return false;

        this.data[this.tail] = e;
        this.tail = (this.tail + 1) % this.capacity;
        return true;
    }

    /**
     * 出队
     * @return
     */
    public T dequeue() {
        if(this.head == this.tail) return null;

        T ret = this.data[this.head];
        this.head = (this.head + 1) % this.capacity;
        return ret;
    }

    private void printAll() {

        if(this.tail > this.head) {
            for(int i = this.head; i < this.tail; i++) {
                System.out.print(this.data[i] + " ");
            }
        } else if(this.tail < this.head) {
            for(int i = this.head; i < this.capacity; i++) {
                System.out.print(this.data[i] + " ");
            }
            for(int i = 0; i < this.tail; i++) {
                System.out.print(this.data[i] + " ");
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        MyCircularQueue<Integer> queue = new MyCircularQueue<>(4);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.printAll();

        System.out.println(queue.dequeue());
        queue.enqueue(4);
        queue.printAll();
    }


}
