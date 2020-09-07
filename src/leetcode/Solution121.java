package leetcode;

/**
 * 买卖股票的最佳时机(https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/)
 * Created by xsg on 2020/9/7.
 */
public class Solution121 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        // 0 没有持有，1 持有
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;  //第一天没有持有，利润为 0
        dp[0][1] = -prices[0];  //第一天持有，利润为 -prices[0]

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[prices.length - 1][0];
    }
}
