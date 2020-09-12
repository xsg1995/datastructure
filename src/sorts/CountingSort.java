package sorts;

/**
 * 计数排序
 * Created by xsg on 2019/5/12.
 */
public class CountingSort {

    /**
     * 计数排序实现
     */
    public static void countingSort(int[] nums) {
        if(nums.length <= 1) return;

        int max = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > max) {
                max = nums[i];
            }
        }

        int[] c = new int[max + 1];
        for(int i = 0; i < nums.length; i++) {
            c[nums[i]] ++;
        }

        for(int i = 1; i <= max; i++) {
            c[i] = c[i] + c[i - 1];
        }

        int[] tmp = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            int index = c[nums[i]] - 1;
            tmp[index] = nums[i];
            c[nums[i]] --;
        }

        for(int i = 0; i < tmp.length; i++) {
            nums[i] = tmp[i];
        }
    }
}
