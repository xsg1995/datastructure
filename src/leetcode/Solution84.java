package leetcode;

/**
 * 柱状图中最大的矩形(https://leetcode-cn.com/problems/largest-rectangle-in-histogram/)
 * Created by xsg on 2020/7/29.
 */
public class Solution84 {

    public int largestRectangleArea1(int[] heights) {
        int area = 0;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i; j < heights.length; j++) {
                int minHeight = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    minHeight = Math.min(minHeight, heights[k]);
                }
                area = Math.max(area, (j - i + 1) * minHeight);
            }
        }
        return area;
    }

    public int largestRectangleArea2(int[] heights) {
        if (heights == null || heights.length == 0) return 0;

        int area = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            int left = i;
            int right = i;
            while (left - 1 >= 0 && heights[i] <= heights[left - 1]) {
                left --;
            }
            while (right + 1 < heights.length && heights[right + 1] >= heights[i]) {
                right ++;
            }
            area = Math.max(area, heights[i] * (right - left + 1));
        }
        return area;
    }

    public int largestRectangleArea3(int[] heights) {
        if (heights == null || heights.length == 0) return 0;

        int area = 0;
        for (int i = 0; i < heights.length; i++) {
            int leftBound = i, rightBound = i;
            while ((leftBound - 1) >= 0 && heights[i] <= heights[leftBound - 1]) {
                leftBound--;
            }
            while ((rightBound + 1) < heights.length && heights[i] <= heights[rightBound + 1]) {
                rightBound++;
            }

            area = Math.max(area, heights[i] * (rightBound - leftBound + 1));
        }
        return area;
    }
}
