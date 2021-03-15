package 剑指.Easy;

import java.util.Stack;

public class 二叉搜索树的第k大节点_54 {


//    /**
//     * 反中序遍历
//     */
//    private int res;
//    private int k;
//
//    public int kthLargest(TreeNode root, int k) {
//        this.k = k;
//        inorder(root);
//        return this.res;
//    }
//
//    public void inorder(TreeNode node) {
//        if (node == null)   return;
//        inorder(node.right);
//        if (--this.k == 0)  {
//            this.res = node.val;
//        }
//        inorder(node.left);
//    }


    /**
     * 反中序遍历
     */
    public int kthLargest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        int count = 0;
        while (!stack.empty() || node != null) {
            while (node != null)  {
                stack.push(node);
                node = node.right;
            }
            node = stack.pop();
            if (++ count == k)  return node.val;
            node = node.left;
        }
        return 0;
    }


}
