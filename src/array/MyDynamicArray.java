package array;

/**
 * Created by xsg on 2019/5/4.
 */
public class MyDynamicArray<T> {

    //存放数据
    private T[] data;
    private int size;

    public MyDynamicArray() {
        this(10);
    }

    public MyDynamicArray(int capacity) {
        this.data = (T[]) new Object[capacity];
        this.size = 0;
    }

    /**
     * 返回当前数组存储的数据的个数
     * @return
     */
    public int size() {
        return this.size;
    }

    /**
     * 判断当前数组是否为空
     * @return
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * 判断当前数组中是否存在某个元素
     * @param e
     * @return
     */
    public boolean contains(T e) {
        for(int i = 0; i < this.size; i++) {
            if(this.data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 设置指定索引下标的值
     * @param index
     * @param e
     */
    public void set(int index, T e) {
        if(index < 0 || index >= this.size) return;

        this.data[index] = e;
    }

    /**
     * 根据下标获取数据
     * @param index
     * @return
     */
    public T get(int index) {
        if(index < 0 || index >= this.size) return null;

        return this.data[index];
    }

    /**
     * 在指定下标添加元素
     * @param index
     * @param e
     */
    public void add(int index, T e) {
        if(index < 0 || index > this.size) return;

        if(this.size == this.data.length) {
            resize();
        }

        for(int i = this.size; i > index; i--) {
            this.data[i] = this.data[i - 1];
        }

        this.data[index] = e;
        this.size++;
    }

    /**
     * 数组扩容
     */
    private void resize() {
        int newSize = this.size + (this.size >> 2);
        T[] newData = (T[]) new Object[newSize];

        for(int i = 0; i < this.size; i++) {
            newData[i] = this.data[i];
        }

        this.data = newData;
    }

    /**
     * 在数组的第一个位置添加元素
     * @param e
     */
    public void addFirst(T e) {
        this.add(0, e);
    }

    /**
     * 在数组的最后一个位置添加元素
     * @param e
     */
    public void addLast(T e) {
        this.add(this.size, e);
    }

    /**
     * 删除指定位置的元素
     * @param index
     * @return
     */
    public T remove(int index) {
        if(index < 0 || index >= this.size) return null;
        
        T ret = this.data[index];
        for(int i = index; i < this.size - 1; i++) {
            this.data[i] = this.data[i + 1];
        }
        
        this.data[this.size - 1] = null;
        this.size--;
        return ret;
    }

    /**
     * 删除第一个元素
     * @return
     */
    public T removeFirst() {
        return this.remove(0);
    }

    /**
     * 删除最后一个元素
     * @return
     */
    public T removeLast() {
        return this.remove(this.size - 1);
    }

    /**
     * 删除指定元素
     * @param e
     * @return
     */
    public T removeElement(T e) {
        int index = this.find(e);
        if(index != -1) {
            return this.remove(index);
        }
        return null;
    }

    /**
     * 获取指定元素的下标
     * @param e
     * @return
     */
    public int find(T e) {
        for(int i = 0; i < this.size; i++) {
            if(this.data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.size; i++) {
            sb.append(this.data[i] + " ");
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        MyDynamicArray<Integer> dynamicArray = new MyDynamicArray<>(5);
        dynamicArray.addFirst(7);
        dynamicArray.addFirst(6);
        dynamicArray.addFirst(5);
        dynamicArray.addFirst(4);
        dynamicArray.addFirst(3);
        dynamicArray.addFirst(2);
        dynamicArray.addFirst(1);

        dynamicArray.addLast(8);

        System.out.println(dynamicArray);

        System.out.println(dynamicArray.removeFirst());

        System.out.println(dynamicArray.get(0));

        dynamicArray.set(0, 1);
        
        System.out.println(dynamicArray);
    }
}
