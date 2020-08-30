package leetcode;

/**
 * x 的平方根(https://leetcode-cn.com/problems/sqrtx/)
 * Created by xsg on 2020/8/28.
 */
public class Solution69 {
    /**
     * 使用二分法，查找中的值 mid * mid 与结果 x 比较
     * 如果 mid * mid <= x 则 res = mid , left = mid + 1
     * 如果 mid * mid > x 则 right = mid - 1
     */
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int res = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid <= x) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}
