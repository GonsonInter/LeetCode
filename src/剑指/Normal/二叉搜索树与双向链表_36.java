package 剑指.Normal;

public class 二叉搜索树与双向链表_36 {

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };


    /**
     * 中序遍历
     * 用一个指针指向中序遍历结果中的前一个节点，每次遍历就修改节点间指针的指向。
     */
    Node pre = null;
    Node head;
    public Node treeToDoublyList(Node root) {
        if (root == null)   return null;
        recur(root);

        head.left = pre;
        pre.right = head;

        return head;
    }

    public void recur(Node node) {
        if (node == null)   return;

        recur(node.left);

        if (pre != null)  pre.right = node;
        else {  // 表示当前访问的为最左下角节点
            head = node;
        }
        node.left = pre;
        pre = node;

        recur(node.right);

    }
}
