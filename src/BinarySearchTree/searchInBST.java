package BinarySearchTree;

import BinaryTree.BinaryTreeNode;

public class searchInBST {

    public static boolean searchInBST(BinaryTreeNode<Integer> root, int k) {

        if(root == null)
            return false;

        if(root.data == k)
            return true;

        if(k < root.data)
            return searchInBST(root.left, k);
        else
            return searchInBST(root.right, k);
    }

    public static void main(String arg[]) {

    }

}
