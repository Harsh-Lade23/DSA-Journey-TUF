package stack_and_queues;

import java.util.LinkedList;
import java.util.Queue;


/**
 * Problem: 225. Implement Stack using Queues
 * Implement a last-in-first-out (LIFO) stack using only two queues.
 * The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).

 * Implement the MyStack class:

 * void push(int x) Pushes element x to the top of the stack.
 * int pop() Removes the element on the top of the stack and returns it.
 * int top() Returns the element on the top of the stack.
 * boolean empty() Returns true if the stack is empty, false otherwise.

 * Notes:
 * You must use only standard operations of a queue, which means that only push to back, peek/pop from front,
 * size and is empty operations are valid.
 * Depending on your language, the queue may not be supported natively.
 * You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations.
 */
public class StackUsingQueue {
    Queue<Integer> qu;
    Queue<Integer> helper;

    public StackUsingQueue() {
        qu=new LinkedList<>();
        helper=new LinkedList<>();
    }

    public void push(int x) {
        while(!qu.isEmpty()){
            helper.add(qu.poll());
        }
        qu.add(x);
        while(!helper.isEmpty()){
            qu.add(helper.poll());
        }
    }


    public int pop() {
        if(qu.isEmpty())return -1;
        else return qu.poll();

    }

    public int top() {
        if(qu.isEmpty())return -1;
        else return qu.peek();
    }

    public boolean empty() {
        return qu.isEmpty();
    }


    /*Follow-up: Can you implement the stack using only one queue*/
    /*
    Yes, we can build it.
    If we add any element in queue then it should got to the top then only our queue will work like stack.
    To do so, we will put the element in the end. Then we will run a loop n-1 times, will pop the element from
    front and add into the end so eventually our current added element will get into the front. And we will not
    need any extra queue.

    use this function:
     public void push(int x) {

        qu.add(x);
        int n=qu.size();
        for(int i=0;i<n-1;i++){
            qu.add(qu.poll());
        }

    }

    */

}
