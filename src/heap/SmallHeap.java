package heap;

import java.util.ArrayList;
import java.util.List;

/**
 * 小顶推
 * Created by xsg on 2019/10/26.
 */
public class SmallHeap<T extends Comparable> {
    private T[] data;
    private int count;
    private int capacity;

    public SmallHeap(int capacity) {
        this.data = (T[]) new Comparable[capacity + 1];
        this.count = 0;
        this.capacity = capacity;
    }

    public T getTop() {
        if(this.count < 1) return null;
        return this.data[1];
    }


    public void insert(T e) {
        if(e == null) return;

        if(this.count >= this.capacity) {

            Comparable top = this.getTop();
            if(top != null) {
                if(e.compareTo(top) > 0) {
                    //删除堆顶元素
                    this.data[1] = this.data[count];
                    this.data[count] = null;
                    this.count --;
                }
            }
        }

        if(this.count >= this.capacity) return;

        this.count ++;
        this.data[count] = e;
        this.heapify();
    }


    private void heapify() {
        int i = 1;
        while (true) {
            int index = i;

            if(i * 2 <= this.count) {
                Comparable t1 = this.data[i];
                Comparable t2 = this.data[i * 2];

                int compare = t1.compareTo(t2);
                if(compare > 0) {
                    index = index * 2;
                }
            }

            if(i * 2 + 1 <= this.count) {
                Comparable t1 = this.data[index];
                Comparable t2 = this.data[i * 2 + 1];

                int compare = t1.compareTo(t2);
                if(compare > 0) {
                    index = i * 2 + 1;
                }
            }

            if(index == i) break;

            swap(i, index);
            i = index;
        }
    }

    private void swap(int index1, int index2) {
        T t1 = this.data[index1];
        this.data[index1] = this.data[index2];
        this.data[index2] = t1;
    }

    public List<T> getAll() {
        List<T> result = new ArrayList<>(this.count);
        for (T t : this.data) {
            result.add(t);
        }
        return result;
    }
}
