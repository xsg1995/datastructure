package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Pow(x, n)(https://leetcode-cn.com/problems/powx-n/)
 * Created by xsg on 2020/8/21.
 */
public class Solution50 {

    Map<Integer, Double> map = new HashMap<>();

    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (x == 0) return 0;

        return n < 0 ? 1 / helper(x, -n) : helper(x, n);
    }

    private double helper(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;

        if (map.containsKey(n)) return map.get(n);

        double mid = helper(x, n / 2) * helper(x, n / 2);
        double res = n % 2 == 0 ? mid : mid * x;

        map.put(n, res);
        return res;
    }
}
