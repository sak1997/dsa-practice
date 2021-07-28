package BinarySearchTree;

import BinaryTree.BinaryTreeNode;
import Queue.QueueEmptyException;
import Queue.QueueUsingLL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class PairSum {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static BinaryTreeNode<Integer> takeInput() throws IOException {
        st = new StringTokenizer(br.readLine());
        int rootData = Integer.parseInt(st.nextToken());
        if (rootData == -1) {
            return null;
        }
        QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<BinaryTreeNode<Integer>>();
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
        pendingNodes.enqueue(root);

        while (!pendingNodes.isEmpty()) {
            BinaryTreeNode<Integer> currentNode;
            try {
                currentNode = pendingNodes.dequeue();
            } catch (QueueEmptyException e) {
                return null;
            }
            int leftChildData = Integer.parseInt(st.nextToken());
            if (leftChildData != -1) {
                BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(leftChildData);
                currentNode.left = leftChild;
                pendingNodes.enqueue(leftChild);
            }
            int rightChildData = Integer.parseInt(st.nextToken());
            if (rightChildData != -1) {
                BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(rightChildData);
                currentNode.right = rightChild;
                pendingNodes.enqueue(rightChild);
            }
        }
        return root;
    }

    public static void main(String[] args) throws IOException {
        BinaryTreeNode<Integer> root = takeInput();
        System.out.println(" value of s ? ");
        int s = Integer.parseInt(br.readLine());
        printNodesSumToS(root,s);
    }

    public static void printNodesSumToS(BinaryTreeNode<Integer> root, int s) {
        // Write your code here

        if(root == null)
            return;

        Stack<BinaryTreeNode<Integer>> s1 = new Stack<>();
        Stack<BinaryTreeNode<Integer>> s2 = new Stack<>();

        BinaryTreeNode<Integer> curr1 = root, curr2 = root, save1 = null, save2 = null;
        boolean done1 = false, done2 = false;

        while(true) {

            while(!done1 && (curr1 != null || !s1.isEmpty())) {
                while(curr1 != null) {
                    s1.push(curr1);
                    curr1 = curr1.left;
                }
                curr1 = s1.pop();
                save1 = curr1;

                curr1 = curr1.right;
                done1 = true;
                // break;
            }

            while(!done2 && (curr2 != null || !s2.isEmpty())) {
                while(curr2 != null) {
                    s2.push(curr2);
                    curr2 = curr2.right;
                }
                curr2 = s2.pop();
                save2 = curr2;

                curr2 = curr2.left;
                done2 = true;
                // break;
            }

            int val1 = save1.data, val2 = save2.data;

            // System.out.println(val1 + " " + val2 + " here");

            if(val1 >= val2)
                break;

            if(val1 + val2 == s)
                print(val1, val2);

            if(val1 + val2 < s) {
                done1 = false;
                done2 = true;
            } else {
                done1 = true;
                done2 = false;
            }

        }
    }


    static void print(int x, int y) {
        if(x < y)
            System.out.println(x + " " + y);
        else
            System.out.println(y + " " + x);
    }

}
