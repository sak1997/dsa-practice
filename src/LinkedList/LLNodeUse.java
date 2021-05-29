package LinkedList;

public class LLNodeUse {

    public static LinkedListNode<Integer> createLinkedList() {
        LinkedListNode<Integer> first = new LinkedListNode<>(10);
        LinkedListNode<Integer> second = new LinkedListNode<>(20);
        LinkedListNode<Integer> third = new LinkedListNode<>(30);
        LinkedListNode<Integer> fourth = new LinkedListNode<>(40);

        first.next = second;
        second.next = third;
        third.next = fourth;

        // fourth.next is already null by default or as assigned in the constructor
        return first; // returning the head of the newly created linked list

    }

    public static void printLL(LinkedListNode head) {

        LinkedListNode<Integer> tmp = head;
        tmp.data++;

        System.out.println("head data = " + head.data);
        System.out.println("head reference = " + head);

        while(tmp != null) {
            System.out.print(tmp.data + " -> ");
            tmp = tmp.next;
        }
        System.out.print("null\n");
        return;

    }

    public static void main(String arg[]) {
        LinkedListNode<Integer> n1 = new LinkedListNode<Integer>(10);
        System.out.println("n1 data = " + n1.data);
        System.out.println("n1 reference = " + n1);

        LinkedListNode<Integer> newnode = createLinkedList();
//        LinkedListNode<Integer> tmp = newnode;
//        while(tmp != null) {
//            System.out.print(tmp.data + " -> ");
//            tmp = tmp.next;
//        }

        System.out.println("newnode data = " + newnode.data);
        System.out.println("newnode reference = " + newnode);
        printLL(newnode);

        System.out.println("newnode data = " + newnode.data);
        System.out.println("newnode reference = " + newnode);
        printLL(newnode);

        // the output here is the linked list printed out twice
        // while java, in general, uses pass-by-value, when we deal with objects,
        // we are really dealing with object-handles called references which are passed-by-value as well.
        // so, the reference of the object is passed by value - changes to the object itself like head.data++ WILL
        // change the value, but since head in the function call for printLL(newnode) is a different variable
        // with the same reference, we are able to print the linkedlist without newnode being lost in the process

    }

}
