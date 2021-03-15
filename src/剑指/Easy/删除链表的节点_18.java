package 剑指.Easy;

//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode(int x) {
//        val = x;
//    }
//}

import java.util.List;

public class 删除链表的节点_18 {

//    /**
//     * 维护一个单指针
//     */
//    public ListNode deleteNode(ListNode head, int val) {
//        if (head.val == val) return head.next;
//        ListNode temp = head;
//        while (temp.next != null) {
//            if (temp.next.val == val) {
//                temp.next = temp.next.next;
//                break;
//            }
//            temp = temp.next;
//        }
//        return head;
//    }

//    /**
//     * 为链表增加一个额外的头指针，则不需要判断head的位置
//     */
//    public ListNode deleteNode(ListNode head, int val) {
//        ListNode head0 = new ListNode(Integer.MAX_VALUE);
//        head0.next = head;
//        ListNode temp = head0;
//        while (temp.next != null) {
//            if (temp.next.val == val) {
//                temp.next = temp.next.next;
//                break;
//            }
//            temp = temp.next;
//        }
//        return head0.next;
//    }

    /**
     * 双指针
     */
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        if (head.val == val) {
            return head.next;
        }

        ListNode preNode = head;
        ListNode curNode = head.next;
        while (curNode != null && curNode.val != val) {
            preNode = curNode;
            curNode = curNode.next;
        }

        preNode.next = (curNode==null) ? null : curNode.next;
        return head;
    }

}
