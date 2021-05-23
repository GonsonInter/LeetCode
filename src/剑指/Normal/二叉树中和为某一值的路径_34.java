package 剑指.Normal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class 二叉树中和为某一值的路径_34 {

    /**
     * 递归
     */
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        LinkedList<Integer> path = new LinkedList<>();
        recur(root, sum, path);
        return res;
    }
    public void recur(TreeNode node, int sum, LinkedList<Integer> path) {
        if (node == null)   return;
        path.add(node.val);
        if (sum == node.val && node.left == null && node.right == null) {
            res.add(new LinkedList<Integer>(path));
        }   else {
            recur(node.left, sum - node.val, path);
            recur(node.right, sum - node.val, path);
        }
        path.removeLast();
    }
}
