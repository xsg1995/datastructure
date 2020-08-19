package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 全排列(https://leetcode-cn.com/problems/permutations/)
 * Created by xsg on 2020/8/19.
 */
public class Solution46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;

        List<Integer> numsList = new ArrayList<>();
        for (int n : nums) {
            numsList.add(n);
        }

        permute(numsList, new ArrayList<>(), res);
        return res;
    }

    private void permute(List<Integer> nums, List<Integer> currList, List<List<Integer>> res) {
        if (nums.isEmpty()) {
            res.add(new ArrayList<>(currList));
            return;
        }

        for (Integer n : nums) {
            currList.add(n);
            List<Integer> numsList = new ArrayList<>(nums);
            numsList.remove(n);
            permute(numsList, currList, res);
            currList.remove(n);
        }
    }
}
