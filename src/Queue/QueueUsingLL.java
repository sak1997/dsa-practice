package Queue;

import LinkedList.LinkedListNode;

public class QueueUsingLL<T> {


    //Define the data members
    LinkedListNode<T> front, rear;
    int size;


    public QueueUsingLL() {
        //Implement the Constructor
        front = rear = null;
        size = 0;
    }

    public int getSize() {
        //Implement the getSize() function
        return size;
    }


    public boolean isEmpty() {
        //Implement the isEmpty() function
        return size == 0;
    }


    public void enqueue(T data) {
        //Implement the enqueue(element) function
        if(rear == null) {
            front = rear = new LinkedListNode<T>(data);
            size++;
            return;
        }

        rear.next = new LinkedListNode<T>(data);
        rear = rear.next;
        size++;
        return;

    }


    public T dequeue() throws QueueEmptyException {
        //Implement the dequeue() function
        if(front == null) {
            throw new QueueEmptyException();
        }

        T ans = front.data;
        front = front.next;
        if(front == null) {
            front = rear = null;
        }
        size--;
        return ans;

    }


    public T front() throws QueueEmptyException {
        //Implement the front() function
        if(front == null) {
            throw new QueueEmptyException();
        }

        return front.data;

    }

}
