package sorts;

import java.util.Arrays;

/**
 * Created by xsg on 2019/5/10.
 */
public class SelectionSort {

    /**
     * 选择排序
     * @param nums
     */
    public static void selectionSort(int[] nums) {
        if(nums.length <= 1) return;

        for(int i = 0; i < nums.length - 1; i++) {
            int k = i;
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[j] < nums[k]) {
                    k = j;
                }
            }
            if(k != i) {
                int tmp = nums[i];
                nums[i] = nums[k];
                nums[k] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {9, 10, 12, 1, 2, 3, 4, 6, 1};
        selectionSort(nums);

        System.out.println(Arrays.toString(nums));
    }
}
