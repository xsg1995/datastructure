package leetcode;

/**
 * 接雨水(https://leetcode-cn.com/problems/trapping-rain-water/)
 * Created by xsg on 2020/8/1.
 */
public class Solution42 {

    public int trap4(int[] height) {
        int res = 0;
        int maxLeft = 0;
        int maxRight = 0;
        int left = 1;
        int right = height.length - 2;
        for (int i = 1; i < height.length - 1; i++) {
            if (height[left - 1] < height[right + 1]) {
                maxLeft = Math.max(maxLeft, height[left - 1]);
                if (maxLeft > height[left]) {
                    res += maxLeft - height[left];
                }
                left ++;
            } else {
                maxRight = Math.max(maxRight, height[right + 1]);
                if (maxRight > height[right]) {
                    res += maxRight - height[right];
                }
                right --;
            }
        }
        return res;
    }

    public int trap3(int[] height) {
        int res = 0;
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];

        for (int i = 1; i < height.length - 1; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i > 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            int minHeight = Math.min(maxLeft[i], maxRight[i]);
            if (height[i] < minHeight) {
                res += minHeight - height[i];
            }
        }
        return res;
    }

    public int trap2(int[] height) {
        int res = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int leftMax = 0;
            for (int j = i - 1; j >= 0; j--) {
                leftMax = Math.max(leftMax, height[j]);
            }
            int rightMax = 0;
            for (int j = i + 1; j < height.length; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }

            int minHeight = Math.min(leftMax, rightMax);
            if (height[i] < minHeight) {
                res += minHeight - height[i];
            }
        }
        return res;
    }

    public int trap(int[] height) {
        if (height == null || height.length < 2) return 0;

        int level = getLevel(height);
        int res = 0;
        for (int i = 1; i <= level; i++) {
            boolean isStart = false;
            int tmp = 0;
            for (int j = 0; j < height.length; j++) {
                if (isStart && height[j] < i) {
                    tmp ++;
                }
                if (height[j] >= i) {
                    res += tmp;
                    tmp = 0;
                    isStart = true;
                }
            }
        }
        return res;
    }

    private int getLevel(int[] height) {
        int level = 0;
        for (int i = 0; i < height.length; i++) {
            level = Math.max(level, height[i]);
        }
        return level;
    }
}
