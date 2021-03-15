package 剑指.Normal;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class 队列的最大值Ⅱ_59 {


    /**
     * 维护一个单调递减的双端队列
     * 当前如果有个最大元素进入队列，则比它小的元素不会对求最大值的结果产生影响
     */
    class MaxQueue {

        Queue<Integer> queue;
        Deque<Integer> maxqueue;

        public MaxQueue() {
            queue = new LinkedList<>();
            maxqueue = new LinkedList<>();
        }

        public int max_value() {
            if (maxqueue.isEmpty()) return -1;
            return maxqueue.peekFirst();
        }

        public void push_back(int value) {
            queue.offer(value);
            while (!maxqueue.isEmpty() && maxqueue.peekLast() < value)  maxqueue.removeLast();
            maxqueue.addLast(value);
        }

        public int pop_front() {
            if (!maxqueue.isEmpty() && maxqueue.peekFirst().equals(queue.peek()))   maxqueue.removeFirst();
            if (queue.isEmpty())   return -1;
            return queue.poll();
        }
    }

}
