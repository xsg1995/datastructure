package leetcode;

/**
 * 搜索旋转排序数组(https://leetcode-cn.com/problems/search-in-rotated-sorted-array/)
 * Created by xsg on 2020/8/29.
 */
public class Solution33 {

    /**
     * 二分法获取 nums[mid]
     * 如果 nums[0] <= nums[mid]
     * 则nums[0] ~ nums[mid] 是有序的
     * if target < nums[mid] && target >= nums[0]
     * 则在 nums[0] ~ nums[mid] 间查询数据
     *
     * 如果 nums[0] > nums[mid]
     * 则 nums[mid] ~ nums[nums.length - 1] 是有序的
     * if target > nums[mid] && target >= nums[nums.length - 1]
     * 则在 nums[mid] ~ nums[nums.length - 1] 查询数据
     */
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
