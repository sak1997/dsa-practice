package BinaryTree;

public class NoOfLeaves {

    public static int noOfLeaves(BinaryTreeNode<Integer> root) {
        if(root == null)
            return 0;

        if(root.left == null && root.right == null)
            return 1;

        return noOfLeaves(root.left) + noOfLeaves(root.right);
    }

}
