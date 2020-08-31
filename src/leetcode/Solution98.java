package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 验证二叉搜索树(https://leetcode-cn.com/problems/validate-binary-search-tree/)
 * Created by xsg on 2020/8/15.
 */
public class Solution98 {

    /**
     * 按照二叉搜索树的定义，左子节点小于父节点，右节点大于父节点，递归实现
     */
    public boolean isValidBST2(TreeNode root) {
        return valid(root, null, null);
    }

    private boolean valid(TreeNode node, Integer low, Integer height) {
        if (node == null) {
            return true;
        }
        if (low != null && low >= node.val) return false;
        if (height != null && height <= node.val) return false;

        //node.left 的不能大于当前节点的 val
        //node.right 不能小于当前节点的 val
        return valid(node.left, low, node.val) && valid(node.right, node.val, height);
    }

    /**
     * 二叉搜索树中序遍历输出是有序
     * 遍历过程中，如果当前节点的值小于等于上一个节点的值，则不符合条件
     */
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        int order = Integer.MIN_VALUE;
        while (root != null || !deque.isEmpty()) {
            while (root != null) {
                deque.offerFirst(root);
                root = root.left;
            }

            root = deque.pollFirst();
            if (root.val <= order) return false;
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
