package leetcode;

/**
 * https://leetcode-cn.com/problems/jump-game/
 * Created by xsg on 2020/8/27.
 */
public class Solution55 {
    public boolean canJump(int[] nums) {
        int maxJump = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= maxJump) {
                maxJump = Math.max(maxJump, i + nums[i]);
                if (maxJump >= nums.length - 1) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }
}
