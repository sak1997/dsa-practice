package BinaryTree;

public class NoOfNodes {

    public static int NoNodes(BinaryTreeNode<Integer> root) {
        if(root == null)
            return 0;

        int ans = 1;
        ans += NoNodes(root.left);
        ans += NoNodes(root.right);
        return ans;

    }

}
