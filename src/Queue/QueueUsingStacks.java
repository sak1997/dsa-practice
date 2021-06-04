package Queue;

import java.util.Stack;

/*
PROBLEM LINK
https://leetcode.com/problems/implement-queue-using-stacks/solution/
 */

public class QueueUsingStacks {

    Stack<Integer> s1, s2;
    int size;

    /** Initialize your data structure here. */
    public QueueUsingStacks() {

        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
        size = 0;

    }

    /** Push element x to the back of queue. */
    public void push(int x) {

        while(! s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s1.push(x);
        while(! s2.isEmpty()) {
            s1.push(s2.pop());
        }
        size++;
        return;

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {

        size--;
        return s1.pop();

    }

    /** Get the front element. */
    public int peek() {

        return s1.peek();

    }

    /** Returns whether the queue is empty. */
    public boolean empty() {

        return size == 0;

    }

}
