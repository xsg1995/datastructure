package queue;

/**
 * Created by xsg on 2019/5/9.
 */
public class MyDynamicArrayQueue<T> {

    //存放数据的数组
    private T[] data;
    //数组的容量
    private int capacity;
    //队列头索引
    private int head;
    //队列尾索引
    private int tail;

    public MyDynamicArrayQueue() {
        this(10);
    }

    public MyDynamicArrayQueue(int capacity) {
        this.capacity = capacity;
        this.head = 0;
        this.tail = 0;
        this.data = (T[]) new Object[capacity];
    }

    /**
     * 入队
     * @return
     */
    public boolean enqueue(T e) {
        if(this.tail == this.capacity) {
            //数组已经满了
            if(this.head == 0) return false;

            for(int i = this.head; i < this.tail; i++) {
                this.data[i - this.head] = this.data[i];
            }

            this.tail = this.tail - this.head;
            this.head = 0;
        }

        this.data[this.tail ++] = e;
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
        MyDynamicArrayQueue<Integer> queue = new MyDynamicArrayQueue<>(3);
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
