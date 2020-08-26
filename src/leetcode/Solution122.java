package leetcode;

/**
 * 买卖股票的最佳时机 II(https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/)
 * Created by xsg on 2020/8/26.
 */
public class Solution122 {

    public int maxProfit2(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }


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
}
