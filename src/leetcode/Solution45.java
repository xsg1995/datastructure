package leetcode;

/**
 * 跳跃游戏 II(https://leetcode-cn.com/problems/jump-game-ii/)
 * Created by xsg on 2020/8/27.
 */
public class Solution45 {

    public int jump(int[] nums) {
        int maxJump = 0;
        int step = 0;
        int end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxJump = Math.max(maxJump, nums[i] + i);
            if (i == end) {
                end = maxJump;
                step ++;
            }
        }
        return step;
    }

    public int jump2(int[] nums) {
        int position = nums.length - 1;
        int step = 0;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                if (nums[i] + i >= position) {
                    position = i;
                    step ++;
                }
            }
        }
        return step;
    }
}
