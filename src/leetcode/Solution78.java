package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 子集(https://leetcode-cn.com/problems/subsets/)
 * Created by xsg on 2020/8/21.
 */
public class Solution78 {

    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<>());
        for (int n : nums) {
            List<List<Integer>> subList = new ArrayList<>();
            for (List<Integer> list : output) {
                List<Integer> cur = new ArrayList<>(list);
                cur.add(n);
                subList.add(cur);
            }
            for (List<Integer> list : subList) {
                output.add(list);
            }
        }

        return output;
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        for (int i = 0; i < nums.length + 1; i++) {
            helper(0, i, nums, new LinkedList<>(), output);
        }
        return output;
    }

    private void helper(int index, int k, int[] nums, LinkedList<Integer> curList, List<List<Integer>> output) {
        if (index == k) {
            output.add(new ArrayList<>(curList));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            curList.add(nums[i]);
            helper(i + 1, k, nums, curList, output);
            curList.removeLast();
        }
    }

}
