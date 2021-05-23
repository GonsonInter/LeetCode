package 剑指.Normal;

public class 股票的最大利润_63 {


//    /**
//     * 直接遍历
//     * 这是可多次买卖股票的解法
//     */
//    public int maxProfit(int[] prices) {
//        int maxProfit = 0;
//        int minValue = Integer.MAX_VALUE;
//
//        for (int price : prices) {
//
//            if (price > minValue) {
//                maxProfit += price - minValue;
//                minValue = price;
//            } else
//                minValue = Math.min(minValue, price);
//
//        }
//
//        return maxProfit;
//    }

//    /**
//     * 直接遍历
//     */
//    public int maxProfit(int[] prices) {
//        int maxValue = 0;
//        int min = Integer.MAX_VALUE;
//        for (int price : prices) {
//            if (price < min)
//                min = price;
//            else
//                maxValue = Math.max(maxValue, price - min);
//        }
//        return maxValue;
//    }


    /**
     * 动态规划
     */
    public int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE, profit = 0;
        for (int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }


}
