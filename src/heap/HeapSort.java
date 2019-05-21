package heap;

/**
 * Created by xsg on 2019/5/21.
 */
public class HeapSort {

    /**
     * 建堆
     * @param data
     */
    public static void buildHeap(int[] data) {
        int size = data.length - 1;
        for(int i = size / 2; i > 0; i--) {
            heaplify(data, size, i);
        }
    }

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
     * @param nums
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

    public static void main(String[] args) {
        int[] num = new int[6];
        num[1] = 2;
        num[2] = 7;
        num[3] = 3;
        num[4] = 4;
        num[5] = 10;

        sort(num);

        for(int i = 1; i < num.length; i++) {
            System.out.print(num[i] + " ");
        }
    }
}
