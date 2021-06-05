package BinaryTree;

import java.util.Scanner;

public class BinaryTreeUse {

    public static BinaryTreeNode<Integer> takeInput() {

        System.out.println("Please enter the value of the node (-1 to stop): ");
        Scanner scan = new Scanner(System.in);
        int nodeval = scan.nextInt();

        if(nodeval == -1)
            return null;

        BinaryTreeNode<Integer> mynode = new BinaryTreeNode<Integer>(nodeval);
        System.out.println("Please enter left child of " + mynode.data);
        mynode.left = takeInput();
        System.out.println("Please enter right child of " + mynode.data);
        mynode.right = takeInput();
        return mynode;
    }

    public static BinaryTreeNode<Integer> takeInputBetter(boolean isRoot, int parentData, boolean isLeft) {

        if(isRoot) {
            System.out.println("Please enter the value of the node (-1 to stop): ");
        } else {
            if(isLeft) {
                System.out.println("Please enter left child of " + parentData);
            } else {
                System.out.println("Please enter right child of " + parentData);
            }
        }

        Scanner scan = new Scanner(System.in);
        int nodeval = scan.nextInt();

        if(nodeval == -1)
            return null;

        BinaryTreeNode<Integer> mynode = new BinaryTreeNode<Integer>(nodeval);
        mynode.left = takeInputBetter(false, nodeval, true);
        mynode.right = takeInputBetter(false, nodeval, false);
        return mynode;
    }

    public static void printTree(BinaryTreeNode root) {
        if(root == null)
            return;

        System.out.print(root.data + " : ");
        if(root.left != null)
            System.out.print("L" + root.left.data + " ");
        if(root.right != null)
            System.out.print("R" + root.right.data);
        System.out.println();

        printTree(root.left);
        printTree(root.right);
        return;

    }

    public static void main(String arg[]) {
        /*
    Assume we want to create a Binary Tree like this:
        1
       /  \
       2   3
       \   /
        5 4
     */

        BinaryTreeNode<Integer> root = takeInputBetter(true, 0, false);
//        printTree(root);
//        System.out.println("No of nodes is : " + NoOfNodes.NoNodes(root));
//        System.out.println("Largest Node is : " + LargestNode.largestNode(root));
//        System.out.println("No of leaves is : " + NoOfLeaves.noOfLeaves(root));
          System.out.println("No of leaves at depth 2 is : ");
          NodesDepthK.nodesAtDepthK(root, 2);



    }

}
