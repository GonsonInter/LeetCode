package Easy;

public class 最大子序和_53 {

//    /**
//     * 贪心算法
//     * 用maxSum存储最大值，currentSum存储当前的和，遍历数组，如果当前的和为负数，则丢弃它，并赋值为当前的数。
//     *
//     */
//    public static int maxSubArray(int[] nums) {
//        int maxSum = Integer.MIN_VALUE;
//        int currentSum = 0;
//        for (int num : nums) {
//            if (currentSum < 0) currentSum = num;
//            else  currentSum += num;
//            if (currentSum > maxSum) maxSum = currentSum;
//        }
//        return maxSum;
//    }


    /**
     * 动态规划算法
     * 因此我们只需要求出每个位置的 f(i)f(i)，然后返回 ff 数组中的最大值即可。那么我们如何求 f(i)f(i) 呢？我们可以考虑 \textit{nums}[i]nums[i] 单独成为一段还是加入 f(i-1)f(i−1) 对应的那一段，这取决于 \textit{nums}[i]nums[i] 和 f(i-1) + \textit{nums}[i]f(i−1)+nums[i] 的大小，我们希望获得一个比较大的，于是可以写出这样的动态规划转移方程：
     *
     * f(i) = max { f(i-1) + nums[i], nums[i] }
     * f(i)=max{f(i−1)+nums[i],nums[i]}
     *
     * 不难给出一个时间复杂度 O(n)、空间复杂度 O(n) 的实现，即用一个 f 数组来保存 f(i) 的值，用一个循环求出所有 f(i)。
     * 考虑到 f(i) 只和 f(i−1) 相关，于是我们可以只用一个变量 prev 来维护对于当前 f(i) 的 f(i−1) 的值是多少，从而让空间复杂度降低到 O(1)，
     * 这有点类似「滚动数组」的思想。
     */
    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int prev = 0;
        for (int num : nums) {
            prev = Math.max(num, prev + num);
            maxSum = Math.max(prev, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    }
}
