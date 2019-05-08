package stack;

/**
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

    public MyStack(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.data = (T[]) new Object[capacity];
    }

    /**
     * 将e元素入栈
     * @param e
     * @return
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
    private void resize() {
        T[] tmp = (T[]) new Object[this.capacity * 2];

        for(int i = 0; i < this.size; i++) {
            tmp[i] = this.data[i];
        }

        this.data = tmp;
    }

    /**
     * 出栈，并删除元素
     * @return
     */
    public T pop() {
        if(this.size < 1) return null;

        return this.data[--this.size];
    }

    /**
     * 出栈，不删除元素
     * @return
     */
    public T offer() {
        if(this.size < 1) return null;

        return this.data[this.size - 1];
    }

    public void printAll() {
        for(int i = this.size - 1; i >= 0; i--) {
            System.out.print(this.data[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack(5);
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
