package Stack;

import java.util.Stack;

public class MinimumBracketReversal {

    public static int countBracketReversals(String input) {
        //Your code goes here

        int n = input.length();

        Stack<Character> stack = new Stack<Character>();
        System.out.println("here " + n);

        for(int i=0; i<n; i++) {
            char curr = input.charAt(i);

            if(curr == '(') {
                stack.push(curr);
                System.out.println("here");
            }
            else if (curr == ')') {
                System.out.println("here2");
                char top = stack.peek();
                if(top == '(')
                    stack.pop();
                else
                    stack.push(curr);
            }
        }

        int noleft = stack.size();
        if(noleft % 2 == 1)
            return -1;
        else {
            return noleft/2;
        }
    }

    public static void main(String arg[]) {
        String ques = "{{{{}}";
        System.out.println(countBracketReversals(ques));

    }

}
