package Queue;

public class QueueUsingArray {

    private int[] data;
    private int front, rear; // index of elements at the front and rear of the queue
    private int size;

    public QueueUsingArray() {
        data = new int[10];
        front = rear = -1;
        size = 0;
    }

    public QueueUsingArray(int size) {
        data = new int[size];
        front = rear = -1;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(int el) throws QueueFullException {

        if(size == data.length) {
            doubleCapacity();
        }

        if(rear == -1) {
            front = 0;
        }

        rear = (rear + 1) % data.length;
        data[rear] = el;
        size++;
        return;
    }

    public int front() throws QueueEmptyException {

        if(size == 0)
            throw new QueueEmptyException();

        return data[front];
    }

    public int dequeue() throws QueueEmptyException {
        if(size == 0)
            throw new QueueEmptyException();

        int ans = data[front];
        front = (front + 1) % data.length;
        size--;

        if(front == rear) {
            data[0] = data[rear];
            front = rear = 0;
        } else if(size == 0) {
            front = rear = -1;
        }

        return ans;

    }

    private void doubleCapacity() {

        int arr[] = new int[data.length * 2];
        int temp = size, i = front, j = 0;

        while(temp != 0) {
            arr[j++] = data[front];
            front = (front + 1) % data.length;
            temp--;
        }

        data = arr;
        front = 0;
        rear = size-1;
        return;

    }



}
