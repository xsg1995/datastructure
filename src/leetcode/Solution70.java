package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 爬楼梯(https://leetcode-cn.com/problems/climbing-stairs/)
 * Created by xsg on 2020/7/19.
 */
public class Solution70 {

    public int climbStairs(int n) {
        if (n <= 2) return n;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    Map<Integer, Integer> map = new HashMap<>();

    public int climbStairs2(int n) {
        if (n <= 2) return n;
        if (map.containsKey(n)) {
            return map.get(n);
        }
        map.put(n, climbStairs(n - 1) + climbStairs(n - 2));
        return map.get(n);
    }

    public int climbStairs3(int n) {
        if (n <= 2) return n;

        int[] dp = new int[n + 1];
        for (int i = 0; i < 3; i++) {
            dp[i] = i;
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int climbStairs4(int n) {
        if (n <= 2) return n;
        int x = 1;
        int y = 2;
        for (int i = 3; i <= n; i++) {
            int z = x + y;
            x = y;
            y = z;
        }
        return y;
    }
}
