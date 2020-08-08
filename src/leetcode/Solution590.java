package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * N叉树的后序遍历(https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/)
 * Created by xsg on 2020/8/8.
 */
public class Solution590 {

    public List<Integer> postorder(Node root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;

        Deque<Node> deque = new LinkedList<>();
        deque.offerLast(root);
        while (!deque.isEmpty()) {
            Node node = deque.pollLast();
            res.addFirst(node.val);
            if (node.children != null) {
                for (Node child : node.children) {
                    deque.offerLast(child);
                }
            }
        }
        return res;
    }

    public List<Integer> postorder1(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(Node node, List<Integer> list) {
        if (node == null) return;
        List<Node> children = node.children;
        if (children != null) {
            for (Node child : children) {
                helper(child, list);
            }
        }
        list.add(node.val);
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
