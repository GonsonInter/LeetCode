package 剑指.Normal;

public class 剪绳子Ⅰ_14 {

//    /**
//     * 贪婪算法
//     * 通过数学证明，发现剪出尽可能多的长度为3的片段，可以使得乘积最大,其次切成 2
//     * 当遇到 4 的时候分为两个 2， 因为 2*2 > 3*1
//     */
//    public static int cuttingRope(int n) {
//        if (n <= 1) return 0;
//        if (n == 2) return 1;
//        if (n == 3) return 2;
//        if (n == 4) return 4;
//        int res = 1;
//        while (n >= 5) {
//            res *= 3;
//            n -= 3;
//        }
//        return res * n;
//    }


    /**
     * 动态规划
     * 我们想要求长度为n的绳子剪掉后的最大乘积，可以从前面比n小的绳子转移而来
     * 用一个dp数组记录从0到n长度的绳子剪掉后的最大乘积，也就是dp[i]表示长度为i的绳子剪成m段后的最大乘积，初始化dp[2] = 1
     * 我们先把绳子剪掉第一段（长度为j），如果只剪掉长度为1，对最后的乘积无任何增益，所以从长度为2开始剪
     * 剪了第一段后，剩下(i - j)长度可以剪也可以不剪。如果不剪的话长度乘积即为j * (i - j)；如果剪的话长度乘积即为j * dp[i - j]。取两者最大值max(j * (i - j), j * dp[i - j])
     * 第一段长度j可以取的区间为[2,i)，对所有j不同的情况取最大值，因此最终dp[i]的转移方程为
     * dp[i] = max(dp[i], max(j * (i - j), j * dp[i - j]))
     * 最后返回dp[n]即可
     */
    public static int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for(int i = 3; i < n + 1; i++){
            for(int j = 2; j < i; j++){
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(cuttingRope(10));
    }
}
