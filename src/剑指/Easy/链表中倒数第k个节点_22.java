package 剑指.Easy;

import java.util.List;

public class 链表中倒数第k个节点_22 {

//    /**
//     * 添加了一个头结点用双指针
//     */
//    public ListNode getKthFromEnd(ListNode head, int k) {
//        ListNode head0 = new ListNode(-999);
//        head0.next = head;
//        ListNode front = head0, back = head0;
//        while (back.next != null) {
//            back = back.next;
//            if (k > 0) k--;
//            else front = front.next;
//        }
//        return k > 0 ? null : front.next;
//    }


    /**
     * 不添加头节点用双指针，可能需要额外的判断
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k <= 0) return null;
        ListNode former = head, later = head;
        for (int i = 0; i < k; i ++) {
            later = later.next;
            if (later == null) return null;
        }
        while (later != null) {
            former = former.next;
            later = later.next;
        }
        return former;
    }

}
