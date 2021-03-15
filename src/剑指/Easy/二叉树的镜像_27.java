package 剑指.Easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class 二叉树的镜像_27 {


//    /**
//     * 递归实现
//     */
//    public TreeNode mirrorTree(TreeNode root) {
//        if (root == null)   return null;
//        TreeNode temp = root.left;
//        root.left = root.right;
//        root.right = temp;
//        mirrorTree(root.left);
//        mirrorTree(root.right);
//        return root;
//    }

//    /**
//     * 辅助栈实现
//     * 用栈先序遍历整个二叉树，并把每个子树镜像
//     */
//    public TreeNode mirrorTree(TreeNode root) {
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
//        TreeNode p = null;
//        while (!stack.empty() || p != null) {
//            if (!stack.empty()) p = stack.pop();
//            if (p != null) {
//                TreeNode temp = p.left;
//                p.left = p.right;
//                p.right = temp;
//
//                stack.push(p.left);
//                stack.push(p.right);
//            }
//        }
//        return root;
//    }

    /**
     * 用队列层序遍历
     */
    public TreeNode mirrorTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;

                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return root;
    }

}
