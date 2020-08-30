package leetcode;

/**
 * 跳跃游戏(https://leetcode-cn.com/problems/jump-game/)
 * Created by xsg on 2020/8/27.
 */
public class Solution55 {
    /**
     * target 为目标位置，也就是数组的最后一个位置
     * 每次到达一个位置，都计算下一个能跳到的最远距离 maxJump
     * 如果 maxJump >= target，则说明可以跳到目标的位置
     * if i > maxJump
     * 则说明当前位置，不可达
     */
    public boolean canJump(int[] nums) {
        int target = nums.length - 1;
        int maxJump = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= maxJump) {
                maxJump = Math.max(maxJump, i + nums[i]);
                if (maxJump >= target) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }
}
