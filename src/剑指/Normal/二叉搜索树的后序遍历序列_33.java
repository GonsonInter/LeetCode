package 剑指.Normal;

import sun.reflect.generics.tree.Tree;

import java.util.Stack;

public class 二叉搜索树的后序遍历序列_33 {

//    /**
//     * 递归法
//     *
//     */
//    public boolean verifyPostorder(int[] postorder) {
//
//        return recur(postorder, 0, postorder.length - 1);
//    }
//
//    public boolean recur(int[] postorder, int left, int right) {
//        // 如果left = right，那么这个子树只有一个节点，可以形成排序二叉树
//        // 如果left < right，那么这个子树没有节点，也是排序二叉树
//        if (left >= right)  return true;
//        //因为数组中最后一个值postorder[right]是根节点，这里从左往右找出第一个比
//        //根节点大的值，他后面的都是根节点的右子节点（包含当前值，不包含最后一个值，
//        //因为最后一个是根节点），他前面的都是根节点的左子节点
//        int root = postorder[right];
//        int mid = 0;
//        while (postorder[mid] < root)  mid ++;
//        //因为postorder[mid]前面的值都是比根节点root小的，
//        //我们还需要确定postorder[mid]后面的值都要比根节点root大，
//        //如果后面有比根节点小的直接返回false
//        for (int temp = mid + 1; temp < right; temp ++)
//            if (postorder[temp] < root)     return false;
//        //然后对左右子节点进行递归调用
//        return recur(postorder, left, mid - 1) && recur(postorder, mid, right - 1);
//    }


    /**
     * 使用辅助栈
     * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/solution/di-gui-he-zhan-liang-chong-fang-shi-jie-jue-zui-ha/
     *
     * 将一个二叉排序树的后根遍历结果逆序，可以发现规律
     * 挨着的两个数如果arr[i]<arr[i+1]，那么arr[i+1]一定是arr[i]的右子节点
     * 如果arr[i]>arr[i+1]，那么arr[i+1]一定是arr[0]……arr[i]中某个节点的左子节点，并且这个值是大于arr[i+1]中最小的
     *
     * 遍历数组的所有元素，如果栈为空，就把当前元素压栈。如果栈不为空，并且当前元素大于栈顶元素，说明是升序的，那么就说明当前元素是栈顶元素的右子节点，
     * 就把当前元素压栈，如果一直升序，就一直压栈。当前元素小于栈顶元素，说明是倒序的，说明当前元素是某个节点的左子节点，
     * 我们目的是要找到这个左子节点的父节点，就让栈顶元素出栈，直到栈为空或者栈顶元素小于当前值为止，其中最后一个出栈的就是当前元素的父节点。
     */
    public boolean verifyPostorder(int[] postorder) {

        Stack<Integer> stack = new Stack<>();
        int parent = Integer.MAX_VALUE;
        //注意for循环是倒叙遍历的
        for (int i = postorder.length - 1; i >= 0; i --) {
            //当如果前节点小于栈顶元素，说明栈顶元素和当前值构成了倒叙，
            //说明当前节点是前面某个节点的左子节点，我们要找到他的父节点
            int cur = postorder[i];
            while (!stack.empty() && stack.peek() > cur) {
                parent = stack.pop();
            }
            //只要遇到了某一个左子节点，才会执行上面的代码，才会更
            //新parent的值，否则parent就是一个非常大的值，也就
            //是说如果一直没有遇到左子节点，那么右子节点可以非常大
            if (cur > parent)   return false;
            //入栈
            stack.push(cur);
        }

        return true;
    }

}
