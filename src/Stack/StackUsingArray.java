package Stack;

import java.util.Stack;

public class StackUsingArray {

    private int data[];
    private int top;
    private int size;

    public StackUsingArray() {
        data = new int[10];
        top = -1;
        size = 10;
    }

    public StackUsingArray(int size) {
        data = new int[size];
        top = -1;
        this.size = size;
    }

    private void doubleSize() {

        int temp[] = new int[size*2];
        for(int i=0; i<size; i++) {
            temp[i] = data[i];
        }
        data = temp;
        return;

    }

    public void push(int elm) throws StackFullException {

        if(size == top+1) {
            doubleSize();
            System.out.println("resize done!");
        }

        data[++top] = elm;
        return;

    }

    public int size() {
        return top + 1;
    }

    public int top() throws StackEmptyException {
        if(top == -1)
            throw new StackEmptyException();
        else
            return data[top];
    }

    public int pop() throws StackEmptyException {
        if(top == -1)
            throw new StackEmptyException();
        else
        {
            int ans = data[top--];
            return ans;
        }
  }

    public boolean isEmpty() {
        if(top == -1)
            return true;
        else
            return false;
    }

}
