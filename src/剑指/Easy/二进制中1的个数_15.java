package 剑指.Easy;

public class 二进制中1的个数_15 {

//    /**
//     * 每次对个位数字进行与运算并且原数右移一位
//     */
//    public int hammingWeight(int n) {
//        String s = String.valueOf(n);
//        int count = 0;
//        for (int i = 0; i < s.length(); i ++) {
//            if (s.charAt(i) == '1')  count ++;
//        }
//        return count;
//    }

    /**
     * 方法二：巧用 n \& (n - 1)n&(n−1)
     * (n - 1) 解析： 二进制数字 n最右边的 1 变成 0 ，此 1 右边的 0 都变成 1 。
     * n \& (n - 1) 解析： 二进制数字 n 最右边的 1 变成 0 ，其余不变。
     * 循环 n = n&(n−1), 直到 n = 0， 循环次数就是 1 的个数
     */
    public int hammingWeight(int n) {
        int res = 0;
        while(n != 0) {
            res++;
            n &= n - 1;
        }
        return res;
    }

}
