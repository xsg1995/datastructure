package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合(https://leetcode-cn.com/problems/combinations/)
 * Created by xsg on 2020/8/18.
 */
public class Solution77 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> output = new ArrayList<>();
        if (k == 0) return output;

        combine(1, n, k, new LinkedList<>(), output);
        return output;
    }

    private void combine(int index, int n, int k, LinkedList<Integer> currList, List<List<Integer>> list) {
        if (currList.size() == k) {
            list.add(new LinkedList<>(currList));
            return;
        }
        for (int i = index; i < n + 1; i++) {
            currList.add(i);
            combine(i + 1, n, k, currList, list);
            currList.removeLast();
        }
    }

}
