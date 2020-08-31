package leetcode;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 二叉树的最大深度(https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/)
 * Created by xsg on 2020/8/16.
 */
public class Solution104 {

    /**
     * 广度优先遍历，记录下每个节点的深度
     * 遍历过程中取最大值
     */
    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;

        int maxDepth = 0;
        Deque<Pair<TreeNode, Integer>> deque = new ArrayDeque<>();
        deque.offerFirst(new Pair<>(root, 1));
        while (!deque.isEmpty()) {
            Pair<TreeNode, Integer> pair = deque.pollFirst();
            TreeNode node = pair.getKey();
            int depth = pair.getValue();
            maxDepth = Math.max(maxDepth, depth);
            if (node.left != null) deque.offerFirst(new Pair<>(node.left, depth + 1));
            if (node.right != null) deque.offerFirst(new Pair<>(node.right, depth + 1));
        }
        return maxDepth;
    }

    /**
     * 递归实现
     * 当前节点的最大深度为左、右节点深度的最大值
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
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
