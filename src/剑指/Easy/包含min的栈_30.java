package 剑指.Easy;

import java.util.Stack;


///**
// * 双栈法实现最小栈，
// * 保存数字栈的同时维护一个单调栈
// */
//public class 包含min的栈_30 {
//
//    Stack<Integer> stack;
//    Stack<Integer> minStack;    //维护最小值的单调栈
//
//
//    /** initialize your data structure here. */
//    public 包含min的栈_30() {
//        stack = new Stack<>();
//        minStack = new Stack<>();
//    }
//
//    public void push(int x) {
//        stack.push(x);
//        if (minStack.empty() || x < minStack.peek())    minStack.push(x);
//    }
//
//    public void pop() {
//        if (stack.pop().equals(minStack.peek()) && !minStack.empty())    minStack.pop();
//    }
//
//    public int top() {
//        return stack.peek();
//    }
//
//    public int min() {
//        return minStack.peek();
//    }
//}



/**
 * 使用一个栈，
 * 每次压栈的时候，压入之前的栈内最小值以及当前需要压入的值，
 * 出栈的时候弹出两个元素。
 */
public class 包含min的栈_30 {

    Stack<Integer> stack;

    /** initialize your data structure here. */
    public 包含min的栈_30() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.empty()) {
            stack.push(Integer.MAX_VALUE);
        }   else {
            stack.push(Math.min(min(), x));
        }
        stack.push(x);
    }

    public void pop() {
        stack.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        int temp = stack.pop();
        int min = stack.peek();
        stack.push(temp);
        return min;
    }
}
