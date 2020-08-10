package leetcode;

/**
 * 丑数(https://leetcode-cn.com/problems/chou-shu-lcof/)
 * Created by xsg on 2020/8/10.
 */
public class SolutionOffer49 {

    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int a = 0, b = 0, c = 0;
        for (int i = 1; i < n; i++) {
            int na = dp[a] * 2;
            int nb = dp[b] * 3;
            int nc = dp[c] * 5;
            int mn = Math.min(Math.min(na, nb), nc);
            dp[i] = mn;
            if (mn == na) a ++;
            if (mn == nb) b ++;
            if (mn == nc) c ++;
        }
        return dp[n - 1];
    }
}
