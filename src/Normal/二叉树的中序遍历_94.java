package Normal;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 二叉树的中序遍历_94 {
    public static List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> inorder = new ArrayList<>();
        if (root == null) return inorder;

        Stack<TreeNode> nodeStack = new Stack<>();

        while (root != null || !nodeStack.empty()) {
            while (root != null) {
                nodeStack.push(root);
                root = root.left;
            }
            root = nodeStack.pop();
            inorder.add(root.val);
            root = root.right;
        }

        return inorder;
    }

    public static void main(String[] args) {

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
