package array;

/**
 * 使用数组实现LRU算法
 * 靠近头部的元素是最近访问的元素
 * 靠近尾部的元素是很久已经访问的元素
 * Created by xsg on 2019/5/6.
 */
public class LRUBaseArray<T> {
    //存放数据的数组
    private T[] data;
    //数组的总大小
    private int capacity;
    //当前数组中的数据大小
    private int size;

    public LRUBaseArray() {
        this(10);
    }

    @SuppressWarnings("unchecked")
    public LRUBaseArray(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.data = (T[]) new Object[capacity];
    }

    /**
     * 往数组中添加元素
     * @param e 要添加的元素
     */
    public void add(T e) {
        int index = this.findIndex(e);

        //缓存中已经存在数据，则删除该数据，并将数据添加到数组首位置
        if(index != -1) {
            remove(index);
            add(0, e);
        } else {
            //缓存中不存在数据，则判断数组是否已满
            if(this.size == this.capacity) {
                //删除最后一个元素
                remove(this.size - 1);
            }
            //在数组首位置添加元素
            add(0, e);
        }
    }

    /**
     * 访问元素
     * @param e 要访问的元素
     * @return 返回返回的元素，如果不存在，则返回null
     */
    public T get(T e) {
        int index = this.findIndex(e);

        if(index == -1) return null;

        T result = this.data[index];
        for(int i = index - 1; i >= 0; i--) {
            this.data[i + 1] = this.data[i];
        }
        this.data[0] = result;

        return result;
    }

    /**
     * 在指定下标添加元素
     * @param index 要添加元素的下标
     * @param e 添加的元素
     */
    private void add(int index, T e) {
        for(int i = this.size - 1; i >= index; i--) {
            this.data[i + 1] = this.data[i];
        }
        this.data[index] = e;
        this.size++;
    }

    /**
     * 删除指定位置的元素
     * @param index 要删除的位置索引
     */
    private void remove(int index) {
        if (index >= this.size) throw new IndexOutOfBoundsException("index >= size");
        for(int i = index; i < this.size - 1; i++) {
            this.data[i] = this.data[i + 1];
        }
        this.data[this.size - 1] = null;
        this.size--;
    }

    /**
     * 返回元素在数组中的下标位置
     * @param e 要查询的元素
     * @return 元素的下标
     */
    private int findIndex(T e) {
        for(int i = 0; i < this.size; i++) {
            if(e.equals(this.data[i])) {
                return i;
            }
        }
        return -1;
    }

    public void printAll() {
        for(int i = 0; i < this.size; i++) {
            System.out.print(this.data[i] + " ");
        }
        System.out.println();
    }

}