package Easy;

public class 买卖股票的最佳时机Ⅱ_122 {
//    /**
//     * 循环遍历一次
//     */
//    public static int maxProfit(int[] prices) {
//        int maxProfit = 0;
//
//        for (int i = 0 ; i < prices.length - 1; i ++) {
//            if (prices[i + 1] > prices[i])  maxProfit += prices[i + 1] - prices[i];
//        }
//        return maxProfit;
//    }


    /**
     * 动态规划算法
     * 不允许持有股票的同时再购入股票，因此持有股票的情况就两种，一种是未持有，另一种是持有一种股票
     * 用dp[][0]表示持有股票0张的状态，dp[][1]表示持有股票1张的状态。
     */
    public static int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i ++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] {7,1,5,3,6,4}));
    }
}
