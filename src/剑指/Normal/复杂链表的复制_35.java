package 剑指.Normal;

import java.util.HashMap;
import java.util.HashSet;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class 复杂链表的复制_35 {

//    /**
//     * 深度优先遍历
//     * 使用HashMap来标记被复制的节点和被复制的节点的关系
//     */
//    HashMap<Node, Node> visited = new HashMap<>();
//    public Node copyRandomList(Node head) {
//        if (head == null)   return null;
//        Node node = new Node(head.val);
//        if (!visited.containsKey(head)) {
//            visited.put(head, node);
//            node.next = copyRandomList(head.next);
//            node.random = copyRandomList(head.random);
//        }
//        return visited.get(head);
//
//    }

//    /**
//     * 循环复制两遍
//     * 使用HashMap来标记被复制的节点和被复制的节点的关系
//     */
//    public Node copyRandomList(Node head) {
//        if (head == null)   return null;
//        HashMap<Node, Node> visited = new HashMap<>();
//        Node node = new Node(head.val);
//        visited.put(head, node);
//
//        //第一次遍历创建一个没有random域的链表并且用HashMap标记对应关系
//        for (Node n = head.next, p = node; n != null; n = n.next, p = p.next) {
//            p.next = new Node(n.val);
//            visited.put(n, p.next);
//        }
//        // 第二次便利从对应关系中寻找节点，并接入random
//        for (Node n = head, p = node; n != null; n = n.next, p = p.next) {
//            p.random = visited.get(n.random);
//        }
//
//        return node;
//    }


    /**
     * 拼接加拆分法，将原链表的节点复制成两份，再拆分他们
     *
     * 1 -> 2 -> 3 -> 4 复制成 1->1->2->2->3->3->4->4
     */
    public Node copyRandomList(Node head) {
        if (head == null)   return null;
        // 复制
        for (Node n = head; n != null; n = n.next.next) {
            Node copy = new Node(n.val);
            copy.next = n.next;
            n.next = copy;
        }

        // 2. 构建各新节点的 random 指向
        Node cur = head;
        while(cur != null) {
            if(cur.random != null)
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }

        // 拆分
        cur = head.next;
        Node pre = head, res = head.next;
        while(cur.next != null) {
            pre.next = pre.next.next;
            cur.next = cur.next.next;
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = null; // 单独处理原链表尾节点
        return res;      // 返回新链表头节点

    }

}
