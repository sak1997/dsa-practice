package BinaryTree;

public class NodesDepthK {

    public static void nodesAtDepthK(BinaryTreeNode<Integer> root, int k) {

        if(root == null)
            return;

        if(k == 0) {
            System.out.println(root.data);
            return;
        }

        nodesAtDepthK(root.left, k-1);
        nodesAtDepthK(root.right, k-1);
        return;

    }

}
