package sorts;

/**
 * 快排思想查找第 k 大元素
 * Created by xsg on 2019/5/11.
 */
public class KthSmallest {

    /**
     * 在数组中查找第k大的数
     */
    public static int searchKthSmallest(int[] nums, int kth) {
        //没有这个数
        if(kth > nums.length) return -1;

        int q = partition(nums, 0, nums.length - 1);

        while ((q + 1) != kth) {
            if(kth < (q + 1)) {
                q = partition(nums, 0, q - 1);
            } else {
                q = partition(nums, q + 1, nums.length - 1);
            }
        }

        return nums[q];
    }

    /**
     * 数组分区
     */
    private static int partition(int[] nums, int r, int q) {
        int pivot =  nums[q];
        int i = r;

        for(int j = r; j < q; j++) {
            if(nums[j] <= pivot) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
            }
        }

        int tmp = nums[i];
        nums[i] = nums[q];
        nums[q] = tmp;

        return i;
    }

}
