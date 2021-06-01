package LinkedList;

import java.util.Scanner;

public class LinkedListNode<T> {

    public T data;
    public LinkedListNode<T> next;

    public LinkedListNode(T data) {
        this.data = data;
        next = null; // this is not actually required since the default value is null, but just for clarity
    }

    public static LinkedListNode<Integer> takeLLInput() {
        Scanner scan = new Scanner(System.in);

        int val = scan.nextInt();
        LinkedListNode<Integer> head = null;
        LinkedListNode<Integer> tail = null;

        while(val != -1) {
            LinkedListNode<Integer> node = new LinkedListNode<>(val);
            if(head == null) // if head is null, then we have just gotten the first value. So make head this first node
            {
                head = node;
                tail = node;
            }

            tail.next = node;
            tail = tail.next;

            val = scan.nextInt();
        }

        return head;
    }



    }


