package queue;

/**
 * 循环队列
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

    @SuppressWarnings("unchecked")
    public MyCircularQueue(int capacity) {
        this.capacity = capacity;
        this.head = 0;
        this.tail = 0;
        this.data = (T[]) new Object[capacity];
    }

    /**
     * 入队
     * @param e 入队元素
     * @return 入队成功返回true
     */
    public boolean enqueue(T e) {
        if((this.tail + 1) % this.capacity == this.head) return false;

        this.data[this.tail] = e;
        this.tail = (this.tail + 1) % this.capacity;
        return true;
    }

    /**
     * 出队
     * @return 队列为空返回null
     */
    public T dequeue() {
        if(this.head == this.tail) return null;

        T ret = this.data[this.head];
        this.head = (this.head + 1) % this.capacity;
        return ret;
    }
}
