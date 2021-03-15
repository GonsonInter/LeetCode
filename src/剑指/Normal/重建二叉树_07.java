package 剑指.Normal;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


public class 重建二叉树_07 {

//    /**
//     * 递归
//     */
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        if (preorder.length == 0 || inorder.length == 0)    return null;
//        TreeNode tree = null;
//        tree = recur(preorder, inorder, 0, preorder.length - 1, 0, preorder.length - 1);
//        return tree;
//    }
//    public int findIndex(int[] nums, int num) {
//        for (int i = 0; i < nums.length; i ++) {
//            if (nums[i] == num)     return i;
//        }
//        return -1;
//    }
//    public TreeNode recur(int[] preorder, int[] inorder, int prestart, int preend, int ins, int ine) {
//        if (preend < prestart || ine < ins)     return null;
//        int val = preorder[prestart];
//        TreeNode node = new TreeNode(val);
//
//        int findIndex = findIndex(inorder, preorder[prestart]);
//        if (findIndex == -1)    return null;
//        int leftSize = findIndex - ins;
//        int righSize = ine - findIndex;
//        node.left = recur(preorder, inorder, prestart + 1, prestart + leftSize, ins, findIndex - 1);
//        node.right = recur(preorder, inorder, preend - righSize + 1, preend, findIndex + 1, ine);
//
//        return node;
//    }


//    /**
//     * 递归结合HashMap，用哈希表来快速定位节点下标
//     */
//    private Map<Integer, Integer> indexMap;
//    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
//        if (preorder_left > preorder_right) {
//            return null;
//        }
//
//        // 前序遍历中的第一个节点就是根节点
//        int preorder_root = preorder_left;
//        // 在中序遍历中定位根节点
//        int inorder_root = indexMap.get(preorder[preorder_root]);
//
//        // 先把根节点建立出来
//        TreeNode root = new TreeNode(preorder[preorder_root]);
//        // 得到左子树中的节点数目
//        int size_left_subtree = inorder_root - inorder_left;
//        // 递归地构造左子树，并连接到根节点
//        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
//        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
//        // 递归地构造右子树，并连接到根节点
//        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
//        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
//        return root;
//    }
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        int n = preorder.length;
//        // 构造哈希映射，帮助我们快速定位根节点
//        indexMap = new HashMap<Integer, Integer>();
//        for (int i = 0; i < n; i++) {
//            indexMap.put(inorder[i], i);
//        }
//        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
//    }


    /**
     * 迭代
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }

}
