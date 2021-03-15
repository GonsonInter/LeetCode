package 剑指.Easy;

public class 平衡二叉树Ⅱ_55 {

//    /**
//     * 两次递归
//     * 第一次是检查深度
//     */
//    public boolean isBalanced(TreeNode root) {
//        if (root == null)   return true;
//        if (Math.abs(level(root.left) - level(root.right)) > 1)
//            return false;
//        return isBalanced(root.left) && isBalanced(root.right);
//    }
//
//    public int level(TreeNode node) {
//        if (node == null)   return 0;
//        return 1 + Math.max(level(node.left), level(node.right));
//    }


    /**
     * 后序遍历 + 剪枝
     */
    public boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }

    public int recur(TreeNode node) {
        if (node == null)   return 0;
        int left = recur(node.left);
        if (left == -1) return -1;
        int right = recur(node.right);
        if (right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }

}
