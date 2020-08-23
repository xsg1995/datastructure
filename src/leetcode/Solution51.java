package leetcode;

import java.util.*;

/**
 * N皇后(https://leetcode-cn.com/problems/n-queens/)
 * Created by xsg on 2020/8/23.
 */
public class Solution51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();

        Set<Integer> colSet = new HashSet<>();
        Set<Integer> master = new HashSet<>();  // row - col
        Set<Integer> slave = new HashSet<>();  // row + col

        helper(0, n, colSet, master, slave, new LinkedList<>(), res);
        return res;
    }

    private void helper(int row, int n, Set<Integer> colSet, Set<Integer> masterSet, Set<Integer> slaveSet, LinkedList<Integer> currList, List<List<String>> list) {
        if (row == n) {
            list.add(show(currList, n));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!colSet.contains(i) && !masterSet.contains(row - i) && !slaveSet.contains(row + i)) {
                colSet.add(i);
                masterSet.add(row - i);
                slaveSet.add(row + i);
                currList.add(i);
                helper(row + 1, n, colSet, masterSet, slaveSet, currList, list);
                currList.removeLast();
                colSet.remove(i);
                masterSet.remove(row - i);
                slaveSet.remove(row + i);
            }
        }
    }

    private List<String> show(List<Integer> list, int n) {
        List<String> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int target = list.get(i);
            for (int j = 0; j < n; j++) {
                if (target != j) {
                    sb.append(".");
                } else {
                    sb.append("Q");
                }
            }
            res.add(sb.toString());
        }
        return res;
    }
}
