package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合(https://leetcode-cn.com/problems/combinations/)
 * Created by xsg on 2020/8/18.
 */
public class Solution77 {

    public List<List<Integer>> combine2(int n, int k) {
        if (n < k || k < 0) {
            return new ArrayList<>();
        }
        if (k == 0) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>());
            return res;
        }
        List<List<Integer>> res = combine2(n - 1, k - 1);
        for (List<Integer> list : res) {
            list.add(n);
        }
        res.addAll(combine2(n - 1, k));
        return res;
    }

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
