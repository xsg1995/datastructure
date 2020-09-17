package leetcode;

/**
 * 买卖股票的最佳时机 II(https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/)
 * Created by xsg on 2020/8/26.
 */
public class Solution122 {

    /**
     * 如果第二天的价格比前一天的高，则买入就有赚
     * 遍历数组，累加差值
     */
    public int maxProfit2(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }

    /**
     * 遍历数组，找到最低点与最高点，求者的差值
     * 最低点：prices[i + 1] > prices[i]，则 i 是最低点
     * 最高点：prices[i - 1] < prices[i]，则 i 是最高点
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int height = 0;
        int low = 0;
        int i = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i + 1] <= prices[i]) {
                i ++;
            }
            low = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i ++;
            }
            height = prices[i];
            maxProfit += height - low;
        }
        return maxProfit;
    }

    /**
     * 动态规划解决
     */
    public int maxProfit3(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
    }
}
