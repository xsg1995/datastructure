package array;

/**
 * 自定义Array实现，空间固定
 * Created by xsg on 2019/5/3.
 */
public class MyArray {

    //存放数据的数组
    private int[] data;
    //数组长度
    private int capacity;
    //实际存放数据的个数
    private int size;

    public MyArray(int capacity) {
        this.data = new int[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    /**
     * 根据下标获取数据
     * @param index 下标
     * @return 下标对应的元素，越界则抛出 IndexOutOfBoundsException
     */
    public int get(int index) {
        this.checkIndex(index);

        return this.data[index];
    }

    /**
     * 在指定下标插入数据
     * @param index 下标
     * @param value 插入的元素
     * @return 插入成功，返回true，否则返回false，索引越界，抛出 IndexOutOfBoundsException
     */
    public boolean insert(int index, int value) {
        this.checkIndex(index);
        if (this.isFull()) return false;

        //移动元素
        for(int i = this.size - 1; i >= index; i--) {
            this.data[i + 1] = this.data[i];
        }

        this.data[index] = value;
        this.size ++;
        return true;
    }

    /**
     * 删除指定下标的数据
     * @param index 下标
     * @return 删除成功，返回true，索引越界抛出 IndexOutOfBoundsException
     */
    public boolean delete(int index) {
        this.checkIndex(index);
        if (this.isEmpty()) return false;

        for(int i = index; i < this.size - 1; i++) {
            this.data[i] = this.data[i + 1];
        }

        this.size --;
        return true;
    }

    /**
     * 在数组头部添加数据
     * @param value 要添加的元素
     * @return 添加成功，返回 true
     */
    public boolean addFirst(int value) {
        return this.insert(0, value);
    }

    /**
     * 返回数组大小
     * @return 数组的大小
     */
    public int getSize() {
        return this.size;
    }

    /**
     * 检查数组下标是否越界，越界则抛出 IndexOutOfBoundsException 异常
     * @param index 要检查的下标
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= this.size) throw new IndexOutOfBoundsException("index < 0 || index >= this.size");
    }

    /**
     * 当前Array是否已经满了
     * @return 如果已经满了 ，返回true；否则返回false
     */
    public boolean isFull() {
        return this.size >= this.capacity;
    }

    /**
     * 检查Array是否为空
     * @return 返回true，则Array已经空了，否则返回false
     */
    public boolean isEmpty() {
        return this.size == 0;
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
