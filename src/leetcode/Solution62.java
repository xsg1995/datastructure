package leetcode;

/**
 * 不同路径(https://leetcode-cn.com/problems/unique-paths/)
 * Created by xsg on 2020/8/30.
 */
public class Solution62 {
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) return 1;

        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) dp[i][0] = 1;
        for (int i = 0; i < m; i++) dp[0][i] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[n - 1][m - 1];
    }
}
