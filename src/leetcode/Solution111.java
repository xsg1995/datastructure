package leetcode;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 二叉树的最小深度(https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/)
 * Created by xsg on 2020/8/16.
 */
public class Solution111 {

    public int minDepth3(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return minDepth(root.right) + 1;
        if (root.right == null) return minDepth(root.left) + 1;

        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    public int minDepth2(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;

        int minDepth = Integer.MAX_VALUE;
        if (root.left != null) minDepth = Math.min(minDepth, minDepth(root.left));
        if (root.right != null) minDepth = Math.min(minDepth, minDepth(root.right));

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
