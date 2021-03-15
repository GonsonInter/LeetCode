package 剑指.Easy;

import javax.transaction.TransactionRequiredException;
import java.lang.reflect.Array;
import java.util.*;

public class 对称的二叉树_28 {

//    /**
//     * 递归
//     */
//    public boolean isSymmetric(TreeNode root) {
//        if (root == null)   return true;
//        return recur(root.left, root.right);
//    }
//    public boolean recur(TreeNode left, TreeNode right) {
//        if (left == null && right == null)  return true;
//        if (left == null || right == null || left.val != right.val)  return false;
//        return recur(left.left, right.right) && recur(left.right, right.left);
//    }

//    /**
//     * 用栈实现
//     */
//    public boolean isSymmetric(TreeNode root) {
//        if (root == null)   return true;
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root.left);
//        stack.push(root.right);
//
//        while (!stack.empty()) {
//            TreeNode left = stack.pop();
//            TreeNode right = stack.pop();
//            if (left == null && right == null)  continue;
//            if (left == null || right == null || left.val != right.val)  return false;
//            stack.push(left.left);
//            stack.push(right.right);
//            stack.push(left.right);
//            stack.push(right.left);
//        }
//        return true;
//    }


    /**
     * 队列实现
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null)   return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null)  continue;
            if (left == null || right == null || left.val != right.val) return false;
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }


    public static void main(String[] args) {

    }
}
