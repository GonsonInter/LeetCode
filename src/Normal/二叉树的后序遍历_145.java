package Normal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class 二叉树的后序遍历_145 {

//    /**
//     * 1、主要思想：
//     * 先取根节点的值，再遍历左子树，再遍历右子树
//     * 步骤：
//     * 步骤一：取根节点的值
//     * 步骤二：遍历左子树
//     * 步骤三：遍历右子树
//     */
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> list=new ArrayList<>();
//        Stack<TreeNode> stack=new Stack<>();
//        while(root!=null||(!stack.empty())){
//            if(root!=null){
//                stack.push(root);//把根节点放入栈中
//                list.add(0,root.val);//步骤一，在index=0处插入根结点的值
//                root=root.right;//步骤二，遍历右子树
//            }
//            else{
//                TreeNode tem=stack.pop();
//                root=tem.left;//步骤三，遍历左子树
//            }
//        }
//        return list;
//    }


    /**
     * 2、用prev记录上一个访问的节点，一个节点的右孩子已经被访问（或没有右孩子），
     * 则能够访问这个节点
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();

        TreeNode prev = null;
        while(root!=null || !stack.empty()){
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                list.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return list;
    }

    public static void main(String[] args) {
    }
}
