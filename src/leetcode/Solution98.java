package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 验证二叉搜索树(https://leetcode-cn.com/problems/validate-binary-search-tree/)
 * Created by xsg on 2020/8/15.
 */
public class Solution98 {

    public boolean isValidBST2(TreeNode root) {
        return valid(root, null, null);
    }

    private boolean valid(TreeNode node, Integer low, Integer height) {
        if (node == null) {
            return true;
        }
        if (low != null && low >= node.val) return false;
        if (height != null && height <= node.val) return false;

        return valid(node.left, low, node.val) && valid(node.right, node.val, height);
    }

    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        int order = Integer.MIN_VALUE;
        while (root != null || !deque.isEmpty()) {
            while (root != null) {
                deque.offerFirst(root);
                root = root.left;
            }

            root = deque.pollFirst();
            if (order >= root.val) return false;
            order = root.val;
            root = root.right;
        }

        return true;
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
