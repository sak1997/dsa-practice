package BinarySearchTree;

public class isValidBST {

    public boolean isValidBST(TreeNode root) {
        return isValidBSTBetterHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean isValidBSTBetterHelper(TreeNode root, long min, long max) {
        if(root == null)
            return true;

        if(root.val <= min || root.val >= max)
            return false;

        return isValidBSTBetterHelper(root.left, min, root.val) && isValidBSTBetterHelper(root.right, root.val, max);
    }

    public static void main(String arg[]) {
        String ans = "a";
        System.out.println(ans.length());
    }

}
