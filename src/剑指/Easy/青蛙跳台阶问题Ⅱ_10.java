package 剑指.Easy;

public class 青蛙跳台阶问题Ⅱ_10 {

//    /**
//     * 递归求法
//     * 超时
//     */
//    public int numWays(int n) {
//        if (n == 0) return 1;
//        if (n == 1 || n == 2) return n;
//        return (numWays(n - 1) + numWays(n - 2)) % 1000000007;
//    }

    /**
     * 动态规划
     */
    public int numWays(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i ++) {
            if (i == 1) dp[i] = 1;
            else if (i == 2) dp[i] = 2;
            else dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }
}
