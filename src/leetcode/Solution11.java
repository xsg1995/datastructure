package leetcode;

/**
 * 盛最多水的容器(https://leetcode-cn.com/problems/container-with-most-water/)
 * Created by xsg on 2020/7/16.
 */
public class Solution11 {

    /**
     * 使用暴力发，遍历整个数组，并计算每次两个指针指向区域的面积
     * 取遍历中的各个面积的最大值，该值就是盛水最多的值
     */
    public int maxArea(int[] height) {
        int res = 0;
        for (int j = 0; j < height.length - 1; j++) {
            for (int i = j + 1; i < height.length; i++) {
                res = Math.max(res, (i - j) * Math.min(height[i], height[j]));
            }
        }
        return res;
    }

    /**
     * 使用双指针法，left 为从头向尾移动的指针，right 为从尾向头移动的指针
     * 计算 left 与 right 向中间逼近的区域的面积，计算过程中的面积最大值
     */
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
