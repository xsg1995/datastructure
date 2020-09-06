package array;

/**
 * 自定义动态扩容的Array实现
 * Created by xsg on 2019/5/4.
 */
public class MyDynamicArray<T> {

    //存放数据
    private T[] data;
    private int size;

    public MyDynamicArray() {
        this(10);
    }

    @SuppressWarnings("unchecked")
    public MyDynamicArray(int capacity) {
        this.data = (T[]) new Object[capacity];
        this.size = 0;
    }

    /**
     * 返回当前数组存储的数据的个数
     *
     * @return 元素的个数
     */
    public int size() {
        return this.size;
    }

    /**
     * 判断当前数组是否为空
     *
     * @return 如果为空，返回 true
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * 判断当前数组中是否存在某个元素
     *
     * @param e 要查找的元素
     * @return 如果存在，则返回 true，否则返回 false
     */
    public boolean contains(T e) {
        for (int i = 0; i < this.size; i++) {
            if (this.data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 设置指定索引下标的值
     *
     * @param index 索引下标
     * @param e     要设置的值
     */
    public void set(int index, T e) {
        this.checkIndex(index);

        this.data[index] = e;
    }

    /**
     * 根据下标获取数据
     *
     * @param index 下标
     * @return 下标对应的元素
     */
    public T get(int index) {
        this.checkIndex(index);
        if (this.isEmpty()) return null;

        return this.data[index];
    }

    /**
     * 在指定下标添加元素
     *
     * @param index
     * @param e
     */
    public void add(int index, T e) {
        if (index < 0 || index > this.size) return;

        //扩容
        if (this.size == this.data.length) {
            resize();
        }

        for (int i = this.size; i > index; i--) {
            this.data[i] = this.data[i - 1];
        }

        this.data[index] = e;
        this.size++;
    }

    /**
     * 数组扩容
     */
    @SuppressWarnings("unchecked")
    private void resize() {
        //扩容为原来的 1.5 倍
        int newSize = this.size + (this.size >> 2);
        T[] newData = (T[]) new Object[newSize];

        for (int i = 0; i < this.size; i++) {
            newData[i] = this.data[i];
        }

        this.data = newData;
    }

    /**
     * 在数组的第一个位置添加元素
     *
     * @param e 要添加的元素
     */
    public void addFirst(T e) {
        this.add(0, e);
    }

    /**
     * 在数组的最后一个位置添加元素
     *
     * @param e 要添加的元素
     */
    public void addLast(T e) {
        this.add(this.size, e);
    }

    /**
     * 删除指定位置的元素
     * @param index 要删除的索引
     * @return 返回删除的元素
     */
    public T remove(int index) {
        this.checkIndex(index);
        if (this.isEmpty()) return null;

        T ret = this.data[index];
        for (int i = index; i < this.size - 1; i++) {
            this.data[i] = this.data[i + 1];
        }

        this.data[this.size - 1] = null;
        this.size--;
        return ret;
    }

    /**
     * 删除第一个元素
     * @return 返回删除的元素
     */
    public T removeFirst() {
        return this.remove(0);
    }

    /**
     * 删除最后一个元素
     * @return 返回删除的元素
     */
    public T removeLast() {
        return this.remove(this.size - 1);
    }

    /**
     * 删除指定元素
     * @param e 要删除的元素
     * @return 返回删除的元素
     */
    public T removeElement(T e) {
        int index = this.find(e);
        if (index != -1) {
            return this.remove(index);
        }
        return null;
    }

    /**
     * 获取指定元素的下标
     * @param e 获取的元素
     * @return 如果不存在，则返回 -1
     */
    public int find(T e) {
        for (int i = 0; i < this.size; i++) {
            if (this.data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 检查数组下标是否越界，越界则抛出 IndexOutOfBoundsException 异常
     *
     * @param index 要检查的下标
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= this.size) throw new IndexOutOfBoundsException("index < 0 || index >= this.size");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.size; i++) {
            sb.append(this.data[i] + " ");
        }
        return sb.toString();
    }

}
