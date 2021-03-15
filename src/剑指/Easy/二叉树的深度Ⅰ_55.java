package 剑指.Easy;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 二叉树的深度Ⅰ_55 {


//    /**
//     * 层序遍历
//     */
//    public int maxDepth(TreeNode root) {
//        if (root == null)   return 0;
//        Deque<TreeNode> queue = new LinkedList<>();
//        int level = 0;
//        TreeNode last = root;
//        TreeNode node;
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            node = queue.poll();
//            if (node.left != null)  queue.offer(node.left);
//            if (node.right != null) queue.offer(node.right);
//            if (node == last && !queue.isEmpty()) {
//                level ++;
//                last = queue.getLast();
//            }
//        }
//        return level;
//    }


//    /**
//     * 层次遍历
//     * 另外一种
//     */
//    public int maxDepth(TreeNode root) {
//        if(root == null) return 0;
//        List<TreeNode> queue = new LinkedList<TreeNode>() {{ add(root); }}, tmp;
//        int res = 0;
//        while(!queue.isEmpty()) {
//            tmp = new LinkedList<>();
//            for(TreeNode node : queue) {
//                if(node.left != null) tmp.add(node.left);
//                if(node.right != null) tmp.add(node.right);
//            }
//            queue = tmp;
//            res++;
//        }
//        return res;
//    }


    /**
     * 深度优先遍历
     */
    public int maxDepth(TreeNode root) {
        if (root == null)  return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

}
