package Queue;

import Stack.StackUsingLL;

import java.util.Queue;

public class QueueUse {

    public static void main(String arg[])  {

        QueueUsingLL<Integer> queue = new QueueUsingLL<Integer>();
        try {
            int i = 0;
            while (i++ < 7) {
                queue.enqueue(i * 10);
//                System.out.println("i = " + i);
            }

            while (!queue.isEmpty()) {
                System.out.println(queue.dequeue());
//                System.out.println("size = " + queue.size());
            }
        } catch (QueueEmptyException e) {

        }


    }
}
