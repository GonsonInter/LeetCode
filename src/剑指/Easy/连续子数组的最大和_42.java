package 剑指.Easy;

public class 连续子数组的最大和_42 {

//    /**
//     * 扫描一遍，记录最大和以及当前子序列的和。如果一个数加上他的前序列和比自己小，就抛弃前序列，从当前开始。
//     * 如果某子序列和比最大和要大，就更新最大和。
//     */
//    public static int maxSubArray(int[] nums) {
//        int max = nums[0];
//        int current = 0;
//        for (int num : nums) {
//            current = Math.max(current + num, num);
//            max = Math.max(current, max);
//        }
//        return max;
//    }


    /**
     * 动态规划
     * 1.状态定义：状态数组dp， dp[i]表示，包含nums[i]的最大子序和。
     * 2.状态转移方程：如果dp[i-1] <= 0, dp[i]=nums[i]， 否则，dp[i] = dp[i-1] + nums[i]
     * 3.初始状态：
     */
    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i ++) {
            if (i == 0)  dp[i] = nums[i];
            else {
                dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            }
        }
        int max = dp[0];
        for (int num : dp)
            if (num > max)  max = num;

        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    }
}
