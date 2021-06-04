package Queue;

import java.util.Queue;

/*
For a given queue containing all integer data, reverse the first K elements.
You have been required to make the desired change in the input queue itself.

Sample Input 1:
5 3
1 2 3 4 5
Sample Output 1:
3 2 1 4 5
Sample Input 2:
7 7
3 4 2 5 6 7 8
Sample Output 2:
8 7 6 5 2 4 3

 */

public class ReverseFirstKElementsQueue {


    public static Queue<Integer> reverseKElements(Queue<Integer> input, int k) {
        //Your code goes here

        input = reverseKElementsHelper(input, k);
        int n = input.size();

        int rem = n - k;
        for(int i = 0; i<rem; i++) {
            input.add(input.poll());
        }
        return input;

    }

    public static Queue<Integer> reverseKElementsHelper(Queue<Integer> input, int k) {

        if(input == null)
            return input;

        if(input.size() == 0)
            return input;

        if(k <= 0)
            return input;

        int el = input.poll();
        input = reverseKElementsHelper(input, k-1);
        input.add(el);
        return input;
    }

}
