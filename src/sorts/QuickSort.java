package sorts;

import java.util.Arrays;

/**
 * Created by xsg on 2019/5/11.
 */
public class QuickSort {

    /**
     * 快速排序实现
     * @param nums
     */
    public static void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    /**
     * 使用递归实现快速排序
     * @param nums
     * @param r
     * @param p
     */
    private static void quickSort(int[] nums, int r, int p) {
        if(r >= p) return;

        int q = partition(nums, r, p);
        quickSort(nums, r, q - 1);
        quickSort(nums, q + 1, p);
    }

    /**
     * 对函数分区
     * @param nums
     * @param r
     * @param p
     * @return
     */
    private static int partition(int[] nums, int r, int p) {
        int pivot = nums[p];
        int i = r;

        for(int j = r; j < p; j++) {
            if(nums[j] < pivot) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
            }
        }

        int tmp = nums[i];
        nums[i] = nums[p];
        nums[p] = tmp;

        return i;
    }

    public static void main(String[] args) {
        int[] nums = {9, 10, 12, 1, 2, 3, 4, 6, 1};
        quickSort(nums);

        System.out.println(Arrays.toString(nums));
    }
}
