package BinarySearchTree;

import BinaryTree.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BST {

    private BinaryTreeNode<Integer> root;

    int size;

    public BST() {
        root = null;
        size = 0;
    }

    public BST(int val) {
        root = new BinaryTreeNode<>(val);
        size = 0;
    }

    public boolean isPresent(int val) {
        return isPresent(val, root);
    }

    private static boolean isPresent(int val, BinaryTreeNode<Integer> rootnode) {

        if(rootnode == null)
            return false;

        if(rootnode.data == val)
            return true;

        if(val < rootnode.data)
            return isPresent(val, rootnode.left);
        else
            return isPresent(val, rootnode.right);

    }

    public BinaryTreeNode<Integer> insert(int val) {

        size++;
        root = insert(root, val);
        return root;
    }

    private static BinaryTreeNode<Integer> insert(BinaryTreeNode<Integer> root, int x) {
        if(root == null) {
            root = new BinaryTreeNode<>(x);
            return root;
        }

        if(x >= root.data) {
            root.right = insert(root.right, x);
        } else {
            root.left = insert(root.left, x);
        }

        return root;

    }

    public boolean delete(int val) {
        DeleteReturn dr = deleteNode(root, val);
        root = dr.root;
        if(dr.deleted)
            size--;
        return dr.deleted;
    }

    private static DeleteReturn deleteNode(BinaryTreeNode<Integer> root, int x) {
        if(root == null)
            return new DeleteReturn(null, false);

        if(root.data < x) {
            DeleteReturn dr = deleteNode(root.right, x);
            root.right = dr.root;
            return new DeleteReturn(root, dr.deleted);
        }

        if(root.data > x) {
            DeleteReturn dr = deleteNode(root.left, x);
            root.left = dr.root;
            return new DeleteReturn(root, dr.deleted);
        }

        // only other condition is root.data == x

        if(root.left == null && root.right == null)
            return new DeleteReturn(null, false);;

        if(root.left == null && root.right != null)
            return new DeleteReturn(root.right, true);

        if(root.left != null && root.right == null)
            return new DeleteReturn(root.left, true);

        // only other case is root==data has both children not null
        int minright = getMin(root.right);
//        System.out.println("min on right = " + minright);
        root.data = minright;
        DeleteReturn dr = deleteNode(root.right, minright);
        root.right = dr.root;
        return new DeleteReturn(root, true);

    }

    private static int getMin(BinaryTreeNode<Integer> root) {
        if(root == null)
            return Integer.MAX_VALUE;

            return Math.min(root.data, Math.min(getMin(root.left), getMin(root.right)) );
    }

    public int size() {
        return size;
    }

    public void printTreeBFS() {
        if(root == null)
            return;

        BinaryTreeNode<Integer> temp = root;
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        q.add(temp);

        while(! q.isEmpty()) {
            Queue<BinaryTreeNode<Integer>> tempq = new LinkedList<>();
            while(! q.isEmpty()) {
                BinaryTreeNode<Integer> temp2 = q.poll();
                System.out.print(temp2.data + " ");
                if(temp2.left != null) tempq.add(temp2.left);
                if(temp2.right != null) tempq.add(temp2.right);
            }

            System.out.println();

            while(! tempq.isEmpty())
                q.add(tempq.poll());

        }

        return;

    }

    public void printTree() {
        printTreeCorrect(root);
    }

    private static void printTreeCorrect(BinaryTreeNode<Integer> root) {
        if(root == null)
            return;

        System.out.print(root.data + " : ");
        if(root.left != null)
            System.out.print("L" + root.left.data + " ");
        if(root.right != null)
            System.out.print("R" + root.right.data);
        System.out.println();

        printTreeCorrect(root.left);
        printTreeCorrect(root.right);
        return;
    }
}
