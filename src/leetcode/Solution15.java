package leetcode;

import java.util.*;

/**
 * 三数之和(https://leetcode-cn.com/problems/3sum/)
 * Created by xsg on 2020/7/19.
 */
public class Solution15 {

    /**
     * 暴力遍历法，从头开始取三个指针分别遍历整个数组，并计算三个指针对应的值是否为0
     * 将符合结果的三个值排序后存储在 Set 中，使用 Set 将重复的数据过滤掉
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new LinkedHashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int z = j + 1; z < nums.length; z++) {
                    if (nums[i] + nums[j] + nums[z] == 0) {
                        List<Integer> tmpResult = Arrays.asList(nums[i], nums[j], nums[z]);
                        tmpResult.sort((o1, o2) -> o1 - o2);
                        res.add(tmpResult);
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }

    /**
     * a + b + c = 0 转化为 a + b = -c 令 target = -c
     * 则是求 a + b = target，两数之和
     * 遍历数组，取 target = -nums[i]
     * 在数组剩余部分，计算 a + b = target
     * 将符合条件的 a b c 排序后存放在 Set 中去重
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        Set<List<Integer>> res = new LinkedHashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int target = -nums[i];
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < nums.length; j++) {
                int tmp = target - nums[j];
                if (map.containsKey(tmp)) {
                    List<Integer> tmpResult = Arrays.asList(nums[i], nums[j], tmp);
                    tmpResult.sort((o1, o2) -> o1 - o2);
                    res.add(tmpResult);
                }
                map.put(nums[j], j);
            }
        }
        return new ArrayList<>(res);
    }

    /**
     * 将 nums 从小到大排序
     * 遍历 nums 数组，如果 nums[i] > 0 ，则跳过
     * 如果 nums[i] = nums[i - 1]，则是重复数据，跳过
     * 使用前、后双指针法，在数组剩余部分遍历计算 nums[i] + nums[j] + nums[k] = res
     * 如果 res > 0 则 k--
     * 如果 res < 0 则 j++
     * 如果 res == 0 则 k-- 与 j++
     */
    public List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums == null || nums.length < 3) return res;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1, k = nums.length - 1; j < k; ) {
                int target = nums[i] + nums[j] + nums[k];
                if (target == 0) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[++j]);
                    while (j < k && nums[k] == nums[--k]);
                } else if (target < 0) {
                    while (j < k && nums[j] == nums[++j]);
                } else {
                    while (j < k && nums[k] == nums[--k]);
                }
            }
        }
        return res;
    }
}
