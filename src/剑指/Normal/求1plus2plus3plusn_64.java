package 剑指.Normal;

public class 求1plus2plus3plusn_64 {

//    /**
//     * 利用 &&或 || 的短路原则进行判断
//     * 递归
//     */
//    public int sumNums(int n) {
//        boolean b = n > 0 && (n += sumNums(n - 1)) > 0;
//        return n;
//    }
//    public int sumNums(int n) {
//        boolean b = n == 0 || (n += sumNums(n - 1)) > 0;
//        return n;
//    }


    /**
     * 快速乘法（俄罗斯农民乘法）
     * 题目数据范围 nn 为 [1,10000][1,10000]，所以 nn 二进制展开最多不会超过 1414 位，我们手动展开 1414 层代替循环即可
     */
    public int sumNums(int n) {
        int ans = 0, A = n, B = n + 1;
        boolean flag;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        return ans >> 1;
    }

    public static void main(String[] args) {

    }
}
