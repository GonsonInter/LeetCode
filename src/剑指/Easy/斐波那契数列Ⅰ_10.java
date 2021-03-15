package 剑指.Easy;

public class 斐波那契数列Ⅰ_10 {

//    /**
//     * 递归
//     * 超时
//     */
//    public int fib(int n) {
//        if (n == 0)  return 0;
//        if (n == 1)  return 1;
//        return (fib(n - 1) + fib(n - 2)) % 1000000007;
//    }

//    /**
//     * 动态规划
//     */
//    public int fib(int n) {
//        int[] dp = new int[n + 1];
//        for (int i = 0; i <= n; i ++) {
//            if (i == 0) dp[i] = 0;
//            else if (i == 1) dp[i] = 1;
//            else dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
//        }
//        return dp[n];
//    }

    /**
     * 强行计算
     */
    public int fib(int n) {
        if (n == 0 || n == 1) return n;
        int a = 0, b = 1;
        for (int i = 2; i <= n; i ++) {
            b = a + b;
            a = b - a;
        }
        return b;
    }
}
