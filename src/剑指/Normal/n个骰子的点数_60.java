package 剑指.Normal;

import java.util.ArrayList;
import java.util.List;

public class n个骰子的点数_60 {


    /**
     * 动态规划
     */
    public double[] dicesProbability(int n) {
        int[][] dp = new int[n + 1][6 * n + 1];
        for (int i = 0; i <= 6; i ++) {
            dp[1][i] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= 6 * n; j++) {
                for (int k = 1; k <= 6 && k <= j; k ++) {
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }

        double all = Math.pow(6, n);
        double[] res = new double[5 * n + 1];

        for (int i = 0; i < 5 * n + 1; i ++)
            res[i] = dp[n][n + i] / all;

        return res;
    }

    public static void main(String[] args) {

    }
}
