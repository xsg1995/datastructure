package leetcode;

import java.util.Arrays;

/**
 * 最大子序和(https://leetcode-cn.com/problems/maximum-subarray/)
 * Created by xsg on 2020/8/31.
 */
public class Solution53 {
    public int maxSubArray(int[] nums) {
        int[] dp = Arrays.copyOf(nums, nums.length);
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(0, dp[i - 1]) + dp[i];
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
