package leetcode;

/**
 * 从前序与中序遍历序列构造二叉树(https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)
 * Created by xsg on 2020/8/16.
 */
public class Solution105 {

    /**
     * 前序遍历：中左右
     * 中序遍历：左中右
     * 前序遍历的第一个值为根节点
     * 在中序遍历序列中，查找根节点，根节点左边的节点数量，为根节点左子树的节点
     * 在中序遍历序列中，查找根节点，根节点右边的节点数量，为根节点右子树的节点
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode buildTree(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        if (pStart >= pEnd) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[pStart]);
        int iRoot = iStart;
        for (; iRoot < iEnd; iRoot++) {
            if (preorder[pStart] == inorder[iRoot]) {
                break;
            }
        }
        int leftNum = iRoot - iStart;
        node.left = buildTree(preorder, pStart + 1, pStart + leftNum + 1, inorder, iStart, iRoot);
        node.right = buildTree(preorder, pStart + leftNum + 1, pEnd, inorder, iRoot + 1, iEnd);

        return node;
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
