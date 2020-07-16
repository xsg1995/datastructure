package array;

/**
 * Created by xsg on 2019/5/3.
 */
public class MyArray {

    //存放数据的数组
    private int data[];
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
     * @param index
     * @return
     */
    public int get(int index) {
        if(index < 0 || index >= this.size) return -1;

        return this.data[index];
    }

    /**
     * 在指定下标插入数据
     * @param index
     * @param value
     * @return
     */
    public boolean insert(int index, int value) {
        if(this.size == this.capacity) return false;

        if(index < 0 || index >= this.capacity) return false;

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
     * @param index
     * @return
     */
    public boolean delete(int index) {
        if(index < 0 || index >= this.size) return false;

        for(int i = index; i < this.size - 1; i++) {
            this.data[i] = this.data[i + 1];
        }

        this.size --;
        return true;
    }

    /**
     * 在数组头部添加数据
     * @param value
     * @return
     */
    public boolean addFirst(int value) {
        return this.insert(0, value);
    }

    /**
     * 返回数组大小
     * @return
     */
    public int getSize() {
        return this.size;
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
        MyArray array = new MyArray(5);
        array.insert(0, 0);
        array.insert(1, 1);
        array.insert(2, 2);
        array.insert(3, 3);
        array.insert(4, 4);

        System.out.println(array.get(3));
        System.out.println(array.delete(3));
        System.out.println(array);
    }

}
