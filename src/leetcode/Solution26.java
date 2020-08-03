package leetcode;

/**
 * 删除排序数组中的重复项(https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/)
 * Created by xsg on 2020/8/3.
 */
public class Solution26 {

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
