package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 二叉树的序列化与反序列化(https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/)
 * Created by xsg on 2020/8/16.
 */
public class Solution297 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null,";
        }
        String res = root.val + ",";
        res += serialize(root.left);
        res += serialize(root.right);

        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> dataList = new ArrayList<>(Arrays.asList(data.split(",")));
        return reDeserialize(dataList);
    }

    private TreeNode reDeserialize(List<String> list) {
        if (list.get(0).equals("null")) {
            list.remove(0);
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(list.remove(0)));
        node.left = reDeserialize(list);
        node.right = reDeserialize(list);
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
