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

    /**
     * 使用 maxLeft 记录每个柱子对应的左边的柱子的最高高度（不包含自己的高度）
     * 使用 maxRight 记录每个柱子对应的右边的柱子的最高高度（不包含自己的高度）
     */
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

    /**
     * 想象，竖直方向每根柱子可以装多少水
     * 第一根与最后一根柱子没有装水
     * 当前柱子能装多少水，取决于左边最高的柱子（leftMax）与右边最高的柱子（rightMax）的最小值（minHeight）
     * 当前柱子能装水的数量：res = minHeight - height[i]
     */
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

    /**
     * 首先获取最高的柱子高度，然后从最底层开始向上装水
     * 一格表示一格水
     * 如果当前柱子高度大于当前层，则装的水 + 1
     * 开始遍历新层时，将上层的水加上，并重置变量
     */
    public int trap(int[] height) {
        if (height == null || height.length < 2) return 0;

        int level = getLevel(height);
        int res = 0;
        for (int i = 1; i <= level; i++) {
            boolean isStart = false;
            int tmp = 0;
            for (int value : height) {
                if (isStart && value < i) {
                    tmp++;
                }
                if (value >= i) {
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
        for (int value : height) {
            level = Math.max(level, value);
        }
        return level;
    }
}
