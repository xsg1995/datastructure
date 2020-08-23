package leetcode;

/**
 * 多数元素(https://leetcode-cn.com/problems/majority-element/)
 * Created by xsg on 2020/8/23.
 */
public class Solution169 {
    public int majorityElement(int[] nums) {
        int target = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (target == nums[i]) {
                count ++;
            } else {
                count --;
            }
            if (count < 0) {
                target = nums[i];
                count = 1;
            }
        }

        return target;
    }
}
