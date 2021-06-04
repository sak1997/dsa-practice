package Stack;

import java.util.Stack;

public class StackCollectionsUse {

    public static void main(String arg[]) {
        Stack<Integer> stack = new Stack<>();

        int i=0;
        while(i++ < 7) {
            stack.push(i * 10);
        }

        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
            System.out.println("size = " + stack.size());
        }

    }
}
