package 剑指.Normal;

public class 剪绳子Ⅱ_14 {

//    /**
//     * 贪婪算法
//     */
//    public int cuttingRope(int n) {
//        if (n < 4)  return n - 1;
//        long res = 1;
//        while (n > 4) {
//            res = (3 * res) % 1000000007;
//            n -= 3;
//        }
//        return  (int) (res * n % 1000000007);
//    }


    /**
     * 动态规划
     * 超时
     */
    public int cuttingRope(int n) {
        long[] dp = new long[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i ++) {
            for (int j = 2; j < i; j ++) {
                dp[i] = Math.max(dp[i], Math.max(j * dp[i - j], (long) j * (i - j) % 1000000007));
            }
        }
        return (int) dp[n];
    }

}
