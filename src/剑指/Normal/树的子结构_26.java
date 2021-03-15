package 剑指.Normal;

//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode(int x) {
//        val = x;
//    }
//}

import sun.reflect.generics.tree.Tree;

public class 树的子结构_26 {

    /**
     * 递归判断是否为子树
     * 先序遍历 A，对每个节点都判断是否存在子树 B。
     * 先序遍历函数 isSubStructure，判断子树函数 recur。
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null)  return false;
        return recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);      //先序遍历
    }

    public boolean recur(TreeNode A, TreeNode B) {
        if (B == null)  return true;
        if (A == null)  return false;
        if (A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }


//    /**
//     * 这样写不行，有坑
//     * 当发现某一个数与A上的节点相等时，下次递归就会去掉这个节点去比这个节点的子树，当发现出问题以后，无法找回这个点
//     */
//    public boolean isSubStructure(TreeNode A, TreeNode B) {
//        if (B == null || A == null) return false;
//        return recur(A, B);
//    }
//
//    public boolean recur(TreeNode A, TreeNode B) {
//        if (B == null) return true;
//        if (A == null) return false;
//        if (A.val == B.val)
//            return recur(A.left, B.left) && recur(A.right, B.right) || recur(A.left, B) || recur(A.right, B);
//        else
//            return recur(A.left, B) || recur(A.right, B);
//    }

}
