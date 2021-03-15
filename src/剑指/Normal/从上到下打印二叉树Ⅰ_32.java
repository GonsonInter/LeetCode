package 剑指.Normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 从上到下打印二叉树Ⅰ_32 {

    /**
     * 层序遍历
     */
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[] {};
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            res.add(temp.val);
            if (temp.left != null)  queue.offer(temp.left);
            if (temp.right != null) queue.offer(temp.right);
        }
        return res.stream().mapToInt(k -> k).toArray();     // 将ArrayList<Integer>转化为int[]
    }
}
