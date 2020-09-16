package stack;

/**
 * 数组实现栈
 * Created by xsg on 2019/5/8.
 */
public class MyStack<T> {
    //存数据的数组
    private T[] data;
    //数组的大小
    private int capacity;
    //已经存储的数据大小
    private int size;

    public MyStack() {
        this(10);
    }

    @SuppressWarnings("unchecked")
    public MyStack(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.data = (T[]) new Object[capacity];
    }

    /**
     * 将e元素入栈
     * @param e 入栈元素
     */
    public void push(T e) {
        if(this.capacity == this.size) {
            resize();
        }
        this.data[this.size++] = e;
    }

    /**
     * 对数组扩容
     */
    @SuppressWarnings("unchecked")
    private void resize() {
        this.capacity = this.capacity * 2;
        T[] tmp = (T[]) new Object[this.capacity];

        for(int i = 0; i < this.size; i++) {
            tmp[i] = this.data[i];
        }

        this.data = tmp;
    }

    /**
     * 出栈，并删除元素
     * @return 出栈元素
     */
    public T pop() {
        if(this.size <= 0) return null;

        return this.data[--this.size];
    }

    /**
     * 出栈，不删除元素
     * @return 返回栈顶元素
     */
    public T offer() {
        if(this.size <= 0) return null;

        return this.data[this.size - 1];
    }
}
