package Normal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 二叉树的前序遍历_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> preorder = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();

        while (!stk.empty() || root != null) {
            while (root != null) {
                preorder.add(root.val);
                stk.push(root.right);
                root = root.left;
            }
            root = stk.pop();
        }

        return preorder;
    }
}

