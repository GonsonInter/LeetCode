package 剑指.Easy;

import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class 从尾到头打印链表_06 {


//    /**
//     * 递归算法
//     */
//    private ArrayList<Integer> list = new ArrayList<>();
//    public int[] reversePrint(ListNode head) {
//        recur(head);
//        int[] res = new int[list.size()];
//        for (int i = 0; i < list.size(); i ++) {
//            res[i] = list.get(i);
//        }
//        return res;
//    }
//    public void recur(ListNode node) {
//        if (node.next != null) {
//            recur(node.next);
//            list.add(node.val);
//        }
//    }

//    /**
//     * 辅助栈
//     */
//    public int[] reversePrint(ListNode head) {
//        Stack<Integer> s = new Stack<>();
//        ListNode item = head;
//        while (item != null) {
//            s.push(item.val);
//            item = item.next;
//        }
//        int[] res = new int[s.size()];
//        int size = s.size();
//        for (int i = 0; i < size; i++) {
//            res[i] = s.pop();
//        }
//        return res;
//    }


}
