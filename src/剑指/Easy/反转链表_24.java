package 剑指.Easy;

import java.util.List;
import java.util.Stack;

public class 反转链表_24 {

//    /**
//     * 递归实现
//     */
//    public ListNode reverseList(ListNode head) {
//        if (head == null || head.next == null)   return head;
//        ListNode res = reverseList(head.next);
//        head.next.next = head;
//        head.next = null;
//        return res;
//    }

//    /**
//     * 迭代实现,利用辅助栈
//     * 注意边界条件，栈空、节点空
//     */
//    public ListNode reverseList(ListNode head) {
//        Stack<ListNode> stk = new Stack<>();
//        while (head != null) {
//            stk.push(head);
//            head = head.next;
//        }
//        if (!stk.empty()) {
//            head = stk.pop();
//            ListNode node = head;
//            while (!stk.empty()) {
//                node.next = stk.pop();
//                node = node.next;
//            }
//            node.next = null;
//        }   else head = null;
//
//        return head;
//    }


    /**
     * 双指针实现
     * 原链表的头结点就是反转之后链表的尾结点，使用 headhead 标记 .
     * 定义指针 cur，初始化为 head .
     * 每次都让 head 下一个结点的 next 指向 cur ，实现一次局部反转
     * 局部反转完成之后，cur 和 head 的 next 指针同时 往前移动一个位置
     * 循环上述过程，直至 cur 到达链表的最后一个结点 .
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) { return null; }
        ListNode cur = head;
        while (head.next != null) {
            ListNode t = head.next.next;
            head.next.next = cur;
            cur = head.next;
            head.next = t;
        }
        return cur;

    }

}
