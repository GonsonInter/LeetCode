package 剑指.Normal;

public class 把数字翻译成字符串_46 {

//    /**
//     * 动态规划
//     */
//    public static int translateNum(int num) {
//        char[] nums = String.valueOf(num).toCharArray();
//        int[] dp = new int[nums.length + 1];
//        dp[0] = 1;
//        dp[1] = 1;
//        for (int i = 2; i <= nums.length; i ++) {
//            String cur = "" + nums[i - 2] + nums[i -  1];
////            if (nums[i - 1] == '0') {
////                if (nums[i - 2] == '1' || nums[i - 2] == '2')   dp[i] = dp[i - 1] + dp[i - 2];
////                else  dp[i] = dp[i - 1];
////                continue;
////            }
//            if (cur.compareTo("25") <= 0 && nums[i - 2] != '0') {
//                dp[i] = dp[i - 2] + dp[i - 1];
//            }   else
//                dp[i] = dp[i - 1];
//        }
//        return dp[nums.length];
//    }


    /**
     * 大神题解
     */
    public static int translateNum(int num) {
        String s = String.valueOf(num);
        int a = 1, b = 1;
        for(int i = 2; i <= s.length(); i++) {
            String tmp = s.substring(i - 2, i);
            int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
            b = a;
            a = c;
        }
        return a;
    }


    public static void main(String[] args) {
        System.out.println(translateNum(100538));
    }
}
