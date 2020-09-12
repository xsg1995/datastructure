package sorts;

/**
 * 快速排序
 * Created by xsg on 2019/5/11.
 */
public class QuickSort {

    /**
     * 快速排序实现
     */
    public static void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    /**
     * 使用递归实现快速排序
     */
    private static void quickSort(int[] nums, int r, int p) {
        if(r >= p) return;

        int q = partition(nums, r, p);
        quickSort(nums, r, q - 1);
        quickSort(nums, q + 1, p);
    }

    /**
     * 对函数分区
     */
    private static int partition(int[] nums, int r, int p) {
        int pivot = nums[p];
        int i = r;

        for(int j = r; j < p; j++) {
            if(nums[j] < pivot) {
                if (i != j) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
                i++;
            }
        }

        int tmp = nums[i];
        nums[i] = nums[p];
        nums[p] = tmp;

        return i;
    }

}
