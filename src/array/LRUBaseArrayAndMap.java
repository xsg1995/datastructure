package array;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by xsg on 2019/5/6.
 */
public class LRUBaseArrayAndMap<T> {
    //存放数据的数组
    private T[] data;
    //数组的总大小
    private int capacity;
    //当前数组中的数据大小
    private int size;
    //存放数据在数组中的下标值
    private Map<T, Integer> dataIndex;

    public LRUBaseArrayAndMap() {
        this(10);
    }

    public LRUBaseArrayAndMap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.data = (T[]) new Object[capacity];
        this.dataIndex = new HashMap<>(capacity);
    }

    /**
     * 往数组中添加元素
     * @param e
     */
    public void add(T e) {
        Integer index = this.dataIndex.get(e);

        if(index != null) {
            //缓存中已经存在数据，则删除该数据，并将数据添加到数组首位置
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
     * 在指定下标添加元素
     * @param index
     * @param e
     */
    private void add(int index, T e) {
        for(int i = this.size - 1; i >= index; i--) {
            this.data[i + 1] = this.data[i];
            this.dataIndex.put(this.data[i], i + 1);
        }
        this.data[index] = e;
        this.dataIndex.put(e, index);
        this.size++;
    }

    /**
     * 删除指定位置的元素
     * @param index
     */
    private void remove(int index) {
        T indexData = this.data[index];
        this.dataIndex.remove(indexData);
        for(int i = index; i < this.size - 1; i++) {
            this.data[i] = this.data[i + 1];
            this.dataIndex.put(this.data[i + 1], i);
        }
        this.size--;
    }

    public void printAll() {
        for(int i = 0; i < this.size; i++) {
            System.out.print(this.data[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRUBaseArrayAndMap<Integer> array = new LRUBaseArrayAndMap<>(5);
        Scanner sc = new Scanner(System.in);
        while (true) {
            array.add(sc.nextInt());
            array.printAll();
        }
    }
}