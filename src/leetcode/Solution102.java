package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 二叉树的层序遍历(https://leetcode-cn.com/problems/binary-tree-level-order-traversal/)
 * Created by xsg on 2020/8/25.
 */
public class Solution102 {

    /**
     * 使用广度优先遍历实现
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerLast(root);
        while (!deque.isEmpty()) {
            List<Integer> tmpList = new ArrayList<>();
            for (int i = deque.size(); i > 0; i--) {
                TreeNode node = deque.pollFirst();
                tmpList.add(node.val);
                if (node.left != null) deque.offerLast(node.left);
                if (node.right != null) deque.offerLast(node.right);
            }
            res.add(tmpList);
        }

        return res;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
