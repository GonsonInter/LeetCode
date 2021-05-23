package 剑指.Easy;

import java.util.ArrayList;
import java.util.Date;

public class _____圆圈中最后剩下的数字_62 {

//    /**
//     * 暴力解法
//     * 超时了
//     */
//    public static int lastRemaining(int n, int m) {
//        ArrayList<Integer> list = new ArrayList<>();
//        for (int i = 0; i < n; i ++)    list.add(i);
//        for (int i = 0; i < n - 1; i ++) {
//            int rmIndex = (m - 1) % list.size();
//            for (int j = 0; j < rmIndex; j ++) {
//                int temp = list.get(0);
//                list.remove(0);
//                list.add(temp);
//            }
//            list.remove(0);
//        }
//        return list.get(0);
//    }


//    /**
//     * 约瑟夫环问题，有数学解法
//     * 递归
//     */
//    public static int lastRemaining(int n, int m) {
//        return recur(n, m);
//    }
//
//    public static int recur(int n, int m) {
//        if (n == 1)  return 0;
//        int x = recur(n - 1, m);
//        return (x + m) % n;
//    }


    /**
     * 迭代
     */
    public static int lastRemaining(int n, int m) {
        int x = 0;
        for (int i = 2; i <= n; i++) {
            x = (x + m) % i;
        }
        return x;
    }



    public static void main(String[] args) {
        System.out.println(lastRemaining(21, 5));
    }
}
