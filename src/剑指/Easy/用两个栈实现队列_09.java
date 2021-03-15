package 剑指.Easy;

import java.util.Stack;

public class 用两个栈实现队列_09 {

//    /**
//     * 每次压栈都要倒洗
//     */
//    class CQueue {
//
//        private Stack<Integer> stk1;
//        private Stack<Integer> stk2;
//
//        public CQueue() {
//            stk1 = new Stack<>();
//            stk2 = new Stack<>();
//        }
//
//        public void appendTail(int value) {
//            while (!stk1.empty()) {
//                stk2.push(stk1.pop());
//            }
//            stk2.push(value);
//            while (!stk2.empty()) {
//                stk1.push(stk2.pop());
//            }
//        }
//
//        public int deleteHead() {
//            if (stk1.size() == 0)   return -1;
//            return stk1.pop();
//        }
//    }


    /**
     * 摊还操作
     * 维护两个栈，第一个栈支持插入操作，第二个栈支持删除操作。
     *
     * 根据栈先进后出的特性，我们每次往第一个栈里插入元素后，第一个栈的底部元素是最后插入的元素，第一个栈的顶部元素是下一个待删除的元素。
     * 为了维护队列先进先出的特性，我们引入第二个栈，用第二个栈维护待删除的元素，在执行删除操作的时候我们首先看下第二个栈是否为空。
     * 如果为空，我们将第一个栈里的元素一个个弹出插入到第二个栈里，这样第二个栈里元素的顺序就是待删除的元素的顺序，
     * 要执行删除操作的时候我们直接弹出第二个栈的元素返回即可。
     *
     */
    class CQueue {

        private Stack<Integer> stk1;
        private Stack<Integer> stk2;

        public CQueue() {
            stk1 = new Stack<>();
            stk2 = new Stack<>();
        }

        public void appendTail(int value) {
            stk1.push(value);
        }

        public int deleteHead() {
            if (stk2.size() == 0) {
                while (stk1.size() > 0) {
                    stk2.push(stk1.pop());
                }
            }
            if (stk2.size() == 0)   return -1;
            return stk2.pop();
        }
    }


}
