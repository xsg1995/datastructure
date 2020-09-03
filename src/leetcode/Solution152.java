package leetcode;

import java.util.Arrays;

/**
 * 乘积最大子数组(https://leetcode-cn.com/problems/maximum-product-subarray/)
 * Created by xsg on 2020/9/3.
 */
public class Solution152 {

    public int maxProduct(int[] nums) {
        int[] dp = Arrays.copyOf(nums, nums.length);
        int max = dp[0];
        int min = dp[0];

        for (int i = 1; i < dp.length; i++) {
            if (dp[i] < 0) {
                int tmp = max;
                max = min;
                min = tmp;
            }
            max = Math.max(dp[i], dp[i] * max);
            min = Math.min(dp[i], dp[i] * min);
            dp[i] = max;
        }

        int res = Integer.MIN_VALUE;
        for (int n : dp) {
            res = Math.max(res, n);
        }
        return res;
    }

    public int maxProduct2(int[] nums) {
        int[] maxDp = new int[nums.length];
        int[] minDp = new int[nums.length];
        int res = nums[0];
        maxDp[0] = nums[0];
        minDp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxDp[i] = Math.max(nums[i], Math.max(maxDp[i - 1] * nums[i], minDp[i - 1] * nums[i]));
            minDp[i] = Math.min(nums[i], Math.min(maxDp[i - 1] * nums[i], minDp[i - 1] * nums[i]));

            res = Math.max(res, maxDp[i]);
        }
        return res;
    }
}
