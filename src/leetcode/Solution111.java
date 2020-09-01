package leetcode;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 二叉树的最小深度(https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/)
 * Created by xsg on 2020/8/16.
 */
public class Solution111 {

    /**
     * 当前节点的最小深度等于左子树的深度与右子树的深度的较小值
     * 如果当前节点无左子树，则需计算右子树的深度
     * 如果当前节点无右子树，则需计算左子树的深度
     * 如果当前节点无左、右子树，则当前节点的深度为1
     */
    public int minDepth3(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return minDepth3(root.right) + 1;
        if (root.right == null) return minDepth3(root.left) + 1;

        return Math.min(minDepth3(root.left), minDepth3(root.right)) + 1;
    }

    public int minDepth2(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;

        int minDepth = Integer.MAX_VALUE;
        if (root.left != null) minDepth = Math.min(minDepth, minDepth2(root.left));
        if (root.right != null) minDepth = Math.min(minDepth, minDepth2(root.right));

        return minDepth + 1;
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        int minDepth = Integer.MAX_VALUE;
        Deque<Pair<TreeNode, Integer>> deque = new ArrayDeque<>();
        deque.offerFirst(new Pair<>(root, 1));
        while (!deque.isEmpty()) {
            Pair<TreeNode, Integer> pair = deque.pollFirst();
            TreeNode node = pair.getKey();
            int curDepth = pair.getValue();
            if (node.left == null && node.right == null) {
                minDepth = Math.min(minDepth, curDepth);
            }
            if (node.left != null) deque.offerFirst(new Pair<>(node.left, curDepth + 1));
            if (node.right != null) deque.offerFirst(new Pair<>(node.right, curDepth + 1));
        }
        return minDepth;
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
