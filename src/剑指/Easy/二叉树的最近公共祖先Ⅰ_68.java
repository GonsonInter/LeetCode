package 剑指.Easy;

import java.util.ArrayList;
import java.util.List;

public class 二叉树的最近公共祖先Ⅰ_68 {

//    /**
//     * 递归
//     * 利用二叉搜索树的性质
//     */
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        return recur(root, p, q);
//    }
//
//    public TreeNode recur (TreeNode node, TreeNode p, TreeNode q) {
//        if (node == null)   return null;
//        if ((p.val < node.val && q.val > node.val) || (p.val > node.val && q.val < node.val))   return node;
//        else if (p.val < node.val && q.val < node.val)  return recur(node.left, p, q);
//        else  return recur(node.right, p, q);
//    }


//    /**
//     * 两次遍历，分别记录p和q的路径
//     * 注意利用二叉排序树的性质
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
//        List<TreeNode> path = new ArrayList<>();
//        TreeNode node = root;
//        while (node != null && node.val != p.val) {
//            path.add(node);
//            if (node.val < p.val) node = node.right;
//            else node = node.left;
//        }
//        path.add(p);
//        return path;
//    }


    /**
     * 一次遍历
     * 利用二叉搜索树的性质
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;
        while (node.val != p.val && node.val != q.val) {
            if (node.val < p.val && node.val < q.val)
                node = node.right;
            if (node.val > p.val && node.val > q.val)
                node = node.left;
            else break;
        }
        return node;
    }

}
