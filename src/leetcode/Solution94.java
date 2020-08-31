package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 二叉树的中序遍历(https://leetcode-cn.com/problems/binary-tree-inorder-traversal/)
 * Created by xsg on 2020/8/6.
 */
public class Solution94 {

    /**
     * 使用 deque 实现
     * dfs 深度优先遍历
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();

        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode node = root;
        while (node != null || !deque.isEmpty()) {
            while (node != null) {
                deque.offerLast(node);
                node = node.left;
            }
            node = deque.pollLast();
            output.add(node.val);
            node = node.right;
        }
        return output;
    }

    /**
     * 递归实现，左中右
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode node, List<Integer> list) {
        if (node == null) return;

        helper(node.left, list);
        list.add(node.val);
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
