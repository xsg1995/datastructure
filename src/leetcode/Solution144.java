package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 二叉树的前序遍历(https://leetcode-cn.com/problems/binary-tree-preorder-traversal/)
 * Created by xsg on 2020/8/8.
 */
public class Solution144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerLast(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.pollLast();
            res.add(node.val);
            if (node.right != null) deque.offerLast(node.right);
            if (node.left != null) deque.offerLast(node.left);
        }
        return res;
    }

    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode node, List<Integer> list) {
        if (node == null) return;
        list.add(node.val);
        helper(node.left, list);
        helper(node.right, list);
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
