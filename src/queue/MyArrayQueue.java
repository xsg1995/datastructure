package queue;

/**
 * 数组实现队列
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

    @SuppressWarnings("unchecked")
    public MyArrayQueue(int capacity) {
        this.capacity = capacity;
        this.head = 0;
        this.tail = 0;
        this.data = (T[]) new Object[capacity];
    }

    /**
     * 入队
     * @param e 要插入的数据
     * @return 插入成功返回true
     */
    public boolean enqueue(T e) {
        //队列已满
        if(this.tail == this.capacity) return false;

        this.data[this.tail++] = e;
        return true;
    }

    /**
     * 出队
     * @return 没有元素返回false
     */
    public T dequeue() {
        if(this.head == this.tail) return null;

        return this.data[this.head ++];
    }
}
