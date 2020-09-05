package leetcode;

import java.util.Arrays;

/**
 * 打家劫舍 II(https://leetcode-cn.com/problems/house-robber-ii/)
 * Created by xsg on 2020/9/5.
 */
public class Solution213 {

    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        return Math.max(helper(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                helper(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    private int helper(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];

        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[len - 1];
    }
}
