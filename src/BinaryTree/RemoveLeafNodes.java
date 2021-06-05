package BinaryTree;

public class RemoveLeafNodes {

//    public static boolean checkIfLeaf(BinaryTreeNode<Integer> root) {
//        if(root == null)
//            return true;
//
//        if(root.left == null && root.right == null)
//            return true;
//        return false;
//    }

    public static BinaryTreeNode<Integer> removeLeafNodes(BinaryTreeNode<Integer> root) {

        if(root == null)
            return null;

        if(root.left == null && root.right == null) {
            return null;
        }

        root.left = removeLeafNodes(root.left);
        root.right = removeLeafNodes(root.right);
        return root;

    }

}
