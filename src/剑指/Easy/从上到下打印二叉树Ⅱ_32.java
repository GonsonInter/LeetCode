package 剑指.Easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 从上到下打印二叉树Ⅱ_32 {

    /**
     * 当遍历完一层时，队列的大小就是下一层元素的个数
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)   return new ArrayList<>();
        Queue<TreeNode>  queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int levelSum = queue.size();    //获取当前队列的长度，就是一层的元素个数
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < levelSum; i ++) {
                TreeNode temp = queue.poll();
                level.add(temp.val);
                if (temp.left != null)  queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
            }
            res.add(level);
        }
        return res;
    }
}
