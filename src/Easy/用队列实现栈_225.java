package Easy;

import java.util.LinkedList;
import java.util.Queue;

public class 用队列实现栈_225 {

    private Queue<Integer> queue;

    /** Initialize your data structure here. */
    public 用队列实现栈_225() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        int n = queue.size();
        queue.offer(x);
        for (int i = 0; i < n; i++) {
            queue.offer(queue.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.size() > 0 ? queue.poll() : Integer.MIN_VALUE;
    }

    /** Get the top element. */
    public int top() {
        return queue.size() > 0 ? queue.peek() : Integer.MIN_VALUE;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.size() == 0;
    }
}
