package leetcode;

/**
 * 旋转数组(https://leetcode-cn.com/problems/rotate-array/)
 * Created by xsg on 2020/8/3.
 */
public class Solution189 {

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 1 || k == 0) return;

        for (int i = 0; i < k; i++) {
            int prev = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                int tmp = nums[j];
                nums[j] = prev;
                prev = tmp;
            }
        }
    }

    public void rotate2(int[] nums, int k) {
        if(nums == null || nums.length == 1 || k == 0) return;

        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start ++;
            end --;
        }
    }

    public void rotate3(int[] nums, int k) {
        if(nums == null || nums.length == 1 || k == 0) return;

        int[] tmp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            tmp[(i + k) % nums.length] = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = tmp[i];
        }
    }
}
