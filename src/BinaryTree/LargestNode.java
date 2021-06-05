package BinaryTree;

import java.lang.Math;

public class LargestNode {

    //assume that all the numbers are positive
    // if root == null return -1

    public static int largestNode(BinaryTreeNode<Integer> root) {
        if(root == null)
            return -1; // or Integer.MIN_VALUE

        return Math.max(root.data, Math.max(largestNode(root.left), largestNode(root.right)));

    }

}
