package Easy;

public class 买卖股票的最佳时机_121 {

//    /**
//     * 假如计划在第 i 天卖出股票，那么最大利润的差值一定是在[0, i-1] 之间选最低点买入；所以遍历数组，
//     * 依次求每个卖出时机的的最大差值，再从中取最大值。
//     */
//    public int maxProfit(int[] prices) {
//        int minPrice = Integer.MAX_VALUE;
//        int maxProfit = 0;
//        for (int num : prices) {
//            if (num < minPrice) {
//                minPrice = num;
//            }
//            if (num - minPrice > maxProfit) {
//                maxProfit = num - minPrice;
//            }
//        }
//        return maxProfit;
//    }


    /**
     * 动态规划
     * f(i) = max { f(i - 1), price(i) - min }
     */
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        int minPrice = prices[0];
        for (int i = 0; i < prices.length; i ++) {
            if (i == 0) dp[i] = 0;
            else {
                dp[i] = Math.max(dp[i - 1], prices[i] - minPrice);
                minPrice = Math.min(minPrice, prices[i]);
            }
        }
        return dp[dp.length - 1];
    }
}
