package 剑指.Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 二叉树的最近公共祖先Ⅱ_68 {


//    /**
//     * 后序遍历二叉树，栈中的元素就是从根到它的路径
//     */
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        List<TreeNode> pathp = getPath(root, p);
//        List<TreeNode> pathq = getPath(root, q);
//        TreeNode ancestor = root;
//        for (int i = 1; i < pathp.size() && i < pathq.size(); i ++) {
//            if (pathp.get(i) == pathq.get(i))   ancestor = pathp.get(i);
//            else break;
//        }
//        return ancestor;
//    }
//
//    public List<TreeNode> getPath(TreeNode root, TreeNode p) {
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode node = root;
//        TreeNode last = null;
//        while (!stack.empty() || node != null) {
//            while (node != null) {
//                stack.push(node);
//
//                if (node.val == p.val)
//                    return new ArrayList<>(stack);
//
//                node = node.left;
//            }
//            node = stack.pop();
//            if (node.right != null && node.right != last) {
//                stack.push(node);
//                node = node.right;
//            } else {
//                last = node;
//                node = null;
//            }
//        }
//        return new ArrayList<>();
//    }


    /**
     * K神的题解
     * 也是后序遍历，使用递归
     *
     * 根据以上定义，若 rootroot 是 p, qp,q 的 最近公共祖先 ，则只可能为以下情况之一：
     *
     * p 和 q 在 root 的子树中，且分列 root 的 异侧（即分别在左、右子树中）；
     * p = root ，且 q 在 root 的左或右子树中；
     * q = root ，且 p 在 root 的左或右子树中；
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }




    public static void main(String[] args) {
        Stack<Integer> stk = new Stack<>();
        stk.push(5);
        stk.push(6);
        stk.push(7);
        stk.push(8);

        List<Integer> list = new ArrayList<>(stk);
        for (int i = 0; i < stk.size(); i ++) {
            System.out.print(list.get(i) + " ");
        }
    }

}
