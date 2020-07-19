package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和(https://leetcode-cn.com/problems/two-sum/)
 * Created by xsg on 2020/7/19.
 */
public class Solution1 {

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            int res = target - nums[i];
            if (map.containsKey(res)) {
                return new int[] {map.get(res), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int res = target - nums[i];
            if (map.containsKey(res) && map.get(res) != i) {
                return new int[] {map.get(res), i};
            }
        }
        return null;
    }
}
