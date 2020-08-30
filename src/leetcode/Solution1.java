package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和(https://leetcode-cn.com/problems/two-sum/)
 * Created by xsg on 2020/7/19.
 */
public class Solution1 {

    /**
     * 双指针遍历整个数组，求值
     */
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

    /**
     * 使用一个 map 存储遍历过程中遇到的值，key = 值, value = 数组索引
     * 遍历过程中，计算 res = target - nums[i]
     * 如果 res 在 map 中存在，则说明 res 与 nums[i] 的值为 target
     */
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

    /**
     * 使用一个 map 存储数组中所有的数据,key = 值, value = 数组的索引
     * 遍历数组，并计算 res = target - nums[i]
     * 如果 res 在 map 中存在，则说明 res 与 nums[i] 的值为 target
     */
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
