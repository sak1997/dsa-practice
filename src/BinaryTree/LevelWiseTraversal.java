package BinaryTree;

import java.util.*;

// PROBLEM LINK - https://leetcode.com/problems/binary-tree-level-order-traversal/

public class LevelWiseTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> myAns = new ArrayList<>();
        if(root == null)
            return myAns;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(! q.isEmpty()) {

            Queue<TreeNode> tempq = new LinkedList<>();
            while(! q.isEmpty())
                tempq.add(q.poll());

            List<Integer> templist = new ArrayList<>();
            while(! tempq.isEmpty()) {
                TreeNode tempnode = tempq.poll();
                templist.add(tempnode.val);
                if(tempnode.left != null) q.add(tempnode.left);
                if(tempnode.right != null) q.add(tempnode.right);
            }
            myAns.add(templist);
        }

        return myAns;


    }


    public static BinaryTreeNode<Integer> levelwiseInput() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter the root data (-1 to stop) : ");
        int rootdata = scan.nextInt();
        if(rootdata == -1)
            return null; // empty tree

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootdata);
        Queue<BinaryTreeNode<Integer>> myQueue = new LinkedList<>();
        myQueue.add(root);

        while(! myQueue.isEmpty()) {
            BinaryTreeNode<Integer> temp = myQueue.poll();

            System.out.println("Please enter the left and right child of " + temp.data + " (-1 for either/both to stop/null) ");
            int leftval = scan.nextInt();
            int rightval = scan.nextInt();

            if(leftval != -1) {
                BinaryTreeNode<Integer> leftnode = new BinaryTreeNode<>(leftval);
                temp.left = leftnode;
                myQueue.add(leftnode);
            }
            if(rightval != -1) {
                BinaryTreeNode<Integer> rightnode = new BinaryTreeNode<>(rightval);
                temp.right = rightnode;
                myQueue.add(rightnode);
            }
        }

        return root;

    }

}
