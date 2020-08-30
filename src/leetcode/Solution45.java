package leetcode;

/**
 * 跳跃游戏 II(https://leetcode-cn.com/problems/jump-game-ii/)
 * Created by xsg on 2020/8/27.
 */
public class Solution45 {

    /**
     * maxJump 记录每次能够跳跃到的最大距离
     * 当每次跳到最大距离时 step++ 并更新下一个能跳到的最大距离 maxJump
     */
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

    /**
     * position 记录要跳到的位置
     * 循环遍历数组中，找第一个能跳到 position 的位置
     * 更新 position 为第一个能跳到 position 的位置
     * 从头开始循环找下一个位置
     */
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
