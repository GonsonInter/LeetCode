package 剑指.Normal;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class 把数组排成最小的数_45 {

    /**
     * 实际上是一个排序问题，对于两个字符串 x和y， 如果x + y > y + x, 则x > y, 如果 x+y < y+x，则x < y.
     * 调用任何一种排序都行
     */

//    /**
//     * 编写快速排序
//     */
//    public String minNumber(int[] nums) {
//        String[] str = new String[nums.length];
//        for (int i = 0; i < str.length; i ++) {
//            str[i] = String.valueOf(nums[i]);
//        }
//        quickSort(str, 0, str.length - 1);
//        StringBuffer sb = new StringBuffer();
//        for (String s : str)
//            sb.append(s);
//        return sb.toString();
//    }
//
//    public void quickSort(String[] str, int left, int right) {
//        int i = left, j = right;
//        while (i < j) {
//            while ((str[j] + str[left]).compareTo(str[left] + str[j]) >= 0 && i < j)   j --;
//            while ((str[i] + str[left]).compareTo(str[left] + str[i]) <= 0 && i < j)   i ++;
//            swap(str, i, j);
//        }
//        swap(str, left, i);
//        quickSort(str, left, i - 1);
//        quickSort(str, i + 1, right);
//    }
//
//    public void swap(String[] str, int i, int j) {
//        String temp = str[i];
//        str[i] = str[j];
//        str[j] = temp;
//    }


    /**
     * 另外一个大神提出用小根堆完成，非常巧妙，只需要传入比较器就行
     */
    public String minNumber(int[] nums) {
        Queue<String> heap = new PriorityQueue<>((s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        for (int num : nums)
            heap.offer(String.valueOf(num));
        StringBuffer sb = new StringBuffer();
        while (!heap.isEmpty()) {
            sb.append(heap.poll());
        }
        return sb.toString();
    }


}
