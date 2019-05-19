package tree;

/**
 * Created by xsg on 2019/5/19.
 */
public class BinarySearchTree {

    Node tree;

    /**
     * 查找节点
     * @param data
     * @return
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
     * @param data
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
     * @param data
     */
    public void delete(int data) {
        Node p = this.tree;
        Node pp = null;

        while (p != null && p.data != data) {
            pp = p;
            if(data > p.data) {
                p = p.right;
            } else {
                p = p.left;
            }
        }

        if(p == null) {
            return;
        }

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
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(10);
        tree.insert(9);
        tree.insert(11);
        tree.insert(8);
        tree.insert(12);

        tree.inOrder();

        Node node = tree.find(11);
        System.out.println(node.getData());

        tree.delete(11);

        tree.inOrder();
    }
}
