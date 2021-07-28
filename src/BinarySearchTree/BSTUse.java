package BinarySearchTree;

public class BSTUse {

    public static void main(String arg[]) {
        BST bst = new BST();
        bst.insert(5);
        bst.insert(2);
        bst.insert(7);
        bst.insert(1);
//        bst.insert(4);
        bst.insert(3);
        bst.insert(6);
        bst.insert(8);

        bst.printTree();

        System.out.println("is 5 present = " + bst.isPresent(5));
        bst.delete(5);
        System.out.println("is 5 present = " + bst.isPresent(5));

        bst.printTree();

        bst.delete(2);
        System.out.println("is 2 present " + bst.isPresent(2));
        bst.printTree();

    }

}
