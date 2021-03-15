package 剑指.Hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class 数据流中的中位数_41 {


//    /**
//     * 数据全部存在一个ArrayList中
//     * 每次需要找中位数的时候，就排序，这样效率低
//     */
//    class MedianFinder {
//        ArrayList<Integer> nums;
//        /** initialize your data structure here. */
//        public MedianFinder() {
//            nums = new ArrayList<>();
//        }
//        public void addNum(int num) {
//            nums.add(num);
//        }
//        public double findMedian() throws Exception {
//            if (nums.size() == 1)   return nums.get(0);
//            ArrayList<Integer> toBeSorted = nums;
//            Collections.sort(toBeSorted);
//            int mid = (int) Math.ceil(nums.size() / 2.0) - 1;
//            return (nums.size() & 1) == 0 ? (double) (toBeSorted.get(mid) + toBeSorted.get(mid + 1)) / 2 : toBeSorted.get(mid);
//        }
//    }


    /**
     * 维护一个大根堆，一个小根堆
     * 其中大根堆中的数比小根堆中的数要小，且大根堆的长度和小根堆的长度要平均。
     */
    class MedianFinder {

        Queue<Integer> A, B;    // A是大根堆，B是小根堆

        /** initialize your data structure here. */
        public MedianFinder() {
            A = new PriorityQueue<>();
            B = new PriorityQueue<>((o1, o2) -> o2 - o1);
        }
        public void addNum(int num) {
            if (A.size() != B.size()) {
                A.add(num);
                B.add(A.poll());
            }   else {
                B.add(num);
                A.add(B.poll());
            }
        }
        public double findMedian(){
            return A.size() == B.size() ? (A.peek() + B.peek()) / 2.0 : A.peek();
        }
    }
}
