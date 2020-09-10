package heap;

/**
 * 小顶推
 * Created by xsg on 2019/10/26.
 */
public class SmallHeap {
    private int[] data;
    private int count;
    private int capacity;

    public SmallHeap(int capacity) {
        this.data = new int[capacity + 1];
        this.count = 0;
        this.capacity = capacity;
    }

    /**
     * 获取堆顶元素，最小值
     * @return 最小值
     */
    public int getTop() {
        if(this.count < 1) return -1;
        return this.data[1];
    }

    /**
     * 插入一个数字
     * @param e 要插入的数字
     */
    public boolean insert(int e) {
        //堆已满
        if (this.count >= this.capacity) return false;

        this.data[++this.count] = e;
        int index = this.count;
        while (index > 0) {
            int minIndex = index;
            int leftIndex = index / 2;
            int rightIndex = leftIndex + 1;
            if (leftIndex > 0 && this.data[leftIndex] > this.data[index]) minIndex = leftIndex;
            if (rightIndex > 0 && this.data[rightIndex] > this.data[minIndex]) minIndex = rightIndex;

            if (minIndex == index) break;
            this.swap(minIndex, index);
            index = minIndex;
        }
        return true;
    }

    /**
     * 交换索引下标的值
     * @param index1 索引1
     * @param index2 索引2
     */
    private void swap(int index1, int index2) {
        int t1 = this.data[index1];
        this.data[index1] = this.data[index2];
        this.data[index2] = t1;
    }

}
