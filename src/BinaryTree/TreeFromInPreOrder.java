package BinaryTree;

public class TreeFromInPreOrder {

    public static BinaryTreeNode<Integer> buildTree(int[] preOrder, int[] inOrder) {
        //Your code goes here

        int n = preOrder.length;

        if(n == 0)
            return null;

        int rootelement = preOrder[0];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootelement);

        System.out.println("root = " + rootelement);

        if(n == 1)
            return root;

        int[] inOrderLeft, inOrderRight, preOrderLeft, preOrderRight;

        int posroot_inOrder = 0;
        for(int i=0; i<n; i++) {
            if(inOrder[i] == rootelement) {
                posroot_inOrder = i;
                break;
            }
        }

        int leftsize = posroot_inOrder ;
        int rightsize = n - posroot_inOrder -1 ;
        int j = 0;

        if(leftsize > 0) {

            inOrderLeft = new int[leftsize];
            preOrderLeft = new int[leftsize];
            for(int i=0; i<posroot_inOrder; i++) {
                inOrderLeft[i] = inOrder[i];
            }

            j = 0;
            for(int i=1; i < leftsize + 1; i++) {
                preOrderLeft[j++] = preOrder[i];
            }

            root.left = buildTree(preOrderLeft, inOrderLeft);

        }

        if(rightsize > 0) {

            inOrderRight = new int[rightsize];
            preOrderRight = new int[rightsize];
            j = 0;
            for(int i= posroot_inOrder + 1; i<n; i++) {
                inOrderRight[j++] = inOrder[i];
            }

            int rightpos = 1;
            rightpos += leftsize;
            j = 0;
            for(int i= rightpos; i<n; i++) {
                preOrderRight[j++] = preOrder[i];
            }


            root.right = buildTree(preOrderRight, inOrderRight);

        }

        return root;

    }

    public static void main(String arg[]) {

        //1 2 4 5 3 6 7
        //4 2 5 1 6 3 7

        int[] pre = {1, 2, 4, 5, 3, 6, 7};
        int ino[] = {4, 2, 5, 1, 6, 3, 7};
        BinaryTreeNode<Integer> root = buildTree(pre, ino);

        BinaryTreeUse.printTree(root);


    }

}
