package 剑指.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 和为s的连续正数序列Ⅱ_57 {

//    /**
//     * 使用滑动窗口,双指针，两个指针只能向右滑动不能向左滑动
//     */
//    public int[][] findContinuousSequence(int target) {
//        if (target < 3)     return new int[][] {};
//        int i = 1, j = 2;
//        ArrayList<int[]> res = new ArrayList<>();
//        while (j <= Math.ceil(target / 2.0) && i < j) {
//            int sum = (int) ((i + j) / 2.0 * (j - i + 1));
//            if (target == sum) {
//                int[] seq = new int[j - i + 1];
//                for (int k = 0; k <= j - i; k ++)   seq[k] = k + i;
//                res.add(seq);
//                i ++;
//            }
//            else if (target < sum)     i ++;
//            else    j ++;
//        }
//        return res.toArray(new int[res.size()][]);
//    }


    /**
     * 用一个变量来存储当前的序列和，这样就不用每次都用求和公式求，省区时间。
     * 乘除法比加减法更耗时
     */
    public static int[][] findContinuousSequence(int target) {
        int i = 1, j = 2, s = 3;
        List<int[]> res = new ArrayList<>();
        while(i < j) {
            if(s == target) {
                int[] ans = new int[j - i + 1];
                for(int k = i; k <= j; k++)
                    ans[k - i] = k;
                res.add(ans);
            }
            if(s >= target) {
                s -= i;
                i++;
            } else {
                j++;
                s += j;
            }
        }
        return res.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        findContinuousSequence(9);
    }
}
