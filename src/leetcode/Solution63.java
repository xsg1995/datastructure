package leetcode;

/**
 * 不同路径 II(https://leetcode-cn.com/problems/unique-paths-ii/)
 * Created by xsg on 2020/8/30.
 */
public class Solution63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int col = obstacleGrid[0].length;
        int[] dp = new int[col];
        dp[0] = 1;
        for (int[] row : obstacleGrid) {
            for (int j = 0; j < col; j++) {
                if (row[j] == 1) {
                    dp[j] = 0;
                } else if (j > 0) {
                    dp[j]= dp[j] + dp[j - 1];
                }
            }
        }
        return dp[col - 1];
    }
}
