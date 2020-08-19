package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列 II(https://leetcode-cn.com/problems/permutations-ii/)
 * Created by xsg on 2020/8/19.
 */
public class Solution47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;

        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];

        permuteUnique(nums, 0, new LinkedList<>(), visited, res);
        return res;
    }

    private void permuteUnique(int[] nums, int index, LinkedList<Integer> currList, boolean[] visited, List<List<Integer>> list) {
        if (index == nums.length) {
            list.add(new ArrayList<>(currList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }

            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            currList.add(nums[i]);
            permuteUnique(nums, index + 1, currList, visited, list);
            visited[i] = false;
            currList.removeLast();
        }
    }
}
