package 剑指.Easy;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class 打印从1到最大的n位数_17 {


//    /**
//     * 不考虑大数的情况下
//     */
//    public int[] printNumbers(int n) {
//        int maxNum = 0;
//        while (n > 0) {
//            maxNum = maxNum * 10 + 9;
//            n --;
//        }
//        // int maxNum = (int) Math.pow(10, n + 1) - 1;
//
//        int[] nums = new int[maxNum];
//        for (int i = 0; i < maxNum; i ++)
//            nums[i] = i + 1;
//        return nums;
//    }


    /**
     * 考虑大数的情况下，需要变成字符串操作
     * 递归
     */

    int n;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    List<String> res = new ArrayList<>();

    public int[] printNumbers(int n) {
        if (n <= 0) return null;
        this.n = n;
        this.num = new char[n];
        dfs(0);

        int[] sss = new int[res.size() - 1];
        for (int i = 0; i < res.size() - 1; i ++) {
            sss[i] = Integer.parseInt(res.get(i + 1).replace("^\\s*", ""));
        }

        return sss;
    }

    public void dfs(int x) {
        if (x == n) {
            res.add(String.valueOf(num));
            return;
        }
        for (char i : loop) {
            num[x] = i;
            dfs(x + 1);
        }
    }

    public static void main(String[] args) {

    }


}
