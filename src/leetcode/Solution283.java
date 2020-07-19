package leetcode;

/**
 * 移动零(https://leetcode-cn.com/problems/move-zeroes/)
 * Created by xsg on 2020/7/16.
 */
public class Solution283 {

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (j != i) {
                    int tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                }
                j ++;
            }
        }
    }

    public void moveZeroes2(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int index = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[index ++] = num;
            }
        }
        while (index < nums.length) {
            nums[index ++] = 0;
        }
    }
}
