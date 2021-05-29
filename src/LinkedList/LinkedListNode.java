package LinkedList;

public class LinkedListNode<T> {

    T data;
    LinkedListNode<T> next;

    LinkedListNode(T data) {
        this.data = data;
        next = null; // this is not actually required since the default value is null, but just for clarity
    }


}
