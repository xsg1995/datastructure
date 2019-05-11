package sorts;

import java.util.Arrays;

/**
 * Created by xsg on 2019/5/11.
 */
public class MergeSort {

    /**
     * 归并排序实现
     * @param nums
     */
    public static void mergeSort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    /**
     * 使用递归排序实现
     * @param nums
     * @param r
     * @param p
     */
    public static void mergeSort(int[] nums, int r, int p) {
        if(r >= p) return;

        //数组中间下标
        int q = (r + p) / 2;
        mergeSort(nums, r, q);
        mergeSort(nums, q + 1, p);
        merge(nums, r, q, p);
    }

    /**
     * 合并排序后的数组
     * @param nums
     * @param r
     * @param p
     */
    private static void merge(int[] nums, int r, int q, int p) {
        int[] tmp = new int[p - r + 1];
        int i = r;
        int j = q + 1;
        int k = 0;
        while (i <= q && j <= p) {
            if(nums[i] <= nums[j]) {
                tmp[k++] = nums[i++];
            } else {
                tmp[k++] = nums[j++];
            }
        }

        int start = i;
        int end = q;
        if(j <= p) {
            start = j;
            end = p;
        }

        while (start <= end) {
            tmp[k++] = nums[start++];
        }

        for(i = 0; i < tmp.length; i++) {
            nums[i + r] = tmp[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {9, 10, 12, 1, 2, 3, 4, 6, 1};
        mergeSort(nums);

        System.out.println(Arrays.toString(nums));
    }
}
