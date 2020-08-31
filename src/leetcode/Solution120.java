package leetcode;

import java.util.List;

/**
 * 三角形最小路径和(https://leetcode-cn.com/problems/triangle/description/)
 * Created by xsg on 2020/8/31.
 */
public class Solution120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int col = triangle.get(row - 1).size();

        int[][] dp = new int[row][col];
        return helper(0, 0, row, dp, triangle);
    }

    private int helper(int r, int c, int row, int[][] dp, List<List<Integer>> triangle) {
        if (r == row - 1) {
            return triangle.get(r).get(c);
        }
        if (dp[r][c] != 0) return dp[r][c];

        int left = helper(r + 1, c, row, dp, triangle);
        int right = helper(r + 1, c + 1, row, dp, triangle);
        int result = Math.min(left, right) + triangle.get(r).get(c);
        dp[r][c] = result;
        return result;
    }

}
