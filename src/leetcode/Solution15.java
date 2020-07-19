package leetcode;

import java.util.*;

/**
 * 三数之和(https://leetcode-cn.com/problems/3sum/)
 * Created by xsg on 2020/7/19.
 */
public class Solution15 {

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
        return new ArrayList(res);
    }

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
        return new ArrayList(res);
    }

    public List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums == null && nums.length < 3) return res;

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
