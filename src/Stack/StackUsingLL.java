package Stack;

import LinkedList.LinkedListNode;

public class StackUsingLL<T> {

    LinkedListNode<T> head, tail;
    int size;

    StackUsingLL() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(T elm) {
        LinkedListNode<T> node = new LinkedListNode<T>(elm);
        node.next = head;
        head = node;
        if(size == 0)
            tail = head;
        size++;
        return;
    }

    public T top() {
        return head.data;
    }

    public T pop() throws StackEmptyException {

        if(size == 0)
            throw new StackEmptyException();
        T data = head.data;
        size--;
        return data;
    }


}
