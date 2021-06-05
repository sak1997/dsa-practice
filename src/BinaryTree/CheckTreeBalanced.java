package BinaryTree;

import java.lang.Math;

// PROBLEM LINK - https://leetcode.com/problems/balanced-binary-tree/submissions/

class boolval {
    int val;
    boolean bool;

    boolval(int val, boolean bool) {
        this.val = val;
        this.bool = bool;
    }
}

public class CheckTreeBalanced {

//    public static boolean isBalanced(BinaryTreeNode<Integer> root) {
//
//        if(root == null)
//            return true;
//
//        int leftheight = height(root.left);
//        boolean isLeftBalanced = isBalanced(root.left);
//
//        int rightheight = height(root.right);
//        boolean isRightBalanced = isBalanced(root.right);
//
//        int diff = Math.abs(leftheight - rightheight);
//        if(diff <= 1)
//            return true && isLeftBalanced && isRightBalanced;
//        else
//            return false;
//
//    }
//
//
//    public static int height(BinaryTreeNode<Integer> root) {
//        if(root == null)
//            return 0;
//
//        return 1 + Math.max(height(root.left), height(root.right));
//    }

    public static boolean isBalanced(BinaryTreeNode<Integer> root) {

        if(root == null)
            return true;

        boolval myans = isBalancedHelper(root);
        return myans.bool;


    }

    public static boolval isBalancedHelper(BinaryTreeNode<Integer> root) {

        if(root == null)
            return new boolval(0, true);

        boolval leftside = isBalancedHelper(root.left);
        boolval rightside = isBalancedHelper(root.right);

        int currheight = 1 + Math.max(leftside.val, rightside.val);

        boolean ans = false;
        if(Math.abs(leftside.val - rightside.val) <= 1)
            ans = true;
        ans = ans && leftside.bool && rightside.bool;

        return new boolval(currheight, ans);
    }



}
