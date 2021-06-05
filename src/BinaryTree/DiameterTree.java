package BinaryTree;

// PROBLEM LINK - https://leetcode.com/problems/diameter-of-binary-tree/submissions/

class wrapper {
    int d, h;
    wrapper(int d, int h) {
        this.d = d;
        this.h = h;
    }
}

public class DiameterTree {

    public static int diameterOfBinaryTree(BinaryTreeNode<Integer> root){
        //Your code goes here
        if(root == null)
            return 0;

        return diameterOfBinaryTreeHelper(root).d;

    }

    public static wrapper diameterOfBinaryTreeHelper(BinaryTreeNode<Integer> root){
        //Your code goes here
        if(root == null)
            return new wrapper(0, 0);

        if(root.left == null && root.right == null)
            return new wrapper(0, 1);

        wrapper leftside = diameterOfBinaryTreeHelper(root.left);
        wrapper rightside = diameterOfBinaryTreeHelper(root.right);

        int height = 1 + Math.max(leftside.h, rightside.h);
        int dia =  Math.max(1 + leftside.h + rightside.h, Math.max(leftside.d, rightside.d));
        return new wrapper(dia, height);

    }

}
