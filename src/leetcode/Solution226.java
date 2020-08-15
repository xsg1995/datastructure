package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 翻转二叉树(https://leetcode-cn.com/problems/invert-binary-tree/description/)
 * Created by xsg on 2020/8/15.
 */
public class Solution226 {

    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return null;

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerFirst(root);
        while(!deque.isEmpty()) {
            TreeNode currNode = deque.pollFirst();
            TreeNode tmpNode = currNode.left;
            currNode.left = currNode.right;
            currNode.right = tmpNode;

            if (currNode.left != null) deque.offerFirst(currNode.left);
            if (currNode.right != null) deque.offerFirst(currNode.right);
        }
        return root;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = right;
        root.right = left;

        invertTree(root.left);
        invertTree(root.right);

        return root;
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
