package 剑指.Easy;

public class 两个链表的第一个公共节点_52 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    /**
     * 双指针
     * 设A链表的长度为 a ，B链表的长度为 b ， 公共链表的长度为 c。
     * 头节点 headA 到 node 前，共有 a - c个节点；
     * 头节点 headB 到 node 前，共有 b - c个节点；
     * 定义两个指针遍历A和B
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA;
        ListNode l2 = headB;
        while (l1 != l2) {
            l1 = l1 == null ? headB : l1.next;
            l2 = l2 == null ? headA : l2.next;
        }
        return l1;
    }

}
