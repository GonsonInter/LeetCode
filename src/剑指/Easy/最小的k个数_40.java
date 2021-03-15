package 剑指.Easy;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class 最小的k个数_40 {

//    /**
//     * 排序
//     */
//    public int[] getLeastNumbers(int[] arr, int k) {
//        Arrays.sort(arr);
//        int[] res = new int[k];
//        if (k >= 0) System.arraycopy(arr, 0, res, 0, k);
//        return res;
//    }

//    /**
//     * 快速排序
//     */
//    public static int [] getLeastNumbers(int[] arr, int k) {
//        quickSort(arr, 0, arr.length - 1);
//        return Arrays.copyOf(arr, k);
//    }
//
//    public static void quickSort(int[] nums, int start, int end) {
//        if (start >= end)   return;
//        int i = start, j = end;
//        int pivot = start;
//        while (i < j) {
//            while (nums[j] >= nums[pivot] && i < j)    j --;
//            swap(nums, pivot, j);
//            pivot = j;
//            while (nums[i] <= nums[pivot] && i < j)    i ++;
//            swap(nums, pivot, i);
//            pivot = i;
//        }
//        quickSort(nums, start, pivot - 1);
//        quickSort(nums, pivot + 1, end);
//    }
//
//    public static void swap(int[] nums, int i, int j) {
//        int temp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = temp;
//    }


//    /**
//     * 堆
//     * 维护一个大小为k的大根堆，然后往里面添加剩下元素，每次poll出堆中的最大元素。
//     * 当数组遍历完成以后，堆中的剩下的元素就是k小元素。
//     *
//     * 注意不是小根堆！小根堆的话需要把全部的元素都入堆，复杂度是 O(NlogN)，就不是 O(NlogK)
//     */
//    public static int [] getLeastNumbers(int[] arr, int k) {
//        heapfy(arr, k);
//        for (int i = k; i < arr.length; i ++) {
//            if (arr[0] > arr[i])  {
//                swap(arr, 0, i);
//                heapfy(arr, k);
//            }
//        }
//        return Arrays.copyOf(arr, k);
//    }
//
//    // 建堆，将数组的0到k之间的元素建成堆
//    public static void heapfy(int[] arr, int length) {
//        int lastNoLeaf = (int) (Math.ceil(length / 2.0) - 1);
//        for (int i = lastNoLeaf; i >= 0; i --) {
//            if ( 2 * i + 1 < length && arr[2 * i + 1] > arr[i])   swap(arr, i, 2 * i + 1);
//            if ( 2 * i + 2 < length && arr[2 * i + 2] > arr[i])   swap(arr, i, 2 * i + 2);
//        }
//    }
//
//    public static void swap(int[] nums, int i, int j) {
//        int temp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = temp;
//    }


    /**
     * 直接用Java优先级队列数据结构表示堆
     */
    public static int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 默认是小根堆，实现大根堆需要重写一下比较器。
        Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int num: arr) {
            if (pq.size() < k) {
                pq.offer(num);
            } else if (num < pq.peek()) {
                pq.poll();
                pq.offer(num);
            }
        }

        // 返回堆中的元素
        int[] res = new int[pq.size()];
        int idx = 0;
        for(int num: pq) {
            res[idx++] = num;
        }
        return res;
    }



    public static void main(String[] args) {
        int[] res = getLeastNumbers(new int[] {5,7,1,2,5,0,6,9,4,30,5,4}, 5);
        for (int num : res) System.out.print( num + " ");
    }

}
