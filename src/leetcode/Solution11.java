package leetcode;

/**
 * 盛最多水的容器(https://leetcode-cn.com/problems/container-with-most-water/)
 * Created by xsg on 2020/7/16.
 */
public class Solution11 {

    public int maxArea(int[] height) {
        int res = 0;
        for (int j = 0; j < height.length - 1; j++) {
            for (int i = j + 1; i < height.length; i++) {
                res = Math.max(res, (i - j) * Math.min(height[i], height[j]));
            }
        }
        return res;
    }

    public int maxArea2(int[] height) {
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int h = height[left] < height[right] ? height[left ++] : height[right --];
            res = Math.max(res, (right - left + 1) * h);
        }
        return res;
    }

    public int maxArea3(int[] height) {
        int res = Integer.MIN_VALUE;
        for (int left = 0, right = height.length - 1; left < right; ) {
            int minHeight = height[left] < height[right] ? height[left++] : height[right --];
            res = Math.max(res, (right - left + 1) * minHeight);
        }
        return res;
    }
}
