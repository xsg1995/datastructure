package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 在每个树行中找最大值(https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/)
 * Created by xsg on 2020/8/25.
 */
public class Solution515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        helper(0, root, res);
        return res;
    }

    private void helper(int index, TreeNode node, List<Integer> list) {
        if (node == null) return;
        if (list.size() == index) {
            list.add(node.val);
        } else {
            list.set(index, Math.max(list.get(index), node.val));
        }
        helper(index + 1, node.left, list);
        helper(index + 1, node.right, list);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
