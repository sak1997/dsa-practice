package Stack;

import java.util.SplittableRandom;

public class StackUse {

    public static void main(String arg[]) {

        try{
//            StackUsingArray stack = new StackUsingArray(5);
            StackUsingLL<Integer> stack = new StackUsingLL<>();
            int i=0;
            while(i++ < 7) {
                stack.push(i * 10);
            }

            while(!stack.isEmpty()) {
                System.out.println(stack.pop());
                System.out.println("size = " + stack.size());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
