package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * N叉树的前序遍历(https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/)
 * Created by xsg on 2020/8/8.
 */
public class Solution589 {

    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Deque<Node> deque = new ArrayDeque<>();
        deque.offerLast(root);
        while (!deque.isEmpty()) {
            Node node = deque.pollLast();
            res.add(node.val);
            if (node.children != null) {
                for (int i = node.children.size() - 1; i >= 0; i--) {
                    deque.offerLast(node.children.get(i));
                }
            }
        }
        return res;
    }

    public List<Integer> preorder1(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(Node node, List<Integer> list) {
        if (node == null) return;
        list.add(node.val);
        if (node.children != null) {
            for (Node child : node.children) {
                helper(child, list);
            }
        }
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
