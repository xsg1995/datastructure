package leetcode;

import java.util.*;

/**
 * N叉树的层序遍历(https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/)
 * Created by xsg on 2020/8/8.
 */
public class Solution429 {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Deque<Node> deque = new ArrayDeque<>();
        deque.offerLast(root);
        while (!deque.isEmpty()) {
            List<Integer> tmpRes = new LinkedList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                Node node = deque.pollFirst();
                tmpRes.add(node.val);

                if (node.children != null) {
                    for (Node child : node.children) {
                        deque.offerLast(child);
                    }
                }
            }
            res.add(tmpRes);
        }
        return res;
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
