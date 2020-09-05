package leetcode;

/**
 * 打家劫舍(https://leetcode-cn.com/problems/house-robber/)
 * Created by xsg on 2020/9/5.
 */
public class Solution198 {

    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int len = nums.length;

        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
            dp[i][1] = nums[i] + dp[i - 1][0];
        }
        return Math.max(dp[len - 1][0], dp[len - 1][1]);
    }

    public int rob2(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
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
