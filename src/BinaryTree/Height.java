package BinaryTree;

public class Height {

    public static int height(BinaryTreeNode<Integer> root) {
        //Your code goes here

        if(root == null)
            return 0;

        return 1 + Math.max(height(root.left), height(root.right));
    }

}
