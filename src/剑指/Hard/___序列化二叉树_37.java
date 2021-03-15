package 剑指.Hard;

import sun.reflect.generics.tree.Tree;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class ___序列化二叉树_37 {
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<String> res = new ArrayList<>();
        queue.offer(root);
        int level = getLevel(root);
        int count = (int) Math.pow(2, level) - 1;
        int index = 0;
        while (!queue.isEmpty()) {
            if (index ++ >= count)   break;

            TreeNode node = queue.poll();
            res.add(node.val == Integer.MIN_VALUE ? "null" : node.val + "");

            if (node.left == null) {
                TreeNode temp = new TreeNode(Integer.MIN_VALUE);
                queue.offer(temp);
            }   else
                queue.offer(node.left);
            if (node.right == null) {
                TreeNode temp = new TreeNode(Integer.MIN_VALUE);
                queue.offer(temp);
            }   else
                queue.offer(node.right);

        }
        return res.toString();
    }

    public static int getLevel(TreeNode node) {
        if (node == null)   return 0;
        return 1 + Math.max(getLevel(node.left), getLevel(node.right));
    }


    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String[] datas = data.substring(1, data.length() - 1).split(",");
        if (datas.length == 1 && datas[0].equals(""))  return null;
        return recur(datas, 0);
    }

    public static TreeNode recur(String[] datas, int index) {
        if (datas[index].replaceAll(" ", "").equals("null"))   return null;
        TreeNode newNode = new TreeNode(Integer.parseInt(datas[index].replaceAll(" ", "")));
        if (index <= datas.length / 2 - 1) {    // 当前index不在二叉树的最后一层节点上，继续递归
            newNode.left = recur(datas, 2 * index + 1);
            newNode.right = recur(datas, 2 * index + 2);
        }
        return newNode;
    }

    public static void main(String[] args) {



    }
}
