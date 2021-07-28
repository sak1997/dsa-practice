package BinaryTree;

public class BinaryTreeNode<T> {

    public T data;
    public BinaryTreeNode<T> left, right;

    public BinaryTreeNode() {
        data = null;
        left = right = null;
    }

    public BinaryTreeNode(T data) {
        this.data = data;
        left = right = null;
    }



}
