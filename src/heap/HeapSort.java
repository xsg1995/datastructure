package heap;

/**
 * 堆排序
 * Created by xsg on 2019/5/21.
 */
public class HeapSort {

    /**
     * 建堆，将数组原地堆化
     * @param data 数组
     */
    public static void buildHeap(int[] data) {
        int size = data.length - 1;
        for(int i = size / 2; i > 0; i--) {
            heaplify(data, size, i);
        }
    }

    /**
     * 自顶向下
     * @param data 数组
     * @param n 数组长度
     * @param i 从哪个位置开始堆化
     */
    private static void heaplify(int[] data, int n, int i) {
        while (true) {
            int maxIndex = i;
            if((i * 2) <= n && data[i] < data[i * 2]) maxIndex = i * 2;
            if((i * 2 + 1) <= n && data[maxIndex] < data[i * 2 + 1]) maxIndex = i * 2 + 1;

            if(maxIndex == i) {
                break;
            }

            int tmp = data[maxIndex];
            data[maxIndex] = data[i];
            data[i] = tmp;
        }
    }

    /**
     * 堆数组排序
     * @param nums 数组
     */
    public static void sort(int[] nums) {
        buildHeap(nums);
        int k = nums.length - 1;
        while (k > 1) {
            int tmp = nums[k];
            nums[k] = nums[1];
            nums[1] = tmp;
            k--;
            heaplify(nums, k, 1);
        }
    }

}
