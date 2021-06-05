package BinaryTree;

public class SumOfNodes {

    public static int getSum(BinaryTreeNode<Integer> root) {
        //Your code goes here.

        if(root == null)
            return 0;

        int ans = root.data;
        ans += getSum(root.left);
        ans += getSum(root.right);
        return ans;
    }

}
