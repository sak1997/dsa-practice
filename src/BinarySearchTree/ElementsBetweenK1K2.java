package BinarySearchTree;

import BinaryTree.BinaryTreeNode;

public class ElementsBetweenK1K2 {

    public static void elementsInRangeK1K2(BinaryTreeNode<Integer> root, int k1, int k2){

        if(root == null)
            return;

        // System.out.print(root.data + " ");

        if(root.data < k1) {
            elementsInRangeK1K2(root.right, k1, k2);
            return;
        }

        if(root.data > k2) {
            elementsInRangeK1K2(root.left, k1, k2);
            return;
        }

        elementsInRangeK1K2(root.left, k1, k2);
        System.out.print(root.data + " ");
        elementsInRangeK1K2(root.right, k1, k2);
        return;

    }
}
