package leetcode;

/**
 * 有效的完全平方数(https://leetcode-cn.com/problems/valid-perfect-square/)
 * Created by xsg on 2020/8/28.
 */
public class Solution367 {
    public boolean isPerfectSquare(int num) {
        long left = 0;
        long right = num;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long res = mid * mid;
            if (res == num) return true;
            if (res < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
