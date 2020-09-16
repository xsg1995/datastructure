package tree;

/**
 * 二叉搜索树
 * Created by xsg on 2019/5/19.
 */
public class BinarySearchTree {

    Node tree;

    /**
     * 查找节点
     * @param data 要查找的数据
     * @return 查找不到返回null
     */
    public Node find(int data) {
        Node p = this.tree;
        while (p != null) {
            if(data > p.data) {
                p = p.right;
            } else if(data < p.data) {
                p = p.left;
            } else {
                return p;
            }
        }
        return null;
    }

    /**
     * 插入数据
     * @param data 要插入的数据
     */
    public void insert(int data) {
        if(this.tree == null) {
            this.tree = new Node(data);
            return;
        }
        Node p = this.tree;
        while (p != null) {
            if(data > p.data) {
                if(p.right == null) {
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            } else {
                if(p.left == null) {
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }
        }
    }

    /**
     * 删除数据
     * @param data 要删除的数据
     */
    public void delete(int data) {
        Node p = this.tree;
        Node pp = null;

        //找到要删除的节点
        while (p != null && p.data != data) {
            pp = p;
            if(data > p.data) {
                p = p.right;
            } else {
                p = p.left;
            }
        }

        //p == null 无该数据
        if(p == null) {
            return;
        }

        //删除的结点有两个节点，找到右子树的最小节点替换要删除的节点
        if(p.left != null && p.right != null) {
            Node minP = p.right;
            Node minPP = p;
            while (minP != null) {
                minPP = minP;
                minP = p.left;
            }
            p.data = minP.data;
            pp = minPP;
            p = minP;
        }

        Node child = null;
        if(p.left != null) {
            child = p.left;
        } else if(p.right != null) {
            child = p.right;
        } else {
            child = null;
        }

        if(pp == null) {
            //pp 为 null ，删除的为更节点
            this.tree = child;
        } else if(pp.left == p) {
            pp.left = child;
        } else {
            pp.right = child;
        }
    }

    /**
     * 中序遍历
     */
    public void inOrder() {
        if(this.tree == null) {
            return;
        }
        inOrder(this.tree);
        System.out.println();
    }

    /**
     * 中序遍历
     */
    public void inOrder(Node p) {
        if(p == null) {
            return;
        }
        inOrder(p.left);
        System.out.print(p.data + " ");
        inOrder(p.right);
    }

    public static class Node {
        public int data;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}
