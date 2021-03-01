package Easy;

import java.util.Stack;

public class 用栈实现队列_232 {

    private Stack<Integer> stk1;
    private Stack<Integer> stk2;

    /** Initialize your data structure here. */
    public 用栈实现队列_232() {
        stk1 = new Stack<>();
        stk2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!stk1.empty()) {
            stk2.push(stk1.pop());
        }
        stk2.push(x);
        while (!stk2.empty()) {
            stk1.push(stk2.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stk1.pop();
    }

    /** Get the front element. */
    public int peek() {
        return stk1.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stk1.empty();
    }
}
