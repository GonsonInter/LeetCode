package 剑指.Easy;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class 滑动窗口的最大值Ⅰ_59 {


//    /**
//     * 暴力破解法
//     * 时间复杂度为O(nk)，因为在查找最小元素的时候的时间复杂度是O(k)
//     */
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        if (nums.length == 0)   return new int[] {};
//        int[] res = new int[nums.length - k + 1];
//        for (int i = 0; i < nums.length - k + 1; i ++) {
//            int max = nums[i];
//            for (int j = i; j < i + k; j ++) {
//                max = Math.max(max, nums[j]);
//            }
//            res[i] = max;
//        }
//        return res;
//    }


    /**
     * 使用单调队列，使得每次查找最小值的时候的时间复杂度为O(1)
     * 窗口对应的数据结构为 双端队列
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for(int j = 0, i = 1 - k; j < nums.length; i++, j++) {
            // 删除 deque 中对应的 nums[i-1]
            if(i > 0 && deque.peekFirst() == nums[i - 1])
                deque.removeFirst();
            // 保持 deque 递减
            while(!deque.isEmpty() && deque.peekLast() < nums[j])
                deque.removeLast();
            deque.addLast(nums[j]);
            // 记录窗口最大值
            if(i >= 0)
                res[i] = deque.peekFirst();
        }
        return res;

    }

}
