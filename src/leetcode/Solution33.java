package leetcode;

/**
 * 搜索旋转排序数组(https://leetcode-cn.com/problems/search-in-rotated-sorted-array/)
 * Created by xsg on 2020/8/29.
 */
public class Solution33 {
    public int search(int[] nums, int target) {
        int low = 0;
        int hight = nums.length - 1;
        while (low <= hight) {
            int mid = low + (hight - low) / 2;
            if (nums[mid] == target) return mid;

            if (nums[0] <= nums[mid]) {
                if (target < nums[mid] && target >= nums[0]) {
                    hight = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                //nums[0] > nums[mid]
                if (target > nums[mid] && target <= nums[nums.length - 1]) {
                    low = mid + 1;
                } else {
                    hight = mid - 1;
                }
            }
        }
        return -1;
    }
}
