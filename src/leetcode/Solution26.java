package leetcode;

/**
 * 删除排序数组中的重复项(https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/)
 * Created by xsg on 2020/8/3.
 */
public class Solution26 {

    /**
     * 双指针法
     * i 指向没有重复项的最后一个位置
     * j 遍历数组中的后续位置
     * if nums[i] != nums[j]
     * nums[++i] = nums[j]
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int i = 0;
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i ++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    /**
     * 双指针法
     * j 指向无重复数组项的最后一个位置
     * i 遍历有序数组
     * if nums[i] != nums[i - 1]
     * 则 nums[i] 是不重复的
     * 交换 nums[j] == nums[i] && j++
     */
    public int removeDuplicates2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}
