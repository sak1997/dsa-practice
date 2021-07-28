package BinarySearchTree;

import BinaryTree.BinaryTreeNode;

public class SortedArrayToBST {

    public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr){
        int n = arr.length;
        if(n == 0)
            return null;
        if(n == 1)
            return new BinaryTreeNode<Integer>(arr[0]);

        return SortedArrayToBSTHelper(arr, 0, n-1);

    }

    public static BinaryTreeNode<Integer> SortedArrayToBSTHelper(int[] arr, int left, int right){

        if(left > right) {
            return null;
        }

        int mid = left + (right - left)/2 ;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(arr[mid]);
        root.left = SortedArrayToBSTHelper(arr, left, mid-1);
        root.right = SortedArrayToBSTHelper(arr, mid + 1, right);
        return root;

    }
}
