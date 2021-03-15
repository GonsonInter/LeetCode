package 剑指.Normal;

import java.util.*;

public class 从上到下打印二叉树Ⅲ_32 {

//    /**
//     * 层序遍历加上列表反转
//     */
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        if (root == null)   return new ArrayList<>();
//        Queue<TreeNode> queue = new LinkedList<>();
//        List<List<Integer>> res = new ArrayList<>();
//        queue.offer(root);
//        int level = 0;      // 记录层数
//
//        while (!queue.isEmpty()) {
//            level ++;
//            int levelNum = queue.size();
//            ArrayList<Integer> currentLevel = new ArrayList<>();
//            for (int i = 0; i < levelNum; i ++) {
//                TreeNode temp = queue.poll();
//                currentLevel.add(temp.val);
//                if (temp.left != null)  queue.offer(temp.left);
//                if (temp.right != null) queue.offer(temp.right);
//            }
//            if ((level & 1) == 0)   Collections.reverse(currentLevel);
//            res.add(currentLevel);
//        }
//
//        return res;
//    }


//    /**
//     * 层序遍历加上双端队列
//     * 奇数层队列从左入队
//     * 偶数从右入队
//     */
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        Queue<TreeNode> queue = new LinkedList<>();
//        List<List<Integer>> res = new ArrayList<>();
//        if(root != null) queue.add(root);
//        while(!queue.isEmpty()) {
//            LinkedList<Integer> tmp = new LinkedList<>();
//            for(int i = queue.size(); i > 0; i--) {
//                TreeNode node = queue.poll();
//                if(res.size() % 2 == 0) tmp.addLast(node.val); // 偶数层 -> 队列头部
//                else tmp.addFirst(node.val); // 奇数层 -> 队列尾部
//                if(node.left != null) queue.add(node.left);
//                if(node.right != null) queue.add(node.right);
//            }
//            res.add(tmp);
//        }
//        return res;
//    }


    /**
     * 层序遍历 + 双端队列（奇偶层逻辑分离）
     * 方法一、二代码简短、容易实现；但需要判断每个节点的所在层奇偶性，即冗余了 NN 次判断。
     * 通过将奇偶层逻辑拆分，可以消除冗余的判断。
     *
     * BFS 循环： 循环打印奇 / 偶数层，当 deque 为空时跳出；
     * 打印奇数层： 从左向右 打印，先左后右 加入下层节点；
     * 若 deque 为空，说明向下无偶数层，则跳出；
     * 打印偶数层： 从右向左 打印，先右后左 加入下层节点；
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) deque.add(root);
        while(!deque.isEmpty()) {
            // 打印奇数层
            List<Integer> tmp = new ArrayList<>();
            for(int i = deque.size(); i > 0; i--) {
                // 从左向右打印
                TreeNode node = deque.removeFirst();
                tmp.add(node.val);
                // 先左后右加入下层节点
                if(node.left != null) deque.addLast(node.left);
                if(node.right != null) deque.addLast(node.right);
            }
            res.add(tmp);
            if(deque.isEmpty()) break; // 若为空则提前跳出
            // 打印偶数层
            tmp = new ArrayList<>();
            for(int i = deque.size(); i > 0; i--) {
                // 从右向左打印
                TreeNode node = deque.removeLast();
                tmp.add(node.val);
                // 先右后左加入下层节点
                if(node.right != null) deque.addFirst(node.right);
                if(node.left != null) deque.addFirst(node.left);
            }
            res.add(tmp);
        }
        return res;
    }
}
