package 剑指.Normal;

import java.util.Stack;

public class 栈的压入弹出序列_31 {

//    /**
//     * 维护一个栈模拟操作
//     */
//    public boolean validateStackSequences(int[] pushed, int[] popped) {
//        Stack<Integer> stack = new Stack<>();
//        boolean[] visited = new boolean[pushed.length];
//        for (int i = 0; i < popped.length; i ++) {
//            int j = 0;
//            while (pushed[j] != popped[i]) {
//                if (!visited[j]) {
//                    stack.push(pushed[j]);
//                    visited[j] = true;
//                }
//                j ++;
//            }
//            if (!visited[j]) {
//                stack.push(pushed[j]);
//                visited[j] = true;
//            }
//
//            if (!stack.empty() && stack.peek().equals(popped[i]))  stack.pop();
//        }
//        return stack.empty();
//    }


    /**
     * 题解大佬的代码
     *
     * 使用辅助栈来模拟弹入弹出操作
     * 并且使用一个索引来标记弹出的元素
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;

        for (int num : pushed) {
            stack.push(num);
            if (!stack.empty() && stack.peek().equals(popped[index])) {
                stack.pop();
                index ++;
            }
        }

        return stack.empty();
    }


    public static void main(String[] args) {
        boolean[] visited = new boolean[5];
        for (boolean b : visited) {
            System.out.println(b);
        }
    }
}
