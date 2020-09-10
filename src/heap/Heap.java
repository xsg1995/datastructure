package heap;

/**
 * 用数组实现堆
 * Created by xsg on 2019/5/21.
 */
public class Heap {

    private int[] data;
    private int capacity;
    private int size;

    public Heap() {
        this(10);
    }

    public Heap(int capacity) {
        this.capacity = capacity;
        this.data = new int[this.capacity + 1];
        this.size = 0;
    }

    /**
     * 往堆中插入数据（自低向上）
     * @param value 要插入的数据
     */
    public void insert(int value) {
        if(this.size == this.capacity) {
            return;
        }

        int index = ++ this.size;
        this.data[index] = value;

        while ((index / 2) > 0 && this.data[index] > this.data[index / 2]) {
            int tmp = this.data[index];
            this.data[index] = this.data[index / 2];
            this.data[index / 2] = tmp;

            index = index / 2;
        }
    }

    /**
     * 移除堆顶元素
     */
    public void removeMax() {
        if(this.size == 0) return;

        int top = this.data[1];
        this.data[1] = this.data[this.size];
        this.size --;

        heapify();
    }

    /**
     * 堆化（自顶向下）
     */
    private void heapify() {
        int index = 1;
        while (true) {
            int maxIndex = index;
            if(index * 2 <= this.size && this.data[index] < this.data[index * 2]) maxIndex = index * 2;
            if((index * 2 + 1) <= this.size && this.data[maxIndex] < this.data[index * 2 + 1]) maxIndex = index * 2 + 1;

            if(maxIndex == index) break;

            int tmp = this.data[maxIndex];
            this.data[maxIndex] = this.data[index];
            this.data[index] = tmp;

            index = maxIndex;
        }
    }

    public void print() {
        for(int i = 1; i <= this.size; i++) {
            System.out.print(this.data[i] + " ");
        }
        System.out.println();
    }

}
