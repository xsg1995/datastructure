package tree;

import java.util.LinkedList;

/**
 * Created by xsg on 2019/5/17.
 */
public class BinaryTreeBaseLinked<T> {

    //保存数据
    private T data;
    //左子树
    private BinaryTreeBaseLinked<T> left;
    //右子树
    private BinaryTreeBaseLinked<T> right;

    public BinaryTreeBaseLinked(T data) {
        this.data = data;
    }

    /**
     * 插入左节点，并返回插入的节点
     * @param data
     * @return
     */
    public BinaryTreeBaseLinked<T> addToLeft(T data) {
        BinaryTreeBaseLinked<T> newNode = new BinaryTreeBaseLinked<>(data);
        this.left = newNode;

        return newNode;
    }

    /**
     * 插入右节点，并返回插入的节点
     * @param data
     * @return
     */
    public BinaryTreeBaseLinked<T> addToRight(T data) {
        BinaryTreeBaseLinked<T> newNode = new BinaryTreeBaseLinked<>(data);
        this.right = newNode;

        return newNode;
    }

    /**
     * 前序遍历
     * @param root
     */
    public static void preOrder(BinaryTreeBaseLinked root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 中序遍历
     * @param root
     */
    public static void inOrder(BinaryTreeBaseLinked root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    /**
     * 后序遍历
     * @param root
     */
    public static void postOrder(BinaryTreeBaseLinked root) {
        if(root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    /**
     * 层级遍历
     * @param root
     */
    public static void levelOrder(BinaryTreeBaseLinked root) {
        if(root == null) {
            return;
        }
        LinkedList<BinaryTreeBaseLinked> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinaryTreeBaseLinked node = queue.poll();
            System.out.print(node.data + " ");
            if(node.left != null) {
                queue.offer(node.left);
            }
            if(node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTreeBaseLinked<Integer> root = new BinaryTreeBaseLinked<>(10);
        BinaryTreeBaseLinked leftNode = root.addToLeft(4);
        BinaryTreeBaseLinked<Integer> rightNode = root.addToRight(5);
        leftNode.addToLeft(12);
        leftNode.addToRight(13);
        rightNode.addToLeft(15);
        rightNode.addToRight(16);

        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        levelOrder(root);
    }
}
