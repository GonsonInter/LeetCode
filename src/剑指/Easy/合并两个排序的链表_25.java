package 剑指.Easy;

import com.sun.org.apache.bcel.internal.generic.RET;

public class 合并两个排序的链表_25 {

//    /**
//     * 双指针分别指向两个链表扫描
//     */
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        ListNode res = new ListNode(Integer.MIN_VALUE);
//        ListNode p = res;
//        while (l1 != null && l2 != null) {
//            if (l1.val < l2.val) {
//                p.next = l1;
//                l1 = l1.next;
//            }   else {
//                p.next = l2;
//                l2 = l2.next;
//            }
//            p = p.next;
//        }
//        p.next = l1 == null ? l2 : l1;
//        return res.next;
//    }


    /**
     * 递归算法
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)   return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val > l2.val) {
            l1.next = mergeTwoLists(l1, l2.next);
            return l1;
        }   else {
            l2.next = mergeTwoLists(l1.next, l2);
            return l2;
        }
    }

}
